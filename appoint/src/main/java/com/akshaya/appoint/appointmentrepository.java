package com.akshaya.appoint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class appointmentrepository {
	List<appointment> appoint=new ArrayList<appointment>();

	public List<appointment> getallappointment() throws ClassNotFoundException, Exception {
	
		
		String Query="Select * from appointment";
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = connectionfactory.getCollection();
		 Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery(Query);
		 while(rs.next()) {
			 appointment a=new appointment();
			 a.setDoctor(rs.getString("doctor"));
			 a.setPatient(rs.getString("patient"));
			 a.setStatus(rs.getString("status"));
			 appoint.add(a);
		 }
		 
		return appoint;
	
	}

	public List<appointment> getallappointmentbyname(String doctor) throws ClassNotFoundException, SQLException   {
		
	
		String Query="Select * from appointment where doctor="+'\"'+doctor+'\"';
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = connectionfactory.getCollection();
		 Statement stmt=con.createStatement();
		 ResultSet rs=stmt.executeQuery(Query);
		 List<appointment> b=new ArrayList<appointment>();
		 while(rs.next()) {
		 appointment a=new appointment();
		 a.setDoctor(rs.getString("doctor"));
		 a.setPatient(rs.getString("patient"));
		 a.setStatus(rs.getString("status"));
		 System.out.println(a);
		 b.add(a);
		 }
		return b;
	
	}
	public void addappointment(appointment newappoint) throws SQLException, ClassNotFoundException{
		String Query="Insert into appointment values(?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = connectionfactory.getCollection();
		 PreparedStatement stmt=con.prepareStatement(Query);
		 stmt.setString(1, newappoint.getDoctor());
		 stmt.setString(2, newappoint.getPatient());
		 stmt.setString(3, newappoint.getStatus());
		 stmt.executeUpdate();
		return ;
	}
	public void updateappointment(appointment newappoint) throws ClassNotFoundException, SQLException {
		String Query="Update appointment set patient=?,status=? where doctor=?";
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = connectionfactory.getCollection();
		 PreparedStatement stmt=con.prepareStatement(Query);
		 
		 stmt.setString(1, newappoint.getPatient());
		 stmt.setString(2, newappoint.getStatus());
		 stmt.setString(3, newappoint.getDoctor());
		 stmt.executeUpdate();
		return ;
	}

	public void deleteappointment(String doctor) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		 Connection con = connectionfactory.getCollection();
		 String queryUpdate = "delete from appointment where doctor = "+'\"'+doctor+'\"';
			PreparedStatement ps =  con.prepareStatement(queryUpdate);
			ps.executeUpdate();

		
		 
		
		
	}
}
