package com.api.springrest.entities;
import org.springframework.data.annotation.Id;


public class Provider {

  @Id
  private int id;

  private String firstName;
  private String lastName;
  private String createdBy;
  private String modifiedBy;
  
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
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}

public Provider(int id, String firstName, String lastName, String createdBy, String modifiedBy) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.createdBy = createdBy;
	this.modifiedBy = modifiedBy;
}

public Provider() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Provider [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", createdBy=" + createdBy
			+ ", modifiedBy=" + modifiedBy + "]";
}
  
  
  
  

}