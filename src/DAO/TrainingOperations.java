package DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Employee;
import model.Training;
import utility.ConnectionManager;

public class TrainingOperations {
Training train=null;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public void addTraining(Training train) throws Exception {
	Connection con=ConnectionManager.getConnection();
	String sql="INSERT INTO TRAINING(training_name,training_id,enrolled,training_sup_id,training_sup_name,trainer_name,training_status,training_start,training_end)VALUES(?,?,?,?,?,?,?,?,?)";
	PreparedStatement st=con.prepareStatement(sql);
	st.setString(1, train.getTraining_name());
	st.setString(2, train.getTraining_id());
	st.setLong(3, train.getEnrolled());
	st.setString(4, train.getTraining_sup_id());
	st.setString(5, train.getTraining_sup_name());
	st.setString(6, train.getTrainer_name());
	st.setString(7, train.getStatus());	
	st.setString(8, train.getStart_date());
	st.setString(9, train.getEnd_date());

	st.executeUpdate();
	con.close();
}


public void changeSupervisor(String id) throws Exception {
	Connection con=ConnectionManager.getConnection();
	int result;
	String sql="UPDATE TRAINING SET training_sup_name=?, training_sup_id=? where training_id=?";
	System.out.println("Enter supervisor id");
	String newSupId=br.readLine();
	System.out.println("Enter supervisor name");
	String newSupName=br.readLine();
	PreparedStatement st1= con.prepareStatement(sql);
	st1.setString(1, newSupName);
	st1.setString(2, newSupId);
	st1.setString(3, id);
	result=st1.executeUpdate();
	con.close();
	
}


public void changeTrainer(String id) throws Exception {
	Connection con=ConnectionManager.getConnection();
	int result;
	String sql="UPDATE TRAINING SET trainer_name=? where training_id=?";
	System.out.println("Enter supervisor name");
	String newSupName=br.readLine();
	PreparedStatement st2= con.prepareStatement(sql);
	st2.setString(1, newSupName);
	st2.setString(2, id);
	result=st2.executeUpdate();
	con.close();
}


public void changeStartDate(String id) throws Exception {
	Connection con=ConnectionManager.getConnection();
	int result;
	String sql="UPDATE TRAINING SET training_start=? where training_id=?";
	System.out.println("Enter new start date");
	String newStartDate=br.readLine();
	PreparedStatement st3= con.prepareStatement(sql);
	st3.setString(1, newStartDate);
	st3.setString(2, id);
	result=st3.executeUpdate();
	con.close();
}


public void changeEndDate(String id) throws Exception {
	Connection con=ConnectionManager.getConnection();
	int result;
	String sql="UPDATE TRAINING SET training_end=? where training_id=?";
	System.out.println("Enter new end date");
	String newEndDate=br.readLine();
	PreparedStatement st4= con.prepareStatement(sql);
	st4.setString(1, newEndDate);
	st4.setString(2, id);
	result=st4.executeUpdate();
	con.close();
}


public void deleteTraining(String id) {
	try {
		int result;
		
		Connection con=ConnectionManager.getConnection();
	
		String sql="Delete from training where training_id=?";			
		
		PreparedStatement st5=con.prepareStatement(sql);
		st5.setString(1, id);
		result=st5.executeUpdate();
		if(result!=0) {
			System.out.println("Training = "+id+" has been deleted successfully");
		}
		else {
			System.out.println("Training = "+id+" has not been deleted");
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}


public void getByYear(String year) throws Exception {
	try {
		Connection con=ConnectionManager.getConnection();
		String sql="SELECT * FROM TRAINING WHERE EXTRACT(YEAR FROM TRAINING_START)=?";
		PreparedStatement st6=con.prepareStatement(sql);
		st6.setString(1, year);
		ResultSet rs=st6.executeQuery();

		
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t"+rs.getString(8)+"\t\t"+rs.getString(9));
		}
		con.close();
		
		
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}	
	
	public void getByMonth(String month) {
		try {
			Connection con=ConnectionManager.getConnection();
			String sql="SELECT * FROM TRAINING WHERE EXTRACT(MONTH FROM TRAINING_START)=?";
			PreparedStatement st6=con.prepareStatement(sql);
			st6.setString(1, month);
			ResultSet rs=st6.executeQuery();

			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t"+rs.getString(8)+"\t\t"+rs.getString(9));
			}
			con.close();
			
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

public void getAllTraining() {
	try {
		int result;
		Connection con = ConnectionManager.getConnection();
		String sql="SELECT * from TRAINING";
		Statement st7= con.createStatement();
		ResultSet rs=st7.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7));
		}
		con.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
}

}




