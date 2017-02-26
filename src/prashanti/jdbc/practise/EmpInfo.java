package prashanti.jdbc.practise;

import java.sql.*;

public class EmpInfo {
	 private String firstname;
	 private String lastname;
	 private String empid;
	 private String emailid;
	

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String fullname) {
		this.firstname = fullname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String toString()
	{
		return "EmpInfo[firstname= + firstname +]";
	}

}
