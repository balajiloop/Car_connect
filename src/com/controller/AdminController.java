package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.service.*;
import com.exception.*;
import com.model.*;
import com.exception.*;

public class AdminController {
	public static void main(String[] args) throws InvalidInputException, AdminNotFoundException {
		Scanner sc = new Scanner(System.in);
		AdminService adminService = new AdminService();
		while (true) {
			System.out.println();
			System.out.println("***ADMIN OPERATION***");
			System.out.println("press 1. Get Admin By Id");
			System.out.println("press 2. Get Admin By Username");
			System.out.println("press 3. Register Admin");
			System.out.println("press 4. Update Admin");
			System.out.println("press 5. Delete Admin");
			System.out.println("press 0. for exit");
			System.out.println("**************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you!!!");
				break;
			}
			switch (input) {
			case 1:
				try 
				{
					List<Admin> list = adminService.fetchAllAdmin();
					System.out.println("Enter Customer Id:");
					int id = sc.nextInt();
					Admin c = adminService.getAdminById(list, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "Id",
							"First Name", "Last Name", "Phone Number", "User Name", "Password", "Role",
							"Registration Date"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", c.getId(),
							c.getFirstName(), c.getLastName(), c.getPhoneNumber(),c.getUsername(),
							c.getPassword(), c.getRole(),c.getJoiningDate().toString()));
				} catch (DatabaseConnectionException | SQLException  e) 
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					List<Admin> list = adminService.fetchAllAdmin();
					System.out.println("Enter UserName:");
					String name = sc.next();
					Admin c = adminService.getAdminByUsername(list, name);
					System.out.println();
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "Customer Id",
							"First Name", "Last Name", "Phone Number", "User Name", "Password", "Role",
							"Registration Date"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", c.getId(),
							c.getFirstName(), c.getLastName(), c.getPhoneNumber(),c.getUsername(),
							c.getPassword(), c.getRole(),c.getJoiningDate().toString()));
				} catch (SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
			case 3:
				System.out.println("Enter First Name:");
				String firstName=sc.next();
				System.out.println("Enter Last Name:");
				String lastName=sc.next();
				System.out.println("Enter Email Id:");
				String email=sc.next();
				System.out.println("Enter Phone Number:");
				String phoneNumber=sc.next();
				System.out.println("Enter Username:");
				String username=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
				System.out.println("Enter Role:");
				String role=sc.next();
				System.out.println("Enter joining date:");
				String joiningdate=sc.next();
				try {
					adminService.createAdmin(firstName,lastName,email,phoneNumber,username,password,role,joiningdate);
					System.out.println("Registration Successfull!!");
				} catch (DatabaseConnectionException |SQLException e) {
					System.out.println(e.getMessage());
				} 
				break;
			case 4:
				try {
					List<Admin>list = adminService.fetchAllAdmin();
					System.out.println("Enter Customer Id to be updated:");
					int id = sc.nextInt();
					System.out.println();
					Admin c = adminService.getAdminById(list, id);
					System.out.println(String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s", "Customer Id",
							"First Name", "Last Name", "Phone Number", "User Name", "Password", "Role",
							"Registration Date"));
					System.out.println(String.format("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%s", c.getId(),
							c.getFirstName(), c.getLastName(), c.getPhoneNumber(),c.getUsername(),
							c.getPassword(), c.getRole(),c.getJoiningDate().toString()));
					System.out.println("What do you want to update?");
					sc.nextLine();				
					String field=sc.nextLine();
					System.out.println("Enter the new value:");
					String newVal=sc.nextLine();
					adminService.updateAdmin(id,field,newVal);
					System.out.println("Record updated Successfully");
				} catch (SQLException | DatabaseConnectionException | InvalidInputException e) {
					System.out.println(e.getMessage());
				}
			case 5:
				System.out.println("Enter Admin Id to be deleted");
				int id = sc.nextInt();
				try {
					adminService.deleteAdminById(id);
					System.out.println("Records Deleted!!");
				} catch (SQLException | DatabaseConnectionException e) {
					System.out.println(e.getMessage());
				}
			
			}
	}
}
}