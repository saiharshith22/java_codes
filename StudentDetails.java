package studentjdbc;

public class StudentDetails {

	private String name;
	private String address;
	private String gender;
	private String dob;
	private int id;
	
	public StudentDetails(String name, String address, String gender, String dob) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
	}
	
	public StudentDetails(String name, String address, String gender, String dob, Integer id) {
		super();
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.id = id;
	}
	
	public StudentDetails() {
		super();
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



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StudentDetails [name=" + name + ", address=" + address + ", gender=" + gender + ", dob=" + dob + ", id="
				+ id + "]";
	}


}
