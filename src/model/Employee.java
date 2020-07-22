package model;

public class Employee {
	private String eid;
	private String ename;
	private String email;
	private long phone;
	private String department;
	private String position;
	private int salary;
	
	
	public Employee(String eid, String ename, String email, String department, String position, int salary, long phone) {
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.position = position;
		this.salary = salary;
	}
	public String getEid() {
		return eid;
	}
	public String getEname() {
		return ename;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	public String getDepartment() {
		return department;
	}
	public String getPosition() {
		return position;
	}
	public int getSalary() {
		return salary;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

	
	
}
