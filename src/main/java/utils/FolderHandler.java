package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FolderHandler {
	
	private Path managedFolder;
	
	public static FolderHandler of(String pathString) {
		FolderHandler fh = new FolderHandler();
		fh.managedFolder= Path.of(pathString);
		return fh;
	}
	
	public void convertAll() throws IOException {
		
		List<Path> files = iterateFiles();
		
		for (Path path: files) {
			String jobId = PdfConverter.createJob(path);
			
			PdfConverter.waitForJobCompletion(jobId);
		}
	}
	
	private FolderHandler() {}
	
	private List<Path> iterateFiles() throws IOException{
		
		String[] extentions = { "pdf" };
		Iterator<File> it = FileUtils.iterateFiles(new File(managedFolder.toString()), extentions, false);
		List<Path> list = new ArrayList<>();
		createExtractionFolder();

		while (it.hasNext()) {
			File file = it.next();
			list.add(Paths.get(file.getAbsolutePath()));
		}
		return list;
	}
	
	private void createExtractionFolder() throws IOException {
		File extractedFolder = new File(managedFolder + "\\extracted");
		if (extractedFolder.exists())
			throw new IOException("\"extracted\" folder already exists");
		else
			extractedFolder.mkdirs();

	}

}
