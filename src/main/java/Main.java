import java.io.IOException;

import dataLayer.PdfRepresentation;
import utils.PdfConverter;

public class Main {

	public static void main(String[] args) throws IOException {


//		String jobId = PdfConverter.createJob();
		
		String status = PdfConverter.pollJobStatus("{8EA8FD0C-1777-4E1A-A29B-4E4891F8A240}");
		System.out.println(status);
		
	}

}
