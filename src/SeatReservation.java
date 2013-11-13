
public class SeatReservation 
{

	public int mStartMin;
	public int mReservationID;
	public String mCusName;
	public int mSeatID;
	public int mFinishMin;
	
	public SeatReservation()
	{
		mStartMin = 0;
		mReservationID = 0;
		mCusName = "NoNameYet";
		mSeatID = 9999;
		mFinishMin = 0;
	}
	
	public SeatReservation(int startTime, int reservationID, String cusName, int seatID, int dineTime)
	{
		mStartMin = startTime;
		mReservationID = reservationID;
		mCusName = cusName;
		mSeatID = seatID;
		mFinishMin = startTime + dineTime;
	
	}
    public String toString()
    {
    	return "(#"+ mReservationID + "=" + mStartMin + ":"+mFinishMin+")";
    }
	
	public int getStartMin()
	{
		return mStartMin;
	}
	
	
	public boolean equals(Object object1) //compares reservationID's
	{
		if(object1 instanceof String)
		{
			//otherID = str to int
			int otherID = Integer.parseInt((String) object1);
			return otherID == this.mReservationID;
		}
		else if(object1 instanceof SeatReservation)
		{
			SeatReservation y = (SeatReservation)object1;
            return y.mReservationID == this.mReservationID;
		}
		
		return false;
	}
}
