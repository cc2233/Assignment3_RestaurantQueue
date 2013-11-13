
/*
 * defines Bar, Window, Booth seats
 */
public class Seat 
{
	public String mSeatType; //type of seat ---> Bar or Window or Booth
	public int mSeatMax; //maximum # of people seat can hold ---> Bar(1), Window(4), Booth(6)
	public int mSeatID; //each seat identified by unique number ---> Bar(#0 - #9), Window(odd#10 - #29), Booth(even#10 - 29)
	
	CirQueue<SeatReservation> mReserveQ; //queue of reservations
	
	
	public Seat() //default constructor
	{
		 mSeatType = "Default Seat Type";
		 mSeatMax = 1;
		 mSeatID = 1;
		 mReserveQ = new CirQueue<SeatReservation>();
	}
	
	public Seat(int seatMax, String seatType, int seatNum) //constructor
	{
		mSeatType = seatType;
		mSeatMax = seatMax;
		mSeatID = seatNum;
		mReserveQ = new CirQueue<SeatReservation>();
	}
	
	
	public String identifySeatType() //identifies type of seat based on seatID
	{
		return mSeatType;		
	}
	
	public int getWaitTime(int now)
	{
		int waittime = 0;

		
		if(this.mReserveQ.isEmpty()) //if queue is empty, wait time is 0
		{
			return 0;
		}
		
		//get last reservation start time + 60 min 
		waittime = ((SeatReservation) mReserveQ.mTail.getData()).mFinishMin;

		if(now > waittime)
		{
			return 0;
		}
		
		return waittime - now;
	}
	
	
	
	
	

}
