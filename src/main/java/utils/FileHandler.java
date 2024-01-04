package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

import org.apache.commons.io.FilenameUtils;

public class FileHandler {

	public static byte[] encode(String path) throws IOException {

		byte[] inFileBytes = Files.readAllBytes(Paths.get(path));

		return Base64.getEncoder().encode(inFileBytes);
	}

	public static void decode(String filePath, String encoded) {

		byte[] decoded = Base64.getDecoder().decode(encoded);

		createFile(filePath, decoded);

	}
	
	private static void createFile(String filePath, byte[] contentBytes) {
		Path path = Path.of(filePath);

		try {
			if (!Files.exists(path)) {
				File file = new File(path.toString());
				file.getParentFile().mkdirs();
				Files.createFile(path);

				Files.write(path, contentBytes, StandardOpenOption.WRITE);
			} else {
				throw new IOException("File already exists at the specified path: " + filePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public static String getExtension(String filename) {
	    return FilenameUtils.getExtension(filename);
	}

}
