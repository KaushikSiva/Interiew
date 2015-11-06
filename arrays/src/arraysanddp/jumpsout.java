package arraysanddp;
import java.util.Arrays;
//Q24
public class jumpsout {
	
	public static void main(String args[])
	{
		int arr[]= {2, 0,3,5};
	    System.out.println("Minimum number of jumps to reach end is "+ minJumps(arr,arr.length));
	}
	static int minJumps(int arr[], int n)
	{
	    int []jumps = new int[n];  // jumps[n-1] will hold the result
	    int i, j;
	 
	    if (n == 0 || arr[0] == 0)
	        return Integer.MAX_VALUE;
	 
	    for (i = 1; i < n; i++)
	    {
	    	jumps[i] =Integer.MAX_VALUE;
	        for (j = 0; j < i; j++)
	        {
	            if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE)
	            {
	            	System.out.println(jumps[j]);
	            	jumps[i]=Math.min(jumps[i], jumps[j]+1);
	            }
	        }
	    }
	    return jumps[n-1];
	}
}
