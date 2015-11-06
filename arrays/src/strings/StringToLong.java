package strings;
//Q48
public class StringToLong {
	public static long StringToLong(String s) throws NumberFormatException{
		//null input
		if(s==null)
			throw new NumberFormatException("cannot convert null to number");
		//handle empty input
		if(s.trim().isEmpty())
			throw new NumberFormatException("cannot convert empty String to number");
		//handle inputs with commas
		s=s.replaceAll(",", "");
		//Replaces all leading 0's
		//handle whitespace
		s=s.trim();
		//special case Min Value
		if(s.equals("-9223372036854775808"))
			return Long.MIN_VALUE;
		int asciiZero = 48;
		int asciiNine = 57;
		long answer = 0;
		long currDigitsPlace = 1;
		boolean negative =false;
		//set negative flag
		if(s.charAt(0)=='-')
		{
			negative = true;
			s=s.substring(1);
		}
		//if user inputs +ve sign its ok we ignore
		else if(s.charAt(0) == '+')
		{
			s=s.substring(1);
		}
		if(s.length()>=21)
			throw new NumberFormatException("input String Too Large for Long.Many characters than expected");
		//replace leading zeros
		s=s.replaceFirst("^0+(?!$)", "");
		//trim again blank space
		s=s.trim();
		char c;
		for(int i = s.length()-1; i >= 0; i-- ){
			c = s.charAt(i);
			if(c < asciiZero || c > asciiNine){
				throw new NumberFormatException(s+"not a number");
			}
			int  thisDigit = (c-asciiZero);
			 if((thisDigit * currDigitsPlace) <= (Long.MAX_VALUE - answer))
			 {
			   answer =  thisDigit * currDigitsPlace + answer;
			 }
			 else
				 throw new NumberFormatException("input String Too Large for Long");
			 if(currDigitsPlace < Long.MAX_VALUE / 10)
			   currDigitsPlace *= 10;
			 else if(i!=0 && currDigitsPlace > Long.MAX_VALUE / 10)
				 throw new NumberFormatException("input String Too Large for Long");
		}
		if(negative)
			answer = -answer;
		return answer;
	}
	
	public static void main(String args[])
	{
		long plusSign = StringToLong("+213");
		check(plusSign,213);
		
		long min =StringToLong("-9223372036854775808");
	    check(min,-9223372036854775808L);
		long max =StringToLong("9223372036854775807");
		check(max,9223372036854775807L);
		long normalpos =StringToLong("123");
		check(normalpos,123L);
		long difflen =StringToLong("233");
		failureCheck(difflen,2230L);
		long unequal =StringToLong("233");
		failureCheck(unequal,245L);
		long oppsign =StringToLong("233");
		failureCheck(oppsign,-233L);
		long zero =StringToLong("0");
        check(zero,0L);
        long zerostart =StringToLong("+0000000000000000002");
        check(zerostart,2L);
		long commas  = StringToLong("1,2,3,4");//we want 1234?(assumed)
		check(commas,1234L);
		try{
		long emptyIn =StringToLong("                 ");
		System.out.println(emptyIn);//Throw Exception
		}
		catch(NumberFormatException e)
		{
			System.out.println("success");
		}
		try{
			long exceedrangelen =StringToLong("922337203685477581022");//Exceeds number of digits long
			System.out.println(exceedrangelen);//Throw Exception
		}
		catch(NumberFormatException e)
		{
				System.out.println("successExp");
		}
		
		try{
			long exceedrangeneg =StringToLong("-9223372036854775809");//Exceeds number of digits long
			System.out.println(exceedrangeneg);//Throw Exception
		}
		catch(NumberFormatException e)
		{
				System.out.println("successExp");
		}
		
		try{
			long exceedrangepos =StringToLong("9223372036854775808");//Exceeds number of digits long
			System.out.println(exceedrangepos);//Throw Exception
		}
		catch(NumberFormatException e)
		{
				System.out.println("successExp");
		}
		
		
	}
	public static void check(long val,long expected)
	{
		if(val==expected)
			System.out.println("success");
		else
			System.out.println("failure");
	}
	
	public static void failureCheck(long val,long expected)
	{
		if(val!=expected)
			System.out.println("success");
		else
			System.out.println("failure");
	}
}