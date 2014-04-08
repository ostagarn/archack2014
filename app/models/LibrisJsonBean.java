package models;

public class LibrisJsonBean {

	String uri = "";
	String person = "" ;
	
	public LibrisJsonBean(String person, String uri) {
		this.uri = uri;
		this.person = person ;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

}
