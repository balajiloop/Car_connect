package com.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.exception.DatabaseConnectionException;
import com.model.Admin;

public interface AdminDao {

	List<Admin> fetchAllAdmin() throws SQLException, DatabaseConnectionException;

	void createAdmin(String firstName, String lastName, String email,String phoneNumber,  String username,
			String password, String role,String joiningdate) throws DatabaseConnectionException, SQLException;

	void updateAdmin(int id, String field, String newVal) throws DatabaseConnectionException, SQLException;

	void deleteAdminById(int id) throws SQLException, DatabaseConnectionException;

}
