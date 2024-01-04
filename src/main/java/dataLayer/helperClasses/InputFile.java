package dataLayer.helperClasses;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import dataLayer.PdfRepresentation;

public class InputFile {

	@SerializedName("FileData")
	private PdfRepresentation fileData;

	@SerializedName("OutputDocuments")
	private List<OutputDocument> outputDocuments;

	public PdfRepresentation getFileData() {
		return fileData;
	}

	public void setFileData(PdfRepresentation fileData) {
		this.fileData = fileData;
	}

	public List<OutputDocument> getOutputDocuments() {
		return outputDocuments;
	}

	public void setOutputDocuments(List<OutputDocument> outputDocuments) {
		this.outputDocuments = outputDocuments;
	}

}
