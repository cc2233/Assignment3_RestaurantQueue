
public class TimeKeep {
	
	public int mM; //minute
	
	public TimeKeep(int min) //constructor
	{
		mM = min;
	}
	
	public String minToString(int min)
	{
		String result;
		result = (min/60) + ":" + (min%60);
		
		return result;
	}
	
	
		

}
