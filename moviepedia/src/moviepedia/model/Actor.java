package moviepedia.model;

import java.util.Date;

public class Actor {
int id;
String firstName;
String lastName;
Date dateOfBirth;
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
public Actor() {
	super();
	// TODO Auto-generated constructor stub
}
}
