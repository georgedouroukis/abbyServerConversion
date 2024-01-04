package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import dataLayer.JobRepresentation;
import dataLayer.PdfRepresentation;
import dataLayer.ResultRepresentation;
import dataLayer.helperClasses.JobDocument;
import dataLayer.helperClasses.OutputDocument;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PdfConverter {
	
	private static String htmlFormatType = "OFF_HTML";
	private static String workFlowName = "HttpWorkflow";
	private static String baseUrl = "http://localhost:8088/FineReaderServer14/";
	public static final MediaType JSON = MediaType.get("application/json");
	private static OkHttpClient client = new OkHttpClient().newBuilder().build();
	private static Gson gson = new Gson();


	public static String createJob(Path filePath) throws IOException {

		String url = baseUrl + "api/workflows/" + workFlowName + "/input/file";
				
		String fileName = filePath.getFileName().toString();
		
		PdfRepresentation pdfRepresentation = new PdfRepresentation();
		
		pdfRepresentation.setFileName(fileName);
		
		byte[] encoded = FileHandler.encode(filePath);
		String encodedString = new String(encoded, StandardCharsets.UTF_8); 
		pdfRepresentation.setFileContents(encodedString);
		
		String stringBody = gson.toJson(pdfRepresentation);
		
		RequestBody body = RequestBody.create(stringBody, JSON);
		
		Request request = new Request.Builder()
		      .url(url)
		      .post(body)
		      .build();
		
		try (Response response = client.newCall(request).execute()) {
			
			String jobId = response.body().string();
			System.out.println(jobId);
			jobId = jobId.replace("\"", ""); //response contains extra quotation marks by default

			return jobId;
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
	
	public static String getFile(String jobId) throws IOException {
		
        String url = baseUrl + "api/jobs/" + jobId + "/result?exclude=PagesInfo";

        Request request = new Request.Builder()
  		      .url(url)
  		      .get()
  		      .build();

		try (Response response = client.newCall(request).execute()) {
			
			ResultRepresentation result = gson.fromJson(response.body().string(), ResultRepresentation.class);

			for (JobDocument jobDocument: result.getJobDocuments()) {
				OutputDocument outputDocument = jobDocument.getOutputDocumentOfType(htmlFormatType);

				PdfRepresentation file = outputDocument.getFileWithExtension("htm");

				Path fileName = Path.of(file.getFileName()).getFileName(); //to cut the parent folder
				System.out.println("Output File: " + fileName);
				System.out.println("Output Content: " + file.getFileContents());
				FileHandler.decode(Path.of("C:\\Users\\George\\Desktop\\abbyyConversion\\extracted\\" + fileName), file.getFileContents());
			}
		}
		return "";
	}
	
	

	public static void waitForJobCompletion(String jobId) {
		
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Schedule the polling task
        scheduler.scheduleAtFixedRate(() -> {
            try {
                String status = pollJobStatus(jobId);
                System.out.println("Job status: " + status);

                if ("JS_Complete".equals(status)) {
                	
                    getFile(jobId);
                    scheduler.shutdown();
 
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.SECONDS);

	}
	
	public static String pollJobStatus(String jobId) throws IOException {
        String url = baseUrl + "api/jobs/" + jobId;

        Request request = new Request.Builder()
  		      .url(url)
  		      .get()
  		      .build();

        try (Response response = client.newCall(request).execute()) {
			JobRepresentation job = gson.fromJson(response.body().string(), JobRepresentation.class);
			System.out.println("Progress: " + job.getProgress());
			return job.getState();
			
		}
    }
	private PdfConverter() {}
}
