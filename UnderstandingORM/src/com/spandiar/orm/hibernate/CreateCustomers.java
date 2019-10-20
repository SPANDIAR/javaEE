package com.spandiar.orm.hibernate;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spandiar.dto.CustomerAddress;
import com.spandiar.dto.CustomerDetails;

public class CreateCustomers {

	public CreateCustomers() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		
		/*CustomerDetails customer1 = new CustomerDetails(8380, "Srinivasan", "Rasiappan", "srini@gopichettipalayam.com", LocalDate.parse("1974-02-26"));
		CustomerAddress addressHome1 = new CustomerAddress("HOME", "345 Lakshmi Layout", "Mico Layout", "Bangalore", "KA", "IN", "560703");
		CustomerAddress addressWork1 = new CustomerAddress("WORK", "567 Bannerghatta Main Rd", "", "Bangalore", "KA", "IN", "560733");
	
		CustomerDetails customer2 = new CustomerDetails(8387, "Sankar", "Pandiarajan", "sankarapandi@hotmail.com", LocalDate.parse("1981-09-06"));
		CustomerAddress addressHome2 = new CustomerAddress("HOME", "1235 Wildwwod Ave", "Apt 355", "Sunnyvale", "CA", "US", "94089");
		CustomerAddress addressWork2 = new CustomerAddress("WORK", "1404 E Arques Ave", "", "Sunnyvale", "CA", "US", "94086");*/

		//CustomerDetails customer3 = new CustomerDetails(8386, "Vijay", "Subramanian", "vijay@mersal.com", LocalDate.parse("1980-06-02"));
		//CustomerAddress addressHome3 = new CustomerAddress("HOME", "Sun City", "Sarjapur Road", "Bangalore", "KA", "IN", "560100");

		
		// Add addresses to the Address Collection
	/*	customer1.getAddress().add(addressHome1);
		customer1.getAddress().add(addressWork1);
		
		customer2.getAddress().add(addressHome2);
		customer2.getAddress().add(addressWork2);*/
		
		//customer3.getAddress().add(addressHome3);
		
		//CustomerDetails customer3 = new CustomerDetails(8390, "Arokia", "Rajasekar", "shakeher@pondy.com", LocalDate.parse("1972-08-07"));
		
		// Insert into database
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(CustomerDetails.class).buildSessionFactory();
	/*	Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer3);
		
		session.getTransaction().commit();
		session.close();*/
		
		// Select from the database
		Session updateSession = sessionFactory.openSession();
		updateSession.beginTransaction();
		
		CustomerDetails readCustomer = (CustomerDetails) updateSession.get(CustomerDetails.class, 8386);
		Collection<CustomerAddress> vijayHome = readCustomer.getAddress();
		
		Iterator<CustomerAddress> addr = vijayHome.iterator();
		while (addr.hasNext()) {
			if(addr.next().getAddressType().contentEquals("HOME")) {
				addr.remove();
			}
		}
		
		
		//readCustomer.getAddress().add(vijayHome.);
		updateSession.update(readCustomer);
		updateSession.getTransaction().commit();
		
		//readCustomer.setCustomerEmail("deepa_pulikotil@chrompet.com");
		//CustomerDetails deepaPK = new CustomerDetails(8395, "Deepa", "PK", "deeps@chrompet.com", LocalDate.parse("1977-05-20"));
		//CustomerAddress deepaWork = new CustomerAddress("HOME", "Sun City", "Sarjapur Road", "Bangalore", "KA", "IN", "560100");
		//readCustomer.getAddress().add(deepaWork);
		
		//updateSession.update(readCustomer);
		
		
		//updateSession.update(readCustomer);
		//updateSession.getTransaction().rollback();
		//updateSession.getTransaction().commit();
		//updateSession.close();
		
		System.out.println("Customer Name is: " + readCustomer.getCustomerFirstName() + " " + readCustomer.getCustomerLastName());
		System.out.println("Customer Id is: " + readCustomer.getCustomerID());
		System.out.println("Customer Email is: " + readCustomer.getCustomerEmail());
		//System.out.println("Customer Address Size is: " + readCustomer.getAddress().size());
		System.out.println("Customer Address is: ");
		for(CustomerAddress custAddress:readCustomer.getAddress()) {
			System.out.println("Customer Address is: " + custAddress.getAddressType() + " "+ custAddress.getAddress1() + " " + custAddress.getCity());
		}
		
		//session.close();
		
		sessionFactory.close();
		
	}

}
