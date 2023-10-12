package com.lulu.JDBC.Assesment2;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

 

public class BusinessLogic {

	

 

	Scanner in = new Scanner(System.in);

 

	void create() throws SQLException{

		Connection connection = DBconnector.setupConnection();

 

		String query = "insert into FashionRetailers(Id, Name, Age,City,Phone_Number) values (?, ?, ?, ?, ?)";

 

		PreparedStatement statement = connection.prepareStatement(query);

 

		statement.setInt(1, 105);

 

		statement.setString(2, "Nykaaa Fashion");

 

		statement.setInt(3, 10);

 

		statement.setString(4, "Mumbai");

 

		statement.setInt(5, 223233544);

 

		boolean created = statement.execute();

 

		   if (created==false) {

 

		        System.out.println("Created Successfully.");

 

		    } else {

 

		        System.out.println("Creation Failed.");

 

		    }

 

	}

 

	void read() throws SQLException{

 

		Connection connection = DBconnector.setupConnection();

 

		 Statement statement;

 

		statement = connection.createStatement();

 

        ResultSet resultSet;

 

        resultSet = statement.executeQuery("select * from FashionRetailers");

 

		int Id;

		String Name;

		int Age;

		String City;

		int Phone_Number;

		System.out.println("Fashion Retailer's information");

 

		System.out.println();

 

		while (resultSet.next()) {

 

			Id = resultSet.getInt("Id");

 

			Name = resultSet.getNString("Name");

 

			Age = resultSet.getInt("Age");

 

			City = resultSet.getString("City");

 

			Phone_Number = resultSet.getInt("Phone_Number");

 

			System.out.println("Id :"+Id+ ", Name :"+Name+", Age :"+Age+", City :"+City+", Phone_number :"+Phone_Number);

 

		}

 

	}

 

	void update() throws SQLException{

 

		Connection connection = DBconnector.setupConnection();

 

		String query = "update FashionRetailers set Name = ?, Age = ?, City = ?, Phone_Number = ? where Id = ?";

 

		PreparedStatement statement = connection.prepareStatement(query);

 

		

 

		System.out.print("Enter the ID of the retailer you want to update: ");

 

		int Id = in.nextInt() ;

 

		statement.setInt(5, Id);

 

		

 

		System.out.print("Enter the new name: ");

 

		String name = in.next();

 

		statement.setString(1, name);

 

		

 

		System.out.print("Enter the new age: ");

 

		int age = in.nextInt() ;

 

		statement.setInt(2, age);

 

		

 

		System.out.print("Enter the new city: ");

 

		String city = in.next();

 

		statement.setString(3, city);

 

		

 

		System.out.print("Enter the new phone number: ");

 

		int Phone_number = in.nextInt() ;

 

		statement.setInt(4, Phone_number);

		boolean created = statement.execute();

 

		System.out.println();

 

		   if (created==false) {

 

		        System.out.println("Updated Successfully.");

 

		    } else {

 

		        System.out.println("Updating Failed.");

 

		    }

 

	

 

	}

 

	void delete() throws SQLException{

 

		Connection connection = DBconnector.setupConnection();

 

		String query = "delete from FashionRetailers where Id = ?";

 

		PreparedStatement statement = connection.prepareStatement(query);

 

		System.out.print("Enter the ID of the retailer you want to delete: ");

 

		int id1=in.nextInt();

 

		statement.setInt(1, id1);

		boolean created = statement.execute();

		   if (created==false) {

 

		        System.out.println("Deleted Successfully.");

 

		    } else {

 

		        System.out.println("Deleting Failed.");

 

		    }

 

	}

 

}