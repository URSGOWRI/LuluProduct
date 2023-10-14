package com.lulu.JDBC.Assesment2;

import java.sql.Connection;

import java.sql.DriverManager;

 

public class DBconnector {

	static Connection connection;

 

	static Connection setupConnection() {

 

 

 

	try {

 

 

 

		 Class.forName("com.mysql.cj.jdbc.Driver");

 

         connection = DriverManager.getConnection("mypath", "root", "");

 

	}

 

	catch(Exception E) {}

 

     return connection;

 

  }

 

 

 

}
