package dataLayer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PdfRepresentation {

	@Expose
	@SerializedName("FileName")
	private String fileName;
	@Expose
	@SerializedName("FileContents")
	private String fileContents;
	
	@SerializedName("OpenPassword")
	private String openPassword;
	
	@SerializedName("OwnerPassword")
	private String ownerPassword;
	
	@SerializedName("LocationPath")
	private String locationPath;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileContents() {
		return fileContents;
	}

	public void setFileContents(String fileContents) {
		this.fileContents = fileContents;
	}

	public String getOpenPassword() {
		return openPassword;
	}

	public void setOpenPassword(String openPassword) {
		this.openPassword = openPassword;
	}

	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	public String getLocationPath() {
		return locationPath;
	}

	public void setLocationPath(String locationPath) {
		this.locationPath = locationPath;
	}

	
}
