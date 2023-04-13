package Assignment4;

public class Customer implements Comparable<Customer> {
	
	
	//-----------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout - Zeynep Sude Bal
	// ID: 99227947762 - 22399623714 
	// Section: 1
	// Assignment: 4
	// Description: This is the class that has the Customers'
	//              information attributes and the constructor
	//              the creates a new Customer object
	//-----------------------------------------------------

	
//-------------------------------------------------------
// Attribute: the "ID" of the Customer
//-------------------------------------------------------

	private int ID;
	
	
//-------------------------------------------------------
// Attribute: the registration "Year" of the customer to
//            the company
//-------------------------------------------------------
	
	private int Year;
	
			
//-------------------------------------------------------
// Attribute: the arrival time of the order
//-------------------------------------------------------
	
	private int order_time;
	
	
//-------------------------------------------------------
//Attribute: the service time of the Customer
//-------------------------------------------------------

	private int service_time;
	
	
//-------------------------------------------------------
// Attribute: the the duration between the given order 
//            time of the customer and the time he is 
//            assigned to a courier
//-------------------------------------------------------

	private int wait_time;
	
	
	
	
	
//----------------------------------------------------------------
// Constructor: Creates a new Customer object by instantiating
//	              its "ID", "Year", "order_time", and "service_time"
//----------------------------------------------------------------	

	public Customer(int ID, int year, int order_time, int service_time)

	{
		this.ID = ID;
		this.Year = year;
		this.order_time = order_time;
		this.service_time = service_time;
	}
	

	
	
//-----------------------------------------------------
// Getter: returns the ID of the Customer
//-----------------------------------------------------
	
	public int getID() 
	{
		return ID;
	}


	
//-----------------------------------------------------
// Getter: returns the time the Customer gave the order
//-----------------------------------------------------				

	public int getOrder_time() 
	{
		return order_time;
	}


	
//-----------------------------------------------------
// Getter: returns the service time of the Customer
//-----------------------------------------------------				

	public int getService_time() 
	{
		return service_time;
	}

	
	
//-----------------------------------------------------
// Getter: returns the amount of time the Customer 
//         waited for his/her order to be taken
//-----------------------------------------------------				

	public int getWait_time() 
	{
		return wait_time;
	}


	
//-----------------------------------------------------
// Getter: sets the duration of time the Customer 
//         waited for his/her order to be taken
//-----------------------------------------------------				
		
	public void setWait_time(int wait_time) 
	{
		this.wait_time = wait_time;
	}


	
	
	
//---------------------------------------------------------------------------------
// Summary: Compares two Customers with respect to their priority
// Precondition: Since the "Customer" class implements Comparable it should also 
//               implement the method "compareTo" which determines what makes one 
//               Customer have higher priority than other customers
// Postcondition: to compare two Customers we first compare their years, if the 
//                Customer is an older Customer he/she gets the priority. But if they
//                were both customers for the same duration of time, then we compare
//                their waiting times, the Customer who waited longer has the priority.
//                But, if the year and waiting times are same, then the Customer with 
//                with the less ID number has the priority.
//---------------------------------------------------------------------------------	
	
	
	@Override
	public int compareTo(Customer that) {
		// TODO Auto-generated method stub
		
	//--------------------------------------------------------
	// The older the Customer is, the higher his/her priority is
	//--------------------------------------------------------	
		
		if (this.Year < that.Year)            return -1;     
		if (this.Year > that.Year)            return 1;
			
		
	//--------------------------------------------------------
	// ELSE: The greater the waiting time of the Customer is, 
	//       the higher his/her priority is
	//--------------------------------------------------------	
	
		if (this.wait_time > that.wait_time)  return -1;    
		if (this.wait_time < that.wait_time)  return 1;
		
		
	//--------------------------------------------------------
	// ELSE: The less the ID of the Customer is, the higher 
	//       his/her priority is
	//--------------------------------------------------------	
	
		if (this.ID < that.ID) 	              return -1;    
		                    		          return 1;
		
		
			}
	
	


	}
	
	

