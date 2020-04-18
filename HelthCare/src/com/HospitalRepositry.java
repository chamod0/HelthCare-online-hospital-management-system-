package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DoctorM;
import model.HospitalModel;

public class HospitalRepositry {

	
	Connection con =null;
	public  HospitalRepositry() {
		String url = "jdbc:mysql://localhost/hms";
		String username ="root";
		String password = "";
		
		System.out.println("Get con");
		 try
		 {
			
		 Class.forName("com.mysql.jdbc.Driver");

		
		 con = DriverManager.getConnection(url,username,password);
		 System.out.println("con ok..");
		 }
		 catch (Exception e) {
		 	System.out.println(e);
		 	System.out.println("Connection error");
		 
		 }
		 
		 
		 
	}
	
	public List<HospitalModel> getHospitalModels() {
		List<HospitalModel> hospital = new ArrayList<>();
		String sql = "select * from hospital_table ";
		try {
			
			System.out.println("get list  hospital..");
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			while(rs.next()) {
				
				HospitalModel h = new HospitalModel();
				
				h.setHos_id(rs.getInt(1));
				h.setHos_name(rs.getString(2));
				h.setHos_address(rs.getString(3));
				h.setHos_phone(rs.getString(4));
				h.setHos_email(rs.getString(5));
				
			
				
				hospital.add(h);
				System.out.println("added");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("added error");
		}
		
		System.out.println("added return");
		return hospital;
	}
	
	
public HospitalModel getHospitalModel(int hos_id) {
		
		String sql = "select * from hospital_table where hos_id ="+hos_id;
		HospitalModel ho= new HospitalModel();
		try {
			
			System.out.println("hos_id");
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery(sql);
			if(rs.next()) {
				
				
				ho.setHos_id(rs.getInt(1));
				ho.setHos_name(rs.getString(2));
				ho.setHos_address(rs.getString(3));
				ho.setHos_phone(rs.getString(4));
				ho.setHos_email(rs.getString(5));
				
				System.out.println("hos_id _if");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return ho;
	}


public void create_Hospital(HospitalModel h_create) {
	String sql = "insert into hospital_table values(?,?,?,?,?) ";
	try {
		
		System.out.println("SQL ok");
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setInt(1, h_create.getHos_id());
		ps.setString(2, h_create.getHos_name());
		ps.setString(3, h_create.getHos_address());
		ps.setString(4, h_create.getHos_phone());
		ps.setString(5, h_create.getHos_email());
		
		System.out.println("PreparedStatement set");
		
	ps.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
}
	
public void update_Hospital(HospitalModel h_update) {
	String sql = "UPDATE hospital_table SET hos_name=?,hos_address=?,hos_phone=?,hos_email=? WHERE hos_id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		
		ps.setString(1, h_update.getHos_name());
		ps.setString(2, h_update.getHos_address());
		ps.setString(3, h_update.getHos_phone());
		ps.setString(4, h_update.getHos_email());
		ps.setInt(5, h_update.getHos_id());
		
				
		ps.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}
}

public void delete_Hospital(int hos_id) {
	// TODO Auto-generated method stub
	String sql = "DELETE FROM hospital_table WHERE hos_id=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, hos_id);
					
		ps.executeUpdate();
		
		
	} catch (Exception e) {
		System.out.println(e);
	}

}

	





}

	
