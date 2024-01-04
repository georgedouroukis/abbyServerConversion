package dataLayer;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import dataLayer.helperClasses.InputFile;
import dataLayer.helperClasses.JobDocument;

public class ResultRepresentation {
	@SerializedName("Name")
	private String name;

	@SerializedName("Priority")
	private String priority;

	@SerializedName("InputFiles")
	private List<InputFile> inputFiles;

	@SerializedName("JobDocuments")
	private List<JobDocument> jobDocuments;

	@SerializedName("IsFailed")
	private Boolean isFailed;

	@SerializedName("Id")
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public List<InputFile> getInputFiles() {
		return inputFiles;
	}

	public void setInputFiles(List<InputFile> inputFiles) {
		this.inputFiles = inputFiles;
	}

	public List<JobDocument> getJobDocuments() {
		return jobDocuments;
	}

	public void setJobDocuments(List<JobDocument> jobDocuments) {
		this.jobDocuments = jobDocuments;
	}

	public Boolean getIsFailed() {
		return isFailed;
	}

	public void setIsFailed(Boolean isFailed) {
		this.isFailed = isFailed;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
