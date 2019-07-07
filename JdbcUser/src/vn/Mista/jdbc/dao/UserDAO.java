package vn.Mista.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import vn.Msita.jdbc.bo.User;
import vn.Msita.jdbc.utils.ConnectionFactory;

public class UserDAO { 
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<User> userList;
	
	public ArrayList<User> getAllUser(){ 
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from user");// statement watch data.
			while(resultSet.next()) {
				userList.add(convertToUser(resultSet));
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
		
		return userList;
	}

	
	private static User convertToUser(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setPass(rs.getString(3));
		user.setAge(rs.getInt(4));
		return user;	
	}
	
	public static void addUser(User user) {
		Connection connection  = null;
		Statement statement = null;
		String insertSQL =  " insert into user (name, pass, age) values ('"
				+user.getName() + "','" +user.getPass() + "','" +user.getAge() + "')";
		System.out.println(insertSQL);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(insertSQL);
		} catch(SQLException e) {
			//handle error for jdbc
			e.printStackTrace();
		} finally {
			//finally block used to close resouces
			if (statement != null) {
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
 	}
	
	//insert c2
	public static void addUserViaPreparedStatement(User user) {
		Connection connection  = null;
		PreparedStatement  preparedStatement = null;
		String insertSQL =  " insert into user (name, pass, age) values (?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			//handle error for jdbc
			e.printStackTrace();
		} finally {
			//finally block used to close resouces
			if (preparedStatement != null) {
				try {
				preparedStatement.close();
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
 	}
	
	public User addUserViaPreparedStatementReturnId(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String insertSQL = " insert into user (name, pass, age) values (?,?,?)";
		String[] returnId = { " id "};
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL, returnId);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.executeUpdate();
			
		resultSet = preparedStatement.getGeneratedKeys();
		
				if(resultSet.next()) {
					user.setId(resultSet.getInt(1));
				}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (preparedStatement != null) {
				try {preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
		
	}
	
	public ArrayList<User> findUserByUsername(String username) {
		Connection connection  = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<User> findUserList = new ArrayList<User>();
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();//create obj execute statement select.
			resultSet = statement.executeQuery("Select *from user where name = '"
					+ username +"'");// statement watch data.
			while(resultSet.next()) {
				findUserList.add(convertToUser(resultSet));
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
		
		return findUserList;
	}


	public boolean updadePasswordForUser(String username, String newPassword) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = true;
		String sql = " update user set pass= ?  where name = ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, username);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			//handle error for jdbc
			e.printStackTrace();
			result = false;
		} finally {
			//finally block used to close resouces
			if (preparedStatement != null) {
				try {
				preparedStatement.close();
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
		return result;
	}

	public boolean deleteUserList(ArrayList<User> userList) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = true;
		String idList = generateIdList(userList);
		String sql = " delete from user  where id in " +idList;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			//handle error for jdbc
			e.printStackTrace();
			result = false;
		} finally {
			//finally block used to close resouces
			if (preparedStatement != null) {
				try {
				preparedStatement.close();
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
		return result;
	}
	
	private static String generateIdList(ArrayList<User> userList) {
		String prefix = "(";
		String suffix = ")";
		String idList = "";
		for (User user : userList) {
			idList = idList + user.getId() + ",";
		}
		idList = idList.substring(0, idList.length() - 1);
		idList = prefix + idList + suffix;
		return idList;
	}
}




// viet cac method de ket noi vs DB.