package model;

public class Department {
String dept_id;
String dept_name;
String supervisor_id;
String supervisor_name;
public Department(String dept_id, String dept_name, String supervisor_id, String supervisor_name) {
	this.dept_id = dept_id;
	this.dept_name = dept_name;
	this.supervisor_id = supervisor_id;
	this.supervisor_name = supervisor_name;
}
public String getDept_id() {
	return dept_id;
}
public String getDept_name() {
	return dept_name;
}
public String getSupervisor_id() {
	return supervisor_id;
}
public String getSupervisor_name() {
	return supervisor_name;
}
public void setDept_id(String dept_id) {
	this.dept_id = dept_id;
}
public void setDept_name(String dept_name) {
	this.dept_name = dept_name;
}
public void setSupervisor_id(String supervisor_id) {
	this.supervisor_id = supervisor_id;
}
public void setSupervisor_name(String supervisor_name) {
	this.supervisor_name = supervisor_name;
}



}
