package dataLayer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobRepresentation {

	@Expose
	@SerializedName("State")
	private String state;

	@Expose
	@SerializedName("Progress")
	private String progress;

	@Expose
	@SerializedName("Id")
	private String id;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
