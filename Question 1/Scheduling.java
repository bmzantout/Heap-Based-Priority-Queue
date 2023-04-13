package Assignment4;

public class Scheduling {

	
	//-----------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout - Zeynep Sude Bal
	// ID: 99227947762 - 22399623714 
	// Section: 1
	// Assignment: 4
	// Description: This is the class that does the required 
    //              calculation to find the simulation with 
	//              the optimum number of Couriers and a 
	//              limited average waiting time duration
	//-----------------------------------------------------

	
//----------------------------------------------------------
// Attribute: the "Average_Waiting_Time" that will be 
//            be calculated each time after the simulation 
//            with a specific number of Couriers
//----------------------------------------------------------

	private static double Average_Waiting_Time;
	
	
//----------------------------------------------------------
// Attribute: the sum of the waiting times if all Customers
//            (used to calculate the average waiting time)
//----------------------------------------------------------

	private static double Sum_of_Waiting_Times;
	
	
//----------------------------------------------------------
// Attribute: the total "Number_of_Customers" giving orders
//----------------------------------------------------------

	public static int Number_of_Customers;
	
	
//----------------------------------------------------------
// Attribute: the Maximum Average Waiting Time in which the 
//            average waiting time calculated should not 
//            exceed
//----------------------------------------------------------

	public static double Maximum_Average_Waiting_Time; 
	
	
//----------------------------------------------------------
// Attribute: the total number Of Couriers receiving orders
//----------------------------------------------------------
	
	private static int Number_of_Couriers = 0;
	
	
//----------------------------------------------------------
// Attribute: the Heap-based priority queue array. This data
//            data structure will be used to take the 
//            Customers' orders and assign them to Couriers 
//----------------------------------------------------------

	public static Customer [] Customers_HeapTree;
	
	
//----------------------------------------------------------
// Attribute: the standard array that will be used to store 
//            all the Customers  
//----------------------------------------------------------

	public static Customer [] customers_waiting;
	
	
//----------------------------------------------------------
// Attribute: the "pointer" will point to the indices of the 
//            standard "customers_waiting" array as we iterate
//            over each Customer in the array to take their 
//            order
//----------------------------------------------------------

	private static int pointer = 0;
	
	
//----------------------------------------------------------
// Attribute: determines the size of the heap-based array
//----------------------------------------------------------
	
	private static int sizeOfHeapTree = 0;
	
	
	
	
	
	
	public static void Simulation()
	
//-----------------------------------------------------------------------
// Summary: repeats the simulation for increasing number of Couriers and 
//          calculates the minimum number of Couriers that will achieve 
//          the maximum average waiting time constraint.
// Precondition: this method takes no parameter  
// Postcondition: inside a while-loop the method starts the simulation by 
//                one Courier and starts assigning the Customers based on 
//                their priority to the Courier, then it calculate the 
//                Average Waiting Time of all the Customers, if the the 
//                Average Waiting Time exceeds the given Maximum Average 
//                Waiting Time the simulation is repeated by increasing 
//                the number of Couriers until the Average Waiting Time is
//                less than or equal to the Maximum Average Waiting Time. 
//------------------------------------------------------------------------
	
	{
		
		
	//----------------------------------------------------------
	// Setting the Average Waiting Time as 1 greater than the 
	// Maximum Average Waiting Time in oder to enter the loop
	// Note: the Maximum Average Waiting Time static variable is
	//       read as a user input in the "Main.java" class
	//----------------------------------------------------------
			
		Average_Waiting_Time = Maximum_Average_Waiting_Time + 1;
		
		
	//----------------------------------------------------------
	// We keep iterating through the loop until we achieve an
	// Average Waiting Time less than or equal to the Maximum 
	// Average Waiting Time
	//----------------------------------------------------------
		
		 while (Average_Waiting_Time > Maximum_Average_Waiting_Time)
		 {
			
				
		//----------------------------------------------------------
	    // At each iteration we need to reset the data to their 
		// initial condition to repeat the simulation over again 
		// but with a different number of Couriers 
		// Note: check "Refresh_Customers()" and "Refresh()" methods
		//       for details about resetting the Customers's and 
		//       Couriers' information respectively
		//----------------------------------------------------------
				
			 Sum_of_Waiting_Times = 0;
			 pointer = 0;
			 Refresh_Customers();
			 ListOfCouriers.Refresh();
				
		//----------------------------------------------------------
		// Increasing the number of Couriers by 1 at each iteration
		//----------------------------------------------------------
				
			 ListOfCouriers.addCourier();
			 Number_of_Couriers++ ; 
		     
		     
				
		//---------------------------------------------------------------
		// Calling the "Customers_To_Couriers" method which does the
	    // the simulation by assigning the required Customers to the 
	    // available Couriers based on their priority
		// Note (1): This method takes the String "don't print" as
		//           parameter to indicate that the simulation should 
		//           be done without printing it out to the console
		// Note (2): Check "Customers_To_Couriers" method for 
		//           implementation details
		//---------------------------------------------------------------
	 
			 Customers_To_Couriers("don't print");
			 
				
		//--------------------------------------------------------------
		// Calculation the Average Waiting Time by dividing the Sum 
		// of Waiting Times by the Number of Customers
		//--------------------------------------------------------------
	
			 Average_Waiting_Time = Sum_of_Waiting_Times / Number_of_Customers;
			 
		 }
		 
			
	//-----------------------------------------------------------------
	// When we exit the while-loop, it means that we achieved the 
	// required Average Waiting Time. So, we print the simulation
	// with the calculated optimum number of Couriers and Average 
	// Waiting Time
	// Note: Check "printSimulation()" method for implementation details
	//-----------------------------------------------------------------

		 printSimulation();
	}
	
	


	
	private static void printSimulation()
	
//-----------------------------------------------------------------------
// Summary: prints the simulation output to the console
// Precondition: this method takes no parameter  
// Postcondition: this method prints the output of the Minimum number of 
//                Couriers required, the simulation with that number of 
//                Couriers and the Average Waiting Time calculated
//------------------------------------------------------------------------
		
	{
		
	//-----------------------------------------------------------------------
	// Printing the Minimum number of Couriers required
	//------------------------------------------------------------------------

		 System.out.println();
		 System.out.println("Minimum number of couriers required: " + Number_of_Couriers);
		 
		 System.out.println();
		 System.out.println("Simulation with " + Number_of_Couriers + " Couriers:");
		 
	//-----------------------------------------------------------------------
	// Printing the Simulation with the optimum number of Couriers
	// Note" check "Simulation(String print)" method for implementation details
	//------------------------------------------------------------------------

		 System.out.println();
		 Simulation("print");
		 
		 
	//-----------------------------------------------------------------------
	// Printing the Average waiting time: when printing the output of the 
	// Average Waiting Time we rounded it using Math.round() when it had no 
	// decimals and we set the precision of the decimal value to 5 when it was 
	// a floating number
	//------------------------------------------------------------------------

		 System.out.println();
		 String s;
		 
		 
	//-------------------------------
	// In case it has no decimals
	//-------------------------------

		 if (Sum_of_Waiting_Times % Number_of_Customers == 0)
		 
		 s = "Average waiting time: " + Math.round(Average_Waiting_Time) + " minutes"; 
		 
		 
	//-------------------------------
	// In case it has decimals
	//-------------------------------
		 else 
		 
		 s = String.format("Average waiting time: %.5f  minutes" , Average_Waiting_Time);
		 
	     System.out.println(s);
	}
	
	
	
	
	
	
	private static void Simulation(String print)
	
//-----------------------------------------------------------------------
// Summary: does the simulation with the last and optimum number of 
//          Couriers calculated 
// Precondition: it takes the String "print" as parameter to indicate
//               that this simulation should be printed
// Postcondition: inside a while-loop the method starts the simulation by 
//	                one Courier and starts assigning the Customers based on 
//	                their priority to the Courier, then it calculate the 
//	                Average Waiting Time of all the Customers, if the the 
//	                Average Waiting Time exceeds the given Maximum Average 
//	                Waiting Time the simulation is repeated by increasing 
//	                the number of Couriers until the Average Waiting Time is
//	                less than or equal to the Maximum Average Waiting Time. 
//------------------------------------------------------------------------
		
	{		
		
	//----------------------------------------------------------
	// Resetting the data to their initial condition to avoid 
	// overwritten data
	// Note: check "Refresh_Customers()" and "Refresh()" methods
	//       for details about resetting the Customers's and 
	//       Couriers' information respectively
	//----------------------------------------------------------
				
		Refresh_Customers();
	    ListOfCouriers.Refresh();
	   	pointer = 0;

	//---------------------------------------------------------------
	// Calling the "Customers_To_Couriers" method which does the
    // the simulation by assigning the required Customers to the 
	// available Couriers based on their priority
	// Note (1): This method takes the String "print" as
	//           parameter to indicate that the simulation should 
	//           be done and printed out to the console
	// Note (2): Check "Customers_To_Couriers" method for 
	//           implementation details
	//---------------------------------------------------------------
	
	   	Customers_To_Couriers(print);
	}

	
	
	
	 private static void Customers_To_Couriers(String print_OR_Noprint)
	 
//---------------------------------------------------------------------------
// Summary: Does the assignment of all Customers to Couriers
// Precondition: this method takes the String "print_OR_Noprint" which 
//               determines whether the simulation have to be printed or not
//               as parameter
// Postcondition: It iterates through every Customer in the standard array 
//                "customers_waiting" then stores the Customers which give orders
//                at available times of Couriers to the Heap-based array and 
//                assigns them to available couriers. 
//----------------------------------------------------------------------------
		
		 {
		 
			
		//----------------------------------------------------------
		// In a while loop we iterate through the standard array 
        // "customers_waiting" until we reach the end of the array
		// (we take the orders of all Customers)
		//----------------------------------------------------------
		 
			 while ( pointer < customers_waiting.length )   
				{
				 
				//--------------------------------------------------------------
				// In a for-loop we store (insert) the Customers which give orders
                // at available times (finish times) of Couriers to the Heap-based 
				// array
				//--------------------------------------------------------------
					
					for (pointer = pointer ; pointer < customers_waiting.length ; pointer++)
					{
						 
					//---------------------------------------------------------------------
					// For each Customer, we check the condition if whether the Customer's 
					// order time is less than or equal to the available Courier's finish 
					// time (available time to take a new order) 
					// Note: check "Available_Courier()" method for implementation details
					//---------------------------------------------------------------------
							
						if (customers_waiting[pointer].getOrder_time() <= Available_Courier().getFinish_time())
						{
							
						//--------------------------------------------------------------
						// If the condition is satisfied, we add (insert)the Customer 
						// to the Heap-Tree-based priority queue array named 
						// "Customers_HeapTree" based on their priority
						// Note: check "insert" method for implementation details
						//--------------------------------------------------------------
							
							insert(customers_waiting[pointer]);
						}
						
						
					//--------------------------------------------------------------
					// Since the order times are given in increasing order once the 
					// previous condition is not satisfied we break the loop
					//--------------------------------------------------------------
							
						else break;
					}
					
					
				//--------------------------------------------------------------------
				// We assign the Customers we now have in the Heap Tree to 
				// the corresponding available Couriers
				// Note (1): check "AssignToCourier" method for implementation details
				// Note (2): the method takes the String "print_OR_Noprint" which 
	            // determines whether the simulation have to be printed or not
				//--------------------------------------------------------------------
				
					AssignToCourier(print_OR_Noprint);
						
				}
		 }
		 
	 
	 
	
	 private static Courier Available_Courier()
	 
//-----------------------------------------------------------------------
// Summary: checks the available Courier at the moment
// Precondition: this method takes no parameter  
// Postcondition: if we have only one Courier then surely, that courier is 
//	                the only one that will be available, but if we have
//	                more than one Courier, then the Courier that finishes 
//	                first is the available one. In case more than one Courier
//	                finish at the same time, the one with the less ID takes 
//	                the order.
// Note: the Couriers are stored in a Linked list structure. Check the
//	       "ListOfCouriers" static class below for implementation details 
//------------------------------------------------------------------------
			
		 {
				
		//--------------------------------------------------------------
		// In case we have only one Courier in the List that courier 
		// is returned
		//--------------------------------------------------------------

			 if (ListOfCouriers.size == 1)
			 {
				 return ListOfCouriers.head.getCourier();
			 }
			 
		//--------------------------------------------------------------
		// In case we have more than one, the Courier that finishes 
	    // first is the available one. In case more than one Courier
	    // finish at the same time, the one with the less ID takes 
	    // the order.
		//--------------------------------------------------------------

			 else 
			 {
				 Node temp = ListOfCouriers.head;
				 
					
			//--------------------------------------------------------------
			// We initially set the Courier that finished first as the 
			// Courier with ID 0 (The first Courier). If none of the other
			// Couriers finishes earlier than Courier 0 then he/she will 
			// take the order because he/she has the least ID
			//--------------------------------------------------------------

				 Courier finished_first = ListOfCouriers.head.getCourier();
				 
				 
			//--------------------------------------------------------------
			// Iterating through each Courier in the list of Couriers 
			// to compare them
			//--------------------------------------------------------------

				 while (temp.getNext() != null)
				 {
					 temp = temp.getNext();
					 
					 
				//--------------------------------------------------------------
				// The Courier who finishes earlier is assigned to the 
				// "finished_first" variable 
				//--------------------------------------------------------------
	 
					 if (temp.courier.getFinish_time() < finished_first.getFinish_time())
					 {
						 finished_first = temp.getCourier();
					 }
					 
				 }
				
				 
			//--------------------------------------------------------------
			// Returning the available Courier
			//--------------------------------------------------------------

				return finished_first; 
				
			 }
		 }
		 
	
	 
	 
	 private static void AssignToCourier(String s)
	 
//-----------------------------------------------------------------------
// Summary: Assigns Customers to Couriers 
// Precondition: this method takes a String which determines whether the 
//               simulation have to be printed or not as parameter
// Postcondition: We assign one Courier to a Customer at a time until
//                we take all Customers for the standard array and we have
//                remaining Customers waiting in the Heap-Tree array then
//                we do the assignment as much as the number of remaining
//                Customers 
//------------------------------------------------------------------------
	
