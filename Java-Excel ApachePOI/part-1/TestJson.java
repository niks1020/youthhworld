package forBlog;

import java.util.Date;

public class TestJson {
	String firstName;
	String lastName;
	String occupation;
	String city;
	
	@Override
	public String toString() {
		return "FirsName: "+this.firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getData(String key) {
		String value = "";
		switch(key){
			case "First Name": value = this.getFirstName(); break;
			case "Last Name": value = this.getLastName(); break;
			case "Occupation": value = this.getOccupation(); break;
			case "City": value = this.getCity(); break;
		}
		return value;
	} 
}
