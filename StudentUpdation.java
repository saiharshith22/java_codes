package studentjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentUpdation {
	
	public static boolean createTable() {
		boolean tableCreatedSuccessfully=false;
		try {
			
			Connection c = ConnectDB.createConnection();
			Statement st = c.createStatement();
			String query="create table Student (name varchar(20) NOT NULL,address varchar(255) NOT NULL,gender varchar(255),doj varchar(15),id int,PRIMARY KEY (id))";
			st.executeUpdate(query);
			tableCreatedSuccessfully=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableCreatedSuccessfully;
	}
	public static void readStudentData() {
		try {
			
			Connection c = ConnectDB.createConnection();
			Statement st = c.createStatement();
			String query="select name,address,gender,doj,id from Student";
			ResultSet resultSet = st.executeQuery(query);
			if (resultSet.next() == false){ 
				System.out.println("Student table does not have any data..."); 
			} 
			else{ 
				do{ 
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");
					String gender = resultSet.getString("gender");
					String doj = resultSet.getString("doj");
					Integer id = resultSet.getInt("id");
					System.out.println(id + " " + name + " " + address + " " + gender+" "+doj); 
				   } while (resultSet.next()); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean deleteTable() {
		boolean isTableDeletedSuccessfully=false;
		try {
			
			Connection c = ConnectDB.createConnection();
			Statement st = c.createStatement();
			String query="drop table Student";
			st.executeUpdate(query);
			isTableDeletedSuccessfully=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTableDeletedSuccessfully;
	}
	
	public static boolean insertStudent(StudentDetails st){
		boolean isInsertedSuccessfully=false;
		try {
			Connection c = ConnectDB.createConnection();
			String queryString = "insert into Student values (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(queryString);
			ps.setString(1, st.getName());
			ps.setString(2, st.getAddress());
			ps.setString(3, st.getGender());
			ps.setString(4, st.getDob());
			ps.setInt(5,st.getId());
			
			ps.executeUpdate();
			isInsertedSuccessfully=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isInsertedSuccessfully;
		
	}
	
	public static boolean updateStudent(String toUpdate, String data, Integer id) {
		boolean isUpdatedSuccessfully=false;
		try {
			Connection c = ConnectDB.createConnection();
			String queryString = "update Student set "+toUpdate+"=? where id=?";
			PreparedStatement ps = c.prepareStatement(queryString);
			ps.setString(1, data);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			isUpdatedSuccessfully=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdatedSuccessfully;
	}
	
	public static boolean deleteStudent(Integer delId) {
		boolean isDeletedSuccessfully=false;
		try {
			Connection c = ConnectDB.createConnection();
			String queryString = "delete from Student where id=?";
			PreparedStatement ps = c.prepareStatement(queryString);
			ps.setInt(1, delId);
			
			ps.executeUpdate();
			isDeletedSuccessfully=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeletedSuccessfully;
	}
	
	
}