	 {
		 
		//--------------------------------------------------------------------
		// When we take all Customers for the standard array and have remaining 
		// Customers waiting in the Heap-Tree array then we do the assignment as
		// much as the number of remaining Customers indicated by "last_customers"
		//--------------------------------------------------------------------
			
			if (pointer == customers_waiting.length)
			{
				int last_customers = sizeOfHeapTree;

				for (int i = 1 ; i <= last_customers ; i++)
				{
					
				//--------------------------------------------------------------------
				// If the String passed in the parameter indicates "print" then we call 
				// the method that prints the output to the console at each assignment
				// Otherwise, we call the one that does the assignment without printing
				// Note: Check "AssignCustomer_print()" and "AssignCustomer()" methods
				//       for implementation details
				//--------------------------------------------------------------------
				
					if (s.equals("print")) AssignCustomer_print();
					else                   AssignCustomer();
				}
			}
			
		//--------------------------------------------------------------------
		// Otherwise, one assignment is done at a time
		//--------------------------------------------------------------------
			
			else 
			{
				
			//--------------------------------------------------------------------
			// If the String passed in the parameter indicates "print" then we call 
			// the method that prints the output to the console at each assignment
			// Otherwise, we call the one that does the assignment without printing
			// Note: Check "AssignCustomer_print()" and "AssignCustomer()" methods
			//       for implementation details
			//--------------------------------------------------------------------

				if (s.equals("print")) AssignCustomer_print();
				else                   AssignCustomer();
			}
	 }
	 
	 
	 
	 
	 private static void AssignCustomer_print()
	 
//-----------------------------------------------------------------------
// Summary: Assigns Customers to Couriers and prints the output to 
//          the console
// Precondition: this method takes no parameter
// Postcondition: To assign a Customer to a Courier, the Customer should 
//                be:
//                      - deleted from the Heap Tree
//                      - assigned to the available Courier (the Customer's
//                        service time should be added to the Courier's finish 
//                        time)
//                      - the wait time of the Customer should also be saved
//                      - Printing the above information to the screen
//------------------------------------------------------------------------
	
	 {
			
	//--------------------------------------------------------------
	// Deleting the Customer with the highest priority from the Heap 
	// Tree to assign him/her to a Courier
	//--------------------------------------------------------------

		 Customer deleted = deleteMax();
		 
			
	//-------------------------------------------------------
	// Calculating the waiting time of Customer: the the 
	// difference between the given order time of the customer 
	// and the time he is  assigned to a courier
	//-------------------------------------------------------

		 deleted.setWait_time(Available_Courier().getFinish_time() - deleted.getOrder_time());
		 
			
	//--------------------------------------------------------------
	// Printing the output to the console
	//--------------------------------------------------------------

		 System.out.println("Courier " +  Available_Courier().getID() + " takes customer " + deleted.getID() + 
				             " at minute " + Available_Courier().getFinish_time() + " (wait: " + deleted.getWait_time() + " mins)");
		 
			
	//--------------------------------------------------------------
	// Setting the new finish time of the Courier 
	//--------------------------------------------------------------

		 Available_Courier().setFinish_time(Available_Courier().getFinish_time() + deleted.getService_time());
	 }
	 
	 
	 
	 
	 private static void AssignCustomer()
	 
//-----------------------------------------------------------------------
// Summary: Assigns Customers to Couriers without printing the output to 
//          the console
// Precondition: this method takes no parameter
// Postcondition: To assign a Customer to a Courier, the Customer should 
//                be:
//                      - deleted from the Heap Tree
//                      - assigned to the available Courier (the Customer's
//                        service time should be added to the Courier's finish 
//                        time)
//                      - the wait time of the Customer should also be saved
//------------------------------------------------------------------------
	
	 {
			
	//--------------------------------------------------------------
	// Deleting the Customer with the highest priority from the Heap 
	// Tree to assign him/her to a Courier
	//--------------------------------------------------------------

		 Customer deleted = deleteMax();
		 
	//-------------------------------------------------------
	// Calculating the waiting time of Customer: the the 
	// difference between the given order time of the customer 
	// and the time he is  assigned to a courier
	//-------------------------------------------------------

		 deleted.setWait_time(Available_Courier().getFinish_time() - deleted.getOrder_time());
		 
			
	//--------------------------------------------------------------
	// Adding the Waiting Times of all Customers
	//--------------------------------------------------------------

		 Sum_of_Waiting_Times = Sum_of_Waiting_Times + deleted.getWait_time();
		 
			
	//--------------------------------------------------------------
	// Setting the new finish time of the Courier 
	//--------------------------------------------------------------

		 Available_Courier().setFinish_time(Available_Courier().getFinish_time() + deleted.getService_time());
		
	 }
	 
	 
	 
	 
	 
	
	private static void insert(Customer c)
	 
//-----------------------------------------------------------------------
// Summary: Inserts a Customer to the end of the Heap-Tree-based priority 
//          queue array called "Customers_HeapTree" and calls the "swim"
//          method that performs the swim operation
// Note: Check the "swim" method for details of implementation
//------------------------------------------------------------------------
	
	{
		Customers_HeapTree[++sizeOfHeapTree] = c;
		
		swim(sizeOfHeapTree);
	}

	
	
	
	private static void swim(int k)
	 
//-----------------------------------------------------------------------
// Summary: Performs the swim operation when inserting a new element to 
//          the Heap-based array
// Precondition: takes the index of the newly added element (Customer 
//               object) as parameter
// Postcondition: it compares the added element to its parent and swaps it
//                with its parent if the added Customer has a higher 
//                priority than its parent. So, the Customer with the
//                highest priority is always at the root of the  tree 
// Note: Check the "less" and "exch" methods for details of implementation
//------------------------------------------------------------------------
	
	{
		while (k > 1 && less(k/2, k))
		{
			exch(k, k/2);
			k = k/2;
		}
	}
	
	
	
	private static void exch(int i, int j)
	 
//-----------------------------------------------------------------------
// Summary: takes 2 index values of the Heap-based array as index and 
//          swaps the elements at those indices
//------------------------------------------------------------------------
	
	 {
		 Customer c = Customers_HeapTree[i];
		 Customers_HeapTree[i] = Customers_HeapTree[j]; 
		 Customers_HeapTree[j] = c; 
	 }

	
	
	 private static boolean less(int v, int w)
		
//-----------------------------------------------------------------------
// Summary: compares two Customers objects with respect to their priority
// Note: check "compareTo" in "Customer.java" class for details
//-----------------------------------------------------------------------	
	 {
		 return (Customers_HeapTree[w].compareTo(Customers_HeapTree[v])) < 0;
	 }
	
	
	
	 private static Customer deleteMax()
	 
//-----------------------------------------------------------------------
// Summary: Deletes a Customer from the the Heap-Tree-based priority 
//          queue array called "Customers_HeapTree". 
// Precondition: this method returns the deleted Customer object
// Postcondition: Since the data structure is a Heap-based tree array, the
//                Customer with the highest priority is always at the root
//                of the tree which means that in order to delete a Customer
//                we always delete the root by swapping it with the last
//                element in the tree and performs the sink operation
// Note: Check the "swim" and "exch" methods for details of implementation
//------------------------------------------------------------------------
	
	 {
		 Customer max = Customers_HeapTree[1];
		 
		 exch(1, sizeOfHeapTree--);
		 sink(1);
		 
		 Customers_HeapTree[sizeOfHeapTree+1] = null;
			
		 return max;

	 }
	 
	 
	 
	 private static void sink(int k)
	 
//-----------------------------------------------------------------------
// Summary: Performs the sink operation when deleting an element from 
//          the Heap-based array
// Precondition: takes the index of the tree's root as parameter
// Postcondition: it compares the children of the root with each other
//                then if the Customer at the root has less priority than 
//                the child with the least priority it swaps that child
//                with the root
// Note: Check the "less" and "exch" methods for details of implementation
//------------------------------------------------------------------------
	
	 {
		 while (2*k <= sizeOfHeapTree)
		 {
			 int j = 2*k;
			 if (j < sizeOfHeapTree && less(j, j+1)) j++;
			 if (!less(k, j)) break;
			 exch(k, j);
			 k = j;
		 }
	 }
	 

	 
	 
	 private static void Refresh_Customers()
		
//--------------------------------------------------------------------
// Summary: resets the Customers' information by resetting the wait time
//          of each Customer as 0 to avoid overwriting when repeating
//          the simulation
//--------------------------------------------------------------------	
	 {
		 for (Customer c : customers_waiting)
		 {
			 c.setWait_time(0);
		 }
	 }
	 
	 
	 
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	 
	
	
	
	
	private static class ListOfCouriers
	
