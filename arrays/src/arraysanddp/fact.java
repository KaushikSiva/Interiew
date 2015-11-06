package arraysanddp;
import java.util.*;

public class fact {

	/**
	 * @param args
	 */
	//Q35
	public static void main(String[] args) {
		
		System.out.println(fact(1L));
		System.out.println(factrec(100L));
	}
	
	public static long fact(long n)
	{
		long count=n;
		while (count>1)
		{
			n=n*(count-1);
			count --;
		}
		return n;
		
	}
	
	public static long factrec(long k)
	
	{
		long ans=0;
		
		if(k<=1)
			return 1;
		else
		{
		return	k=k* factrec(k-1);
	}
	}

}
