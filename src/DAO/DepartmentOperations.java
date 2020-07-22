package DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Department;
import model.Employee;
import utility.ConnectionManager;

public class DepartmentOperations {
	Department dept=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public void addDepartment(Department dept) throws Exception{
		Connection con=ConnectionManager.getConnection();
		String sql="INSERT INTO DEPT(dept_id,dept_name,dept_supervisor,dept_sup_id)VALUES(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		
		st.setString(1, dept.getDept_id());
		st.setString(2, dept.getDept_name());
		st.setString(3, dept.getSupervisor_name());
		st.setString(4, dept.getSupervisor_id());
		
		st.executeUpdate();
		con.close();
		
	}
	
public void changeSupervisor(String id) throws Exception {
	int result;
	Connection con=ConnectionManager.getConnection();
	String sql="UPDATE Dept SET dept_sup_id=?, dept_supervisor=? where dept_id=?";
	System.out.println("Enter supervisor id");
	String newSupId=br.readLine();
	System.out.println("Enter supervisor name");
	String newSupName=br.readLine();
	PreparedStatement st1= con.prepareStatement(sql);
	st1.setString(1, newSupId);
	st1.setString(2, newSupName);
	st1.setString(3, id);
	result=st1.executeUpdate();
	con.close();
	}

public void getAllDepartments() {
	try {
		int result;
		Connection con = ConnectionManager.getConnection();
		String sql="SELECT * from DEPT";
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}



public void getSpecificDepartment(String id) {
try {
	int result;
	Connection con = ConnectionManager.getConnection();
	String sql="SELECT * from DEPT WHERE DEPT_ID=?";
	PreparedStatement st5= con.prepareStatement(sql);
	st5.setString(1, id);
	ResultSet rs=st5.executeQuery();
	
	
	while(rs.next()) {
		System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
	}
	con.close();
}
catch(Exception e) {
	System.out.println(e);
}
}



}
