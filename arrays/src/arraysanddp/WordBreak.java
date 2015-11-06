package arraysanddp;

import java.util.HashSet;
import java.util.Set;
//Q52
public class WordBreak {
	   /**
     * Dynamic programming version for breaking word problem.
     * It returns null string if string cannot be broken into multipe words
     * such that each word is in dictionary.
     * Gives preference to longer words over splits
     * e.g peanutbutter with dict{pea nut butter peanut} it would result in
     * peanut butter instead of pea nut butter.
     */
    public static String breakWordDP(String word, Set<String> dict){
       int [][] dp = new int[word.length()][word.length()];
       for(int i=0;i<dp.length;i++)
       {
    	  for(int j=0;j<dp[0].length;j++)
    	  {
    		  dp[i][j] = -1;
    	  }
       }
       
       for(int l=1;l<=word.length();l++)
       {
    	   for(int i=0;i<word.length()-l+1;i++)
    	   {
    		   int j = i + l -1;
    		   
    		   String str = word.substring(i, j+1);
    		   if(dict.contains(str))
    		   {
    			   dp[i][j]=i;
    			   continue;
    		   }
    		   
    		   for(int k=i+1;k<=j;k++)
    		   {
    			   if(dp[i][k-1]!=-1 && dp[k][j]!=-1)
    			   {
    				   dp[i][j] = k;
    				   break;
    			   }
    			   
    		   }
    	   }
       }
       
       if(dp[0][word.length()-1] == -1)
    	   return null;
       
       StringBuffer buffer = new StringBuffer();
       int i=0,j=word.length()-1;
       while(i<j)
       {
    	   int k=dp[i][j];
    	   if(i==k)
    	   {
    		   buffer.append(word.substring(i, j+1));
    		   break;
    	   }
    	   buffer.append(word.substring(i, k)+" ");
    	   i=k;
       }
       return buffer.toString();
    }

    
    public static void main(String args[]){
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("I");
        dictionary.add("like");
        dictionary.add("hads");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay";
        String result1 = breakWordDP(str, dictionary);
        
        System.out.print(result1);
    }
}
