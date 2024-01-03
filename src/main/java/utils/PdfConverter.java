package utils;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpResponse.BodyHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import dataLayer.JobRepresentation;
import dataLayer.PdfRepresentation;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PdfConverter {

	private static String workFlowName = "HttpWorkflow";
	private static String baseUrl = "http://localhost:8088/FineReaderServer14/";
	public static final MediaType JSON = MediaType.get("application/json");
	private static OkHttpClient client = new OkHttpClient().newBuilder().build();
	private static Gson gson = new Gson();


	public static String createJob() throws IOException {

		String url = baseUrl + "api/workflows/" + workFlowName + "/input/file";
		
		String filePath = "C:\\Users\\George\\Desktop\\__uploads_05_38309905000_aa_2113748s-5.pdf";
		
		String fileName = "__uploads_05_38309905000_aa_2113748s-5.pdf";
		
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
			JobRepresentation job = gson.fromJson(response.body().string(), JobRepresentation.class);
			System.out.println("Progress: "+job.getProgress());
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
}
