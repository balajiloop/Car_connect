package com.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import com.dao.*;
import com.exception.DatabaseConnectionException;
import com.exception.InvalidInputException;
import com.model.Admin;


public class AdminService {

	AdminDao adminDao = new AdmindaoImpl();

	public List<Admin> fetchAllAdmin() throws SQLException, DatabaseConnectionException 
	{
		List<Admin> list = adminDao.fetchAllAdmin();
		return list;
	}

	public Admin getAdminById(List<Admin> list, int id) throws InvalidInputException 
	{
		for (Admin ad: list) {
			if (ad.getId() == id)
				return ad;
		}
		throw new InvalidInputException("Admin not found :(\nRecheck the admin Id");
	}

	public Admin getAdminByUsername(List<Admin> list, String name) throws InvalidInputException
	{
		for (Admin ad : list) 
		{
			if (ad.getUsername().equals(name))
				return ad;
		}
		throw new InvalidInputException("Incorrect Username :<");
	}

	public void createAdmin(String firstName, String lastName, String email, String phoneNumber,
			String username, String password, String role,String joiningdate)
			throws DatabaseConnectionException, SQLException 
	{

		adminDao.createAdmin(firstName, lastName, email, phoneNumber, username, password,role, joiningdate);

	}

	public void updateAdmin(int id, String field, String newVal) throws DatabaseConnectionException, SQLException, InvalidInputException 
	{
		String fieldd=field.toLowerCase().replace(" ","_");
		if(fieldd.equals("id"))
			throw new InvalidInputException("Sorry!! Admin Id could not be updated :<");
		else
			adminDao.updateAdmin(id,fieldd,newVal);
		
	}

	public void deleteAdminById(int id) throws SQLException, DatabaseConnectionException 
	{
		
		adminDao.deleteAdminById(id);
		
	}

}
