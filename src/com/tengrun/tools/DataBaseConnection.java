package com.tengrun.tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	private String DBDRIVER="org.gjt.mm.mysql.Driver";
	private String DBURL="jdbc:mysql://localhost:3306/tengrun";
	private String DBUSER="root";
	private String DBPASSWORD="123";
	private Connection dbc=null;
	public DataBaseConnection()
	{
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.dbc=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		return this.dbc;
	}
	public void close()
	{
		try {
			this.dbc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
