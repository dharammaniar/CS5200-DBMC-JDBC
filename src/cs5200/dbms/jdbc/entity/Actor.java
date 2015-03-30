package cs5200.dbms.jdbc.entity;

import java.sql.Date;

public class Actor {

	// ID has been taken int to make it auto incrementing in the database also since we will not be
	// showing it to the user.
	private int id;
	private String firstName;
	private String lastName;
	// Date of birth has been taken as a Date instead of a String.
	private Date dateOfBirth;
	
	public Actor() {
		super();
	}

	public Actor(int id, String firstName, String lastName, Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
