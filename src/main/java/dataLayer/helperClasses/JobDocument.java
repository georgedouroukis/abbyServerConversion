package dataLayer.helperClasses;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class JobDocument {

	@SerializedName("OutputDocuments")
	private List<OutputDocument> outputDocuments;

	@SerializedName("Name")
	private String name;

	@SerializedName("IsFailed")
	private Boolean isFailed;
	
	public OutputDocument getOutputDocumentOfType(String type) {
		
		for (OutputDocument doc : outputDocuments) {
			if (doc.getFileFormat().equals(type)) {
				return doc;
			}
		}
		return null;
		
	}

	public List<OutputDocument> getOutputDocuments() {
		return outputDocuments;
	}

	public void setOutputDocuments(List<OutputDocument> outputDocuments) {
		this.outputDocuments = outputDocuments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsFailed() {
		return isFailed;
	}

	public void setIsFailed(Boolean isFailed) {
		this.isFailed = isFailed;
	}

}