	{
		
//-------------------------------------------------------
// Attribute: the "head" or first node of the linked list   
//-------------------------------------------------------
			
		public static Node head;

		
//-------------------------------------------------------
// Attribute: the "size" of the linked list, initially 
//            being 0
//-------------------------------------------------------
			
		public static int size = 0;
		
		
		
		
		public static void addCourier()

//---------------------------------------------------------------
// Purpose: adds a new Courier node to the list of Couriers
// Precondition: this method takes no parameter
// Postcondition: this method adds a new Node to the end of the 
//                linked list and instantiates a new Courier to
//                that node
//---------------------------------------------------------------
			
		{

		//---------------------------------------------------------------
		// IF the list is empty we set the "head" of the list as the 
		// new Courier node
		// Note (1): Since the Couriers will have the IDs: 0, 1, 2, 3...
		//       we give the size of the list as parameter to the Courier's
		//       Constructor to set their IDs as 0, 1, 2... sequentially
		// Note (2): Check the Courier Constructor in the "Courier.java"
		//           class for details
		//---------------------------------------------------------------
				
			if (head == null)
			{
				head = new Node(new Courier(size));
			}
			

		//---------------------------------------------------------------
		// ELSE if the list is not empty we iterate till the end of the 
		// list and add the new Courier to the end
		// Note (1): Since the Couriers will have the IDs: 0, 1, 2, 3...
		//       we give the size of the list as parameter to the Courier's
		//       Constructor to set their IDs as 0, 1, 2... sequentially
		// Note (2): Check the Courier Constructor in the "Courier.java"
		//           class for details
		//---------------------------------------------------------------
			
			else 
			{
				Node temp = head;
				
				while (temp.nextCourier != null)
				{
					temp = temp.getNext();
				}
				
				temp.setNext(new Node(new Courier(size)));
			}
			
		
		//---------------------------------------------------------------
		// Increment the size of the list by 1 after we add a new node
		//---------------------------------------------------------------
			
			size ++;
			
		}
		

		
		
		public static void Refresh()
		
//---------------------------------------------------------------------------------
// Summary: Refreshes the Couriers' data 
// Condition: Since the simulation will be tried several times by increasing the
//            number of Couriers at each time we need reset the finish time of 
//            Couriers so they start again to take orders at minute 1 
// Note: the method iterates through each node in the Linked List. IN other words it
//       it iterates through every Courier and resets his/her finish time
//---------------------------------------------------------------------------------	
	
		{
			Node temp = head;
			
			while (temp != null)
			{
				temp.courier.setFinish_time(1);
				temp = temp.getNext();
			}
		}
		
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	private static class Node  {
		
		
//-----------------------------------------------------
//  Attribute: the "next" node in the list (since each node 
//             holds the address of the node next to it)
//-----------------------------------------------------
	
		private Node nextCourier;
		
		
//-----------------------------------------------------
//  Getter: the Courier object that will be stored at
//          each node
//-----------------------------------------------------
	
		private Courier courier;
		
		
//-----------------------------------------------------
//  Constructor: creates a new node by instantiating 
//               the Courier object stored in that node
//               and setting the node next to it as null
//-----------------------------------------------------
		
		private Node (Courier courier)
		{
			this.courier = courier;
			this.nextCourier = null;
		}
		
		
//-----------------------------------------------------
//  Getter: returns the node next to the node that calls 
//		    the method
//-----------------------------------------------------
	
		private Node getNext() 
		{
			return nextCourier;
		}

		
//-----------------------------------------------------
//  Setter: sets the next node (node passed as parameter)
//-----------------------------------------------------
			
		private void setNext(Node next) 
		{
			this.nextCourier = next;
		}
		
		
//-----------------------------------------------------
//  Getter: gets the Courier stored in a node
//-----------------------------------------------------
		
		private Courier getCourier() 
		{
			return courier;
		}
		
	
	}
	
}
