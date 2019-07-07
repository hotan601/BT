package vn.mista.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.mista.jdbc.bo.Student;
import vn.mista.jdbc.utils.ConnectionFactory;

public class StudentDAO {

	public static ArrayList <Student> studentList = new ArrayList<Student>(); 
	
	public ArrayList <Student> getAllStudent(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(" select *from students");
			while(resultSet.next()) {
				studentList.add(convertToStudent(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}
	
	public static Student convertToStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setFirstName(rs.getString(2));
		student.setLastName(rs.getString(3));
		student.setGender(rs.getString(4));
		student.setTelephone(rs.getString(5));
		student.setAge(rs.getInt(6));
		student.setScores(rs.getInt(7));
		return student;	
	}
	
	public int getStudentNumber() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
	
		int countStudent = 0;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select count(id) from students");// statement watch data.
			
			for(int i = 0; i < studentList.size(); i++) {
					countStudent++;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return countStudent;
	}
	public int getMaleNumber() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		int count = 0;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select count(gender) from students where gender = 'male'");// statement watch data.
			
			for(int i = 0; i < studentList.size(); i++) {
				if(studentList.get(i).getGender().equals("male")) {
					count++;
				}
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return count;
	}

	
	private void printStackTrace() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Student> getFemaleStudent() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> femaleStudentList = new ArrayList<Student>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from students where gender = 'female'");// statement watch data.
			while(resultSet.next()) {
				femaleStudentList.add(convertToStudent(resultSet));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return femaleStudentList;
	}

	public ArrayList<Student> getNullTelephoneStudent() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> notTeleStudentList = new ArrayList<Student>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from students where telephone is null");// statement watch data.
			while(resultSet.next()) {
				notTeleStudentList.add(convertToStudent(resultSet));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return notTeleStudentList;
	}
	
	public ArrayList<Student> getAge18AboveStudent() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> age18AboveStudentList = new ArrayList<Student>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from students where age > 18");// statement watch data.
			while(resultSet.next()) {
				age18AboveStudentList.add(convertToStudent(resultSet));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return age18AboveStudentList;
	}
	
	public ArrayList<Student> getGoodStudent() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> goodStudentList = new ArrayList<Student>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from students where scores > 80");// statement watch data.
			while(resultSet.next()) {
				goodStudentList.add(convertToStudent(resultSet));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return goodStudentList;
	}
	
	public ArrayList<Student> getWeakStudent() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> weakStudentList = new ArrayList<Student>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from students where scores < 45");// statement watch data.
			while(resultSet.next()) {
				weakStudentList.add(convertToStudent(resultSet));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return weakStudentList;
	}
	
	public ArrayList<Student> getAStudent() {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Student> aStudentList = new ArrayList<Student>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from students where lastName = 'A' or firstName = 'A'");// statement watch data.
			while(resultSet.next()) {
				aStudentList.add(convertToStudent(resultSet));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();//handle error for jdbc
		}finally {     //finally block used to close resources
			if (resultSet != null) {
				try{
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return aStudentList;
	}
	
}
