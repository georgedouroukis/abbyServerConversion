package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class FileHandler {

	public static byte[] encode(String path) throws IOException {

		byte[] inFileBytes = Files.readAllBytes(Paths.get(path));

		return Base64.getEncoder().encode(inFileBytes);
	}

	public static void decode(byte[] encoded, String path) {

		byte[] decoded = Base64.getDecoder().decode(encoded);

		try (FileOutputStream fos = new FileOutputStream(path)) {
			fos.write(decoded);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
