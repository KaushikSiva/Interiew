package strings;

public class IntegerToString {
	public static String intToString(int n) { 
		boolean ind = false;
		if(n<0)
		{
			ind = true;
			n = -n;
		}
			
	    if (n == 0) return "0";
	    if(n == Integer.MIN_VALUE) return "-2147483648";
	    StringBuilder sb = new StringBuilder();
	    while (n > 0) { 
	        int curr = n % 10;
	        n = n/10;
	        sb.append(curr);
	    }
	    String s = sb.substring(0);
	    sb = new StringBuilder();
	    for (int i = s.length() -1; i >= 0; i--) { 
	        sb.append(s.charAt(i));
	    }
	    if(ind)
	     return "-"+sb.substring(0);
	    else
	    return sb.substring(0);
	}
	
	
	public static void main(String args[])
	{
		System.out.println(intToString(Integer.MIN_VALUE));
	}
}
