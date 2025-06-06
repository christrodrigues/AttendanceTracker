package com.christ.attendanceTracker.model;


import jakarta.persistence.*;

@Entity
@Table(name="professor")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 private String email;
	 private String password;
	 
	 @Column(name = "first_name")
	 private String firstName;
	 
	  @Column(name="last_name")
	  private String lastName;
	  
	  
	  
	  public Professor() {
	        // Default constructor
	    }
	

	    // Getters and setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	 
	
	   
}
