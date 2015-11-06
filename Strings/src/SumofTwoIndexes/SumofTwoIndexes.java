package SumofTwoIndexes;

public class SumofTwoIndexes {
	
public static boolean isSumSame(int[] test)
	{
		for(int i=0;i<test.length;i++)
		{
			for(int j=i;j<test.length;j++)
			{
				if((test[i] + test[j] == i+j)&&i!=j)
				{
					return true;
				}
			}
		}
		
		return false;
		
	}

}
