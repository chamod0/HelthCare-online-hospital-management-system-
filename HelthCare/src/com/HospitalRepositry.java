package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.HospitalModel;

public class HospitalRepositry {

	
	Connection con =null;
	public  HospitalRepositry() {
		String url = "jdbc:mysql://localhost/hms";
		String username ="root";
		String password = "root";
		
		System.out.println("Get con");
		 try
		 {
			
		 Class.forName("com.mysql.jdbc.Driver");

		
		 con = DriverManager.getConnection(url,username,password);
		 System.out.println("con ok..");
		 }
		 catch (Exception e) {
		 	System.out.println(e);
		 
		 }
		 
		 
		 
	}
	
	public List<HospitalModel> geHospitalModels() {
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
				h.setHos_phone(rs.getNString(4));
				h.setHos_email(rs.getNString(5));
				
			
				
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
	
	
public HospitalModel geHospitalModel(int hos_id) {
		
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
				ho.setHos_phone(rs.getNString(4));
				ho.setHos_email(rs.getNString(5));
				
				System.out.println("hos_id _if");
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return ho;
	}
	
	
}
