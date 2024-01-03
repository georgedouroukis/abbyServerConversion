import java.io.IOException;

import dataLayer.PdfRepresentation;
import utils.PdfConverter;

public class Main {

	public static void main(String[] args) throws IOException {


		String jobId = PdfConverter.createJob();
		
		PdfConverter.waitForJobCompletion(jobId);
		
	}

}
