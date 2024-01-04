import java.io.IOException;

import utils.FolderHandler;

public class Main {

	public static void main(String[] args) throws IOException {

		FolderHandler folderHandler = FolderHandler.of("C:\\Users\\George\\Desktop\\abbyyConversion");

		folderHandler.convertAll();

	}

}
