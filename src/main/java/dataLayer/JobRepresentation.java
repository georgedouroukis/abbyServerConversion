package dataLayer;

import com.google.gson.annotations.Expose;

public class JobRepresentation {
	
	@Expose
	private String State;
	@Expose
	private String Progress;
	@Expose
	private String Id;
	
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getProgress() {
		return Progress;
	}
	public void setProgress(String progress) {
		Progress = progress;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}

}
