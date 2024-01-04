package dataLayer.helperClasses;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import dataLayer.PdfRepresentation;
import utils.FileHandler;

public class OutputDocument {

	@SerializedName("Files")
	private List<PdfRepresentation> files;

	@SerializedName("FileFormat")
	private String fileFormat;

	@SerializedName("FileFormatId")
	private String fileFormatId;

	@SerializedName("OutputLocation")
	private String outputLocation;

	@SerializedName("Id")
	private String id;

	public PdfRepresentation getFileWithExtension(String extension) {
		for (PdfRepresentation file : files) {
			if (FileHandler.getExtension(file.getFileName()).equals(extension)) {
				return file;
			}
		}
		return null;
	}

	public List<PdfRepresentation> getFiles() {
		return files;
	}

	public void setPdfs(List<PdfRepresentation> files) {
		this.files = files;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getFileFormatId() {
		return fileFormatId;
	}

	public void setFileFormatId(String fileFormatId) {
		this.fileFormatId = fileFormatId;
	}

	public String getOutputLocation() {
		return outputLocation;
	}

	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
