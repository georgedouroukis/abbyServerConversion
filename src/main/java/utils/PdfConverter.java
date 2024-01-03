package utils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PdfConverter {

	private static String workFlowName = "html workflow";
	private static String baseUrl = "http://localhost:8088/";
	public static final MediaType JSON = MediaType.get("application/json");


	public static String createJob() throws IOException {

		String url = baseUrl + "api/workflows/" + workFlowName + "/input/file";
		
		String filePath = "C:\\Users\\George\\Desktop\\__uploads_05_38309905000_aa_2113748s-5.pdf";
		
		String fileName = "__uploads_05_38309905000_aa_2113748s-5.pdf";
		
		PdfRepresentation pdfRepresentation = new PdfRepresentation();
		
		pdfRepresentation.setFileName(fileName);
		
		byte[] encoded = FileHandler.encode(filePath);
		String encodedString = new String(encoded, StandardCharsets.UTF_8); 
		pdfRepresentation.setFileContents(encodedString);
		
		Gson gson = new Gson();
		
		String stringBody = gson.toJson(pdfRepresentation);
		

		OkHttpClient client = new OkHttpClient();
		
		RequestBody body = RequestBody.create(stringBody, JSON);
		
		Request request = new Request.Builder()
		      .url(url)
		      .post(body)
		      .build();
		
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}


	}

	public static String getfile(String jobId) {

		return "";
	}
}
