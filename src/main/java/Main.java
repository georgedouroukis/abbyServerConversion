import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import utils.FileHandler;
import utils.PdfConverter;

public class Main {

	public static void main(String[] args) throws IOException {

		List<Path> files = FileHandler.iterateFiles(Path.of("C:\\Users\\George\\Desktop\\abbyyConversion"));
		
		
		for (Path path: files) {
			String jobId = PdfConverter.createJob(path);
			
			PdfConverter.waitForJobCompletion(jobId);
		}
		
		
	}

}
