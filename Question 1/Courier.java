package Assignment4;

public class Courier {

	
	//-----------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout - Zeynep Sude Bal
	// Description: This is the class that has the Couriers'
	//              information attributes and the constructor
	//              that creates a new Courier object
	//-----------------------------------------------------

	
//-------------------------------------------------------
// Attribute: the "ID" of the Courier
//-------------------------------------------------------

		private int ID;
		
		
//-------------------------------------------------------
// Attribute: the time at which the Courier is available
//            to get a new order (the time the the Courier 
//            finishes from an an order)
//-------------------------------------------------------

		private int finish_time;
		

		
//----------------------------------------------------------------
// Constructor: Creates a new Courier object by instantiating
//			    its "ID", and setting his/her default "finish_time"
//              as 1 because all Couriers start taking orders at 
//              minute 1
//----------------------------------------------------------------	

		public Courier(int ID) 
		{
			this.ID = ID;
			this.finish_time = 1;
		}
		
		
		

		
//-----------------------------------------------------
// Getter: returns the ID of the Courier
//-----------------------------------------------------
			
		public int getID() 
		{
			return ID;
		}
		
		
//-----------------------------------------------------
// Getter: returns the time the Courier is available
//      to get a new order (the time the the Courier 
//      finishes from an an order)
//-----------------------------------------------------
	
		public int getFinish_time() 
		{
			return finish_time;
		}

		
//-----------------------------------------------------
// Setter: sets the time the Courier is available
//         to get a new order (the time the the Courier 
//         finishes from an an order)
//-----------------------------------------------------
	
		public void setFinish_time(int finish_time) 
		{
			this.finish_time = finish_time;
		}
		
		
		
}
