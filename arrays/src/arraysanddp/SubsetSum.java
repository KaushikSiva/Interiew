package arraysanddp;
//Q63
	public class SubsetSum {

	    public static boolean partition(int arr[],int sum){
	        boolean[][] dp = new boolean[arr.length+1][sum+1];
	        
	        for(int i=0; i <= arr.length; i++){
	            dp[i][0] = true;
	        }
	        for(int i=1; i <= arr.length; i++){
	            for(int j=1; j <= sum; j++){
	                if(j - arr[i-1] >= 0){
	                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
	                }
	                else
	                {
	                	dp[i][j] = dp[i-1][j];
	                }
	            }
	        }
	        return dp[arr.length][sum];
	    }
	    
	    public static void main(String args[]){
	        int arr[] = {1,2,5,6};
	        boolean r  = partition(arr,3);
	        System.out.print(r);
	    }
	
}
