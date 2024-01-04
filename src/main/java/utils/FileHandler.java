package utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;


public class FileHandler {
	
	public static Path managedFolder;

	public static byte[] encode(Path path) throws IOException {

		byte[] inFileBytes = Files.readAllBytes(path);

		return Base64.getEncoder().encode(inFileBytes);
	}

	public static void decode(Path path, String encoded) {

		byte[] decoded = Base64.getDecoder().decode(encoded);

		createFile(path, decoded);

	}
	
	private static void createFile(Path path, byte[] contentBytes) {
		
		try {
			if (!Files.exists(path)) {
				File file = new File(path.toString());
				file.getParentFile().mkdirs();
				Files.createFile(path);

				Files.write(path, contentBytes, StandardOpenOption.WRITE);
			} else {
				throw new IOException("File already exists at the specified path: " + path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public static String getExtension(String filename) {
	    return FilenameUtils.getExtension(filename);
	}
	
	public static List<Path> iterateFiles (Path folderPath) throws IOException{
		
		String[] extentions = { "pdf" };
		Iterator<File> it = FileUtils.iterateFiles(new File(folderPath.toString()), extentions, false);
		List<Path> list = new ArrayList<>();
		createExtractionFolder(folderPath);

		while (it.hasNext()) {
			File file = it.next();
			list.add(Paths.get(file.getAbsolutePath()));
		}
		return list;
	}
	
	public static void createExtractionFolder(Path folderPath) throws IOException {
		File extractedFolder = new File(folderPath + "\\extracted");
		if (extractedFolder.exists())
			throw new IOException("\"extracted\" folder already exists");
		else
			extractedFolder.mkdirs();

	}
	
	

}
