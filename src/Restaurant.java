
/*
 * contains name of restaurant & seats
 */
public class Restaurant 
{
	int now;
	public String mResName; //name of restaurant
	public Seat[] mSeatArray;
	public int mReservID;
	public String mLasterror;
	
	public Restaurant(String name) //constructor to set name
	{
		now=0;
		mResName = name;
		mReservID = 100;
	}
	
	public void openRestaurant(String name) //creates a new restaurant
	{
		mResName = name;
		mSeatArray = new Seat[30]; //30 seat total, seat numbers will be #0 - #29
		//initializing mSeatArray
		for(int i=0;i<mSeatArray.length;i++) 
		{
			if(i>=0 && i<=9) // Bar seat
			{
				mSeatArray[i] = new Seat(1,"Bar",i);
			}
			else if(i>9 && i%2==1) // Window seat
			{
				mSeatArray[i] = new Seat(4,"Window",i);
			}
			else if(i>9 && i%2==0) // Booth seat
			{
				mSeatArray[i] = new Seat(6,"Booth",i);
			}			
		}			
	}
	
	
	public int makeReservation(String cusName, String seatPref, int partySize, int dineTime) 
	//makes reservation ---> returns either reservationID OR '0' if reservation couldn't be made
	{
		if(cusName.equals("") || partySize == 0) //if customer name is empty OR party size is zero
		{
			mLasterror = "cusName is empty || partisize==0";
			return 0;
		}
		
		Seat shortestWait = null;
		int shortWaitTime = -1;
		
		
		//go through each seat to find matching seat with shortest wait
		for(int i=0;i<mSeatArray.length;i++)
		{
			if( mSeatArray[i].mSeatMax < partySize )
			{
				//System.out.println("i=" + i +  " seatMax = " + mSeatArray[i].mSeatMax + " partySize = " + partySize);
				continue;
			}
				
			
			//check if the seat matches the type preference
			if(! mSeatArray[i].mSeatType.equalsIgnoreCase(seatPref))
			{
				//System.out.println("i=" + i + " seatType = " + mSeatArray[i].mSeatType);
				continue;
			}
			
			//check the waiting time for seat to open up (now)
			int waittime = mSeatArray[i].getWaitTime(now);
			
			if(shortWaitTime == -1 || waittime<shortWaitTime )
			{
				shortWaitTime = waittime;
				shortestWait = mSeatArray[i];
			
			}
		}
		
		// if shortestWait seat = null ---> no match found
		if(shortestWait == null)
		{
			mLasterror = "no table found for preference";
			return 0;
		}
		// otherwise, shortestWait seat = seat with least shortWaitTime ---> add new reservation object
		SeatReservation newReserv = new SeatReservation(shortWaitTime, mReservID, cusName, shortestWait.mSeatID, dineTime);
		mReservID = mReservID + 1;

		//enqueue
		shortestWait.mReserveQ.enqueue(newReserv);
		
		
		return newReserv.mReservationID;
	}
	
	public boolean cancelReservation(int reservID) 
	//takes in reservationID and cancels matching reservation
	//if no match, return false
	{
		Node<SeatReservation> toCancel = null;

		for(int i=0;i<mSeatArray.length;i++)
		{
			toCancel = mSeatArray[i].mReserveQ.remove(Integer.toString(reservID));
			if(toCancel != null)
			{
				return true;
			}
		}

		return false;
		
	}
	
	
	public int getWaitTime(String seatType)
	{
		int shortestwait = -1;
		
		for(int i=0;i<mSeatArray.length;i++)
		{
			if(! mSeatArray[i].mSeatType.equalsIgnoreCase(seatType))
			{
				continue;
			}
			//check the waiting time for seat
			int waittime = mSeatArray[i].getWaitTime(now);
			
			if(shortestwait == -1 || waittime<shortestwait)
			{
				shortestwait = waittime;
			}
		}
		return shortestwait;
	}
	
	public void showAllReservs()
	{
		for(int i=0;i<mSeatArray.length;i++)
		{ 
			if(! mSeatArray[i].mReserveQ.isEmpty())
				System.out.println("\nReservations for Seat " + i + " (" + mSeatArray[i].mSeatType + ") " + ": " + "\n" + mSeatArray[i].mReserveQ.toString());
			
		}
	}

	
	
}
