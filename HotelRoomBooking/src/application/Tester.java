package application;

import java.util.Scanner;

//import org.apache.logging.log4j.core.Logger;

import resources.AppConfig;

public class Tester {
	
	public static void main(String[] args) {
 
		// Uncomment the methods and run
		addDetails();
		//updateDetails();

	}
	 
/* To add a new customer details into the database*/	

	public static void addDetails() {		
		try {
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			String name = sc.nextLine();
			int Roomno = sc.nextInt(); 
			double billamount = sc.nextDouble();
			long mobileno = sc.nextLong();

			Booking booking = new Booking();
			booking.setCustomerId(id);
			booking.setCustomerName(name);
			booking.setRoomNo(Roomno);
			booking.setTotalBillAmount(billamount);
			booking.setContactNo(mobileno);
			String bookingId = new DataProvider().addBooking(booking);
			System.out.println();
			System.out.print(AppConfig.PROPERTIES
					.getProperty("UserInterface.INSERT_SUCCESS"));
			System.out.print("   :   ");
			System.out.print(bookingId);

		} catch (Exception e) {

			System.out
					.println(AppConfig.PROPERTIES.getProperty("DataProvider.TECHNICAL_ERROR"));
		}
		System.out.println("\n\n");
	}

	
/* To get the details of all the orders that was made in the London branch  */
	
	

/* To update the room number of the mentioned customer id*/	

	public static void updateDetails() {
		try {

			Integer i = new DataProvider().updateRoomNo(1,1003);
			System.out.println();
			if (i == 1) {
				System.out.print(AppConfig.PROPERTIES
						.getProperty("UserInterface.UPDATE_SUCCESS"));
			} else {
		
				throw new Exception("UserInterface.UPDATE_FAILURE");
			}

		} catch (Exception e) {
			System.out
					.println(AppConfig.PROPERTIES.getProperty("UserInterface.NO_DETAILS"));
		}
		System.out.println("\n\n");
	}

/*To delete the record of with the orderId: 1004*/	

	
}
