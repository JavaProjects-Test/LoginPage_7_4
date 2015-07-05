package com.loginpage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.loginpage.model.LoginPage;

public class LoginPageDaoImpl implements ILoginPageDao {

	public Connection getConnection() throws Exception {
		System.out.println("Driver uploading.......");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Uploaded.");
		System.out.println("Connection Esstablishig......");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/USERDB", "root", "12345");
		System.out.println("Connection Established");
		return connection;
	}

	public boolean addUser(LoginPage object) {
		boolean status = false;
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT into USERS values(?,?)");
			preparedStatement.setString(1, object.getUserName());
			preparedStatement.setString(2, object.getPassword());

			int numberOfRecords = preparedStatement.executeUpdate();
			if (numberOfRecords == 1) {
				status = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public boolean checkValidation(LoginPage object) {
		boolean status = false;
		Connection connection;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT *FROM USERS where USER_NAME=?");
			preparedStatement.setString(1, object.getUserName());
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				status = true;
			} else {
				status = false;
			}
		}

		catch (Exception e) {

		}
		return status;
	}
}
