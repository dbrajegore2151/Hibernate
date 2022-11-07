package StudentProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int addmitionNo;

	private String name;

	private String address;
	
	private String EmailId;
	
	

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddmitionNo() {
		return addmitionNo;
	}

	public void setAddmitionNo(int addmitionNo) {
		this.addmitionNo = addmitionNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student id : " + id + " Student addmition No : " + addmitionNo + " Student name : " + name
				+ " Student address : " + address + "Student Email Id : "+ EmailId;
	}

}
