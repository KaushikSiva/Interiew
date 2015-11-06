package strings;
//Q44
public class Interleaving {
	 public static boolean isInterleaved(char str1[], char str2[], char str3[]){
	        boolean dp[][] = new boolean[str1.length +1][str2.length +1];
	        if(str1.length+str2.length!=str3.length)
	        	return false;
	        for(int i=0;i<dp.length;i++)
	        {
	        	for(int j=0;j<dp[i].length;j++)
	        	{
	        		int l=i+j-1;
	        		if(i==0 && j==0)
	        			dp[i][j] = true;
	        		else if(i==0)
	        		{
	        			if(str2[j-1]==str3[l])
	        				dp[i][j] = dp[i][j-1];
	        		}
	        		else if(j==0)
	        		{
	        			if(str1[i-1]==str3[l])
	        				dp[i][j] = dp[i-1][j];
	        		}
	        		else
	        		{
	        			dp[i][j] = (str1[i-1]==str3[l]?dp[i-1][j]:false)||(str2[j-1]==str3[l]?dp[i][j-1]:false);
	        			
	        		}
	        	}
	        }
	        return dp[str1.length][str2.length];
	    }
	    
	    public static void main(String args[]){
	        String str1 = "XXYM";
	        String str2 = "XXZT";
	        String str3 = "XXXZXYTM";
	        System.out.println(isInterleaved(str1.toCharArray(), str2.toCharArray(), str3.toCharArray()));
	    }
}
