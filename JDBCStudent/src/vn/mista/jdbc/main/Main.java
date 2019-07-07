package vn.mista.jdbc.main;

import java.sql.SQLException;
import java.util.ArrayList;

import vn.mista.jdbc.bo.Student;
import vn.mista.jdbc.dao.StudentDAO;
import vn.mista.jdbc.utils.StudentUtils;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		StudentDAO studentDao = new StudentDAO();
		
		ArrayList <Student> studentList = studentDao.getAllStudent();
		
		System.out.println("1.Number of student: " +studentDao.getStudentNumber() +"\n");
		
		System.out.println("2.Number of male student: " +studentDao.getMaleNumber() +"\n");	
		
		ArrayList<Student> femaleStudentList = studentDao.getFemaleStudent();
		System.out.println("3.List student of female: ");
		for(Student student : femaleStudentList) {
			System.out.println(String.format("%-5s %-10s %-5s %-10s %-15s %-5s %-5s", student.getId(), student.getFirstName(), student.getLastName(), student.getGender(), student.getAge(), student.getTelephone(), student.getScores()));
		}	
		System.out.println();
		
		ArrayList<Student> notTeleStudentList = studentDao.getNullTelephoneStudent();
		System.out.println("4.List student  of not update telephone: ");
		for(int i = 0; i < notTeleStudentList.size(); i++) {
			System.out.println(String.format("%-5s %-10s %-5s %-10s %-15s %-5s %-5s", notTeleStudentList.get(i).getId(), notTeleStudentList.get(i).getFirstName(), notTeleStudentList.get(i).getLastName(), notTeleStudentList.get(i).getGender(), notTeleStudentList.get(i).getAge(), notTeleStudentList.get(i).getTelephone(), notTeleStudentList.get(i).getScores()));
		}
		System.out.println();

		ArrayList<Student> age18AboveStudentList = studentDao.getAge18AboveStudent();
		System.out.println("5.List student  of over 18 age: ");
		if(age18AboveStudentList.size() == 0) {
			System.out.println(" no student over 18 age");
		} 
		else{
			for( Student student : age18AboveStudentList) {
				System.out.println(String.format("%-5s %-10s %-5s %-10s %-15s %-5s %-5s", student.getId(), student.getFirstName(), student.getLastName(), student.getGender(), student.getAge(), student.getTelephone(), student.getScores()));
			}
		}
		System.out.println();
		
		ArrayList<Student> goodStudentList = studentDao.getGoodStudent();
		System.out.println("6.List of good student: ");
		for( Student student : goodStudentList) {
			System.out.println(String.format("%-5s %-10s %-5s %-10s %-15s %-5s %-5s", student.getId(), student.getFirstName(), student.getLastName(), student.getGender(), student.getAge(), student.getTelephone(), student.getScores()));
		}
		System.out.println();
		
		ArrayList<Student> weakStudentList = studentDao.getWeakStudent();
		System.out.println("7.List of weak student: ");
		for( Student student : weakStudentList) {
			System.out.println(String.format("%-5s %-10s %-5s %-10s %-15s %-5s %-5s", student.getId(), student.getFirstName(), student.getLastName(), student.getGender(), student.getAge(), student.getTelephone(), student.getScores()));
		}
		System.out.println();
		
		ArrayList<Student> aStudentList = studentDao.getAStudent();
		System.out.println("8.List of student have lastname = A or firstname = A: ");
		for( Student student : aStudentList) {
			System.out.println(String.format("%-5s %-10s %-5s %-10s %-15s %-5s %-5s", student.getId(), student.getFirstName(), student.getLastName(), student.getGender(), student.getAge(), student.getTelephone(), student.getScores()));
		}
		System.out.println();
		
	}
}
