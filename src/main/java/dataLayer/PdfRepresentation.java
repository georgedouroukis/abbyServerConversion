package dataLayer;

import com.google.gson.annotations.Expose;

public class PdfRepresentation {

	@Expose
	private String FileName;
	@Expose
	private String FileContents;
	private String OpenPassword;
	private String OwnerPassword;
	private String LocationPath;

	public String getFileContents() {
		return FileContents;
	}

	public void setFileContents(String fileContents) {
		FileContents = fileContents;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getOpenPassword() {
		return OpenPassword;
	}

	public void setOpenPassword(String openPassword) {
		OpenPassword = openPassword;
	}

	public String getOwnerPassword() {
		return OwnerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		OwnerPassword = ownerPassword;
	}

	public String getLocationPath() {
		return LocationPath;
	}

	public void setLocationPath(String locationPath) {
		LocationPath = locationPath;
	}

}
