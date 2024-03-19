package com.dao;
import com.dao.AdminDao;
import java.sql.Connection;
import com.util.DBUtility;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Admin;


public class AdmindaoImpl implements AdminDao {

	public List<Admin> fetchAllAdmin() throws SQLException, DatabaseConnectionException 
	{
		List<Admin> list = new ArrayList<>();
		Connection conn = DBUtility.getDBConn();

		String sql = "select * from admin";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();

		while (rst.next()) 
		{
			int id = rst.getInt("id");
			
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			
			String email = rst.getString("email");
			
			String phoneNumber = rst.getString("phone_number");
			
			String address = rst.getString("address");
			String username = rst.getString("username");
			String password = rst.getString("password");
			String role=rst.getString("role");
			LocalDate joiningdate = rst.getDate("joining_date").toLocalDate();
			Admin ad = new Admin(id, firstName, lastName, email, phoneNumber, address, username, password,
					role,joiningdate);
			list.add(ad);
		}

		DBUtility.dbClose();
		return (list);
	}

	public void updateAdmin(int id, String field, String newVal) throws DatabaseConnectionException, SQLException {
		
		Connection conn = DBUtility.getDBConn();

		String sql = "update admin set "+field+"=? where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		if(field.equals("registration_date"))
			pstmt.setDate(1, Date.valueOf(newVal));
		else
			pstmt.setString(1,newVal);
		
		pstmt.setInt(2, id);


		pstmt.executeUpdate();

		DBUtility.dbClose();
	}


	public void deleteAdminById(int id) throws SQLException, DatabaseConnectionException {
		
		Connection conn = DBUtility.getDBConn();
		
		String sql = "delete from admin where id=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		sql = "delete from admin where id=?";

		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, id);

		pstmt.executeUpdate();

		DBUtility.dbClose();
		
	}


	@Override
	public void createAdmin(String firstName, String lastName, String email, String phoneNumber, String username,
			String password, String role, String joiningdate) throws DatabaseConnectionException, SQLException {
		Connection conn = DBUtility.getDBConn();

		String sql = "insert into admin(first_name,last_name,email,phone_number,address,username,password,role,joiningdate) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, firstName);
		pstmt.setString(2, lastName);
		pstmt.setString(3, email);
		pstmt.setString(4, phoneNumber);
		pstmt.setString(6, username);
		pstmt.setString(7, password);
		pstmt.setString(8, role);
		pstmt.setDate(8, Date.valueOf(joiningdate));

		pstmt.executeUpdate();

		DBUtility.dbClose();
		
	}

}
