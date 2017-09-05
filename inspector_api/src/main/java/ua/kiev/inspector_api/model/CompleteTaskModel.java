package ua.kiev.inspector_api.model;

public class CompleteTaskModel extends TaskModel{
	
	private int district;
	private String build;
	private String location;
	private String lat;
	private String lng;
	private String photoURL;
	private String photo;
	private String usrNotes;
	private String admNotes;
	
	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUsrNotes() {
		return usrNotes;
	}

	public void setUsrNotes(String usrNotes) {
		this.usrNotes = usrNotes;
	}

	public String getAdmNotes() {
		return admNotes;
	}

	public void setAdmNotes(String admNotes) {
		this.admNotes = admNotes;
	}	
}
