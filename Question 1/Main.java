package Assignment4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout - Zeynep Sude Bal
	// Description: This is the main class for Question 1 which depends
	//              on the following classes: 
	//              "Scheduling.java", "Customer.java",
	//              and "Courier.java". It generates the expected
	//              output by calling the required methods.
	//-----------------------------------------------------------------

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//-------------------------------------------------------
// Creating a Scanner object named "scanner"   
//-------------------------------------------------------
	
		Scanner scanner = new Scanner(System.in);
		
		
//-------------------------------------------------------
// Saving the file name input to a String named "file"
//-------------------------------------------------------
	
		System.out.println("Enter input filename:");
		String file = scanner.next();
		file = "matrixes/ass4/" + file;
		
		
//-------------------------------------------------------
// Getting the Maximum Average Waiting Time in order to 
// do the required calculations for the simulation
//-------------------------------------------------------
	
		System.out.println("Enter the maximum average waiting time:");
		Scheduling.Maximum_Average_Waiting_Time = scanner.nextDouble();
		
		
//-------------------------------------------------------
// Closing the Scanner
//-------------------------------------------------------
			
		scanner.close();
		

//----------------------------------------------------------------
// Reading the given input text file to scan for the Customers and 
// their information
// Note: Check "ReadFile(String file)" method below for details
//----------------------------------------------------------------	
		
		ReadFile(file);
		
		
//-------------------------------------------------------------
// Calling the method "Simulation" in order to calculate the 
// minimum number of Couriers needed to accomplish a simulation 
// in a specific amount of time
// Note: check the method "Simulation" in "Scheduling.java" 
//       class for implementation details
//-------------------------------------------------------------
	
		Scheduling.Simulation();
		
		
	}

	
	
	
	public static void ReadFile(String file)
	
//--------------------------------------------------------------
// Summary: Reads a text file of integer values 
// Precondition: this method takes the file name as a parameter 
//               and scans the values in it using Scanner class
// Postcondition: it first reads the numbers of Customers that
//                gave orders and based on that number creates 
//                an ordinary array and stores the the Customer 
//                objects and instantiates a Heap-Tree based 
//                priority queue array to further do the simulation 
//                using this data structure 
//--------------------------------------------------------------

		
	{
		
		try {
			
			
		//--------------------------------------------------------------
		// Setting a Scanner for the text file
		//--------------------------------------------------------------

			File f = new File(file);
			Scanner scan = new Scanner(f);
			
			
		//--------------------------------------------------------------
		// Scanning the first integer in the text which indicates the 
		// number of Customers giving orders
		// Note: "Number_of_Customers" is a static attribute in the 
		//       "Scheduling.java" class
		//--------------------------------------------------------------

			Scheduling.Number_of_Customers = scan.nextInt();
			
			
		//--------------------------------------------------------------
		// Instantiating the standard array to store all the Customers 
		// Note: we used the "Number_of_Customers" static variable read
		//       above to determine the array's size
		//--------------------------------------------------------------

			Scheduling.customers_waiting = new Customer[Scheduling.Number_of_Customers];
			
			
		//--------------------------------------------------------------
		// Instantiating the Heap-Tree based array to further take the 
		// Customers' orders and assign them to Couriers using this 
		// Heap-based priority queue data structure
		// Note: we used the "Number_of_Customers" static variable read
		//       above to determine the array's size but we added 1 to it 
		//       because indices in a heap tree start at index 1
		//--------------------------------------------------------------

			Scheduling.Customers_HeapTree = new Customer[Scheduling.Number_of_Customers + 1];			
			
			
			
		//--------------------------------------------------------------
		// In a for-loop we read the integer values from the text file. 
		// At each iteration we read one line, which holds one Customer's
		// information and we Create a Customer object accordingly 
		// Note (1): At each iteration we save the Customer object to the
		//           standard array "customers_waiting"
		// Note (2): Check the "Customer" constructor in the "Customer.java"
		//           class for implementation details
		//--------------------------------------------------------------

			for (int i = 0 ; i < Scheduling.Number_of_Customers ; i++)
			{
				
			//--------------------------------------------------------------
			// Since the format used in the text file is as follows:
			//	
			//          ID   Year   order-time   service-time
			//	
			// the "Customer" constructor reads the values one by one 
			// and creates the Customer object accordingly. The "Customer"
			// Constructor looks like:
			//	
			//  Customer(int ID, int year, int order_time, int service_time)
			//                ^        ^           ^                ^
			//--------------------------------------------------------------

		        Scheduling.customers_waiting[i] = new Customer(scan.nextInt() , scan.nextInt(), scan.nextInt(), scan.nextInt());
			}
			
			
			
		//-------------------------------------------------------
		// Closing the Scanner
		//-------------------------------------------------------

			scan.close();
			
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
