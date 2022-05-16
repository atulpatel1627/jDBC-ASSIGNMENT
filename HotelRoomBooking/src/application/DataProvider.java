package application;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

//import org.apache.logging.log4j.core.Logger;

import resources.AppConfig;
//import resources.LogConfig;

public class DataProvider {
	
	/**
	 *
	 * Adds the new booking in the table
	 *
	 * @param  {@link Booking} Booking
	 * @return bookingId
	 * @throws Exception
	 */
	class DuplicateIdException extends RuntimeException{
		DuplicateIdException(String s){
			super(s);
		}
	}
	public String addBooking(Booking booking) throws Exception {
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// creates connection
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/atul?characterEncoding=latin1", "root", "root12345");

			Statement stmt = con.createStatement();
			PreparedStatement preStmt = con.prepareStatement("insert into booking values(?,?,?,?,?)");
			preStmt.setInt(1,booking.getCustomerId());
			preStmt.setString(2,booking.getCustomerName());
			preStmt.setInt(3,booking.getRoomNo());
			preStmt.setDouble(4,booking.getTotalBillAmount());
			preStmt.setLong(5,booking.getContactNo());
			
			 preStmt.executeUpdate();
		
			con.close();

		} catch (Exception e) {
//			e.printStackTrace();
			throw new DuplicateIdException("Technical Error.Please try after some time.If the problem persist,contact your administrator");
			
		}
		
		return "S"+ booking.getCustomerId();
	}

	
	/**
	 * 
	 * Change the room number of the customer
	 * 
	 * @param {@link Booking} customerId
	 * @return number of rows updated
	 * @throws Exception
	 */
	
	public Integer updateRoomNo(Integer customerId , Integer CustomerRoomno) throws Exception {
		try {
			// Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// creates connection
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/atul?characterEncoding=latin1", "root", "root12345");

			Statement stmt = con.createStatement();
			PreparedStatement preStmt = con.prepareStatement("update booking set RoomNo = ? where CustomerId=?");
			preStmt.setInt(1,CustomerRoomno);
			preStmt.setInt(2, customerId);
			
			if(preStmt.executeUpdate()==0) {
				return 0;
			}
			preStmt.executeUpdate();
//			while (rs.next())
//				System.out.println(rs.getInt("CustomerId") + " " + rs.getString("customername") + " " 
//						+ " " + rs.getInt(" room_No") + " "  + " " + rs.getDouble("Total_bill_Amount")
//						+ " " + rs.getInt("contact_no"));

			con.close();

		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return 1;
	}
	
	

}