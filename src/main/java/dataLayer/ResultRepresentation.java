package dataLayer;

import java.util.List;

import com.google.gson.annotations.SerializedName;

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

	public static class InputFile {

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

	public static class JobDocument {

		@SerializedName("OutputDocuments")
		private List<OutputDocument> outputDocuments;

		@SerializedName("Name")
		private String name;

		@SerializedName("IsFailed")
		private Boolean isFailed;

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

	public static class OutputDocument {

		@SerializedName("Files")
		private List<PdfRepresentation> pdfs;

		@SerializedName("FileFormat")
		private String fileFormat;

		@SerializedName("FileFormatId")
		private String fileFormatId;

		@SerializedName("OutputLocation")
		private String outputLocation;

		@SerializedName("Id")
		private String id;

		public List<PdfRepresentation> getPdfs() {
			return pdfs;
		}

		public void setPdfs(List<PdfRepresentation> pdfs) {
			this.pdfs = pdfs;
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

}
