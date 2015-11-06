package arraysanddp;

import java.io.*;
//Q68
public class ExcelAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException 
	{
		int ch = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(ch != 10)
		{
			System.out.println("\nMenu\n1.LabelToNum\t2.NumToLabel");
			ch = Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:
					System.out.println("Enter the column name");
					System.out.println("Number is" + convertToNumber(br.readLine()));
					break;
					
				case 2:
					System.out.println("Enter the number");
					System.out.println("String is" + convertToLabel(Integer.parseInt(br.readLine())));
					break;
			}
		}		
	}
	
	private static int convertToNumber(String str)
	{
		int len = str.length();
		if(len == 0)		{
			
			System.out.println("Column name cannot be blank");
			return -1;
		}
		int i = len -1;
		int num = 0, mod = 0, n = 0;
		
		while(i >= 0)
		{
			mod = str.charAt(i) - 64;
			num = num + (int)(Math.pow(26, n)) * mod;
			n++; 
			i--;
		}		
		return num;
	}

	private static StringBuffer convertToLabel(int number)
	{
		StringBuffer convertStr = new StringBuffer();
		int mod = 0;
		char ch;
		
		while(number > 0)
		{
			mod = number % 26;
			if(mod == 0)
				mod = 26;
			number = number /26;
			if(mod == 26)
				number--;
			int ans = 64 + mod;
			ch = (char)ans;
			convertStr.append(ch);
		}

		convertStr.reverse();
		return convertStr;
	}
}
