package arraysanddp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Arrays {

	public static void main(String[] args) {
       
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		//Q31
        System.out.println("searching sorted matrix");
        System.out.println(find(a,4,4,13));
        System.out.println("==================");
        //Q6
		System.out.println("Ninety degrees");
		ninetyDegrees(a);
		System.out.println("=================");
		int[][] b = { { 1, 2, 3, 4 }, { 5, 6, 7, 0 }, { 9, 0, 11, 12 },
				{ 13, 0, 15, 16 } };
		//Q7
		System.out.println("MakeZero");
		makeZero(b);
		System.out.println("==================");
		//Q10
        System.out.println("Rotate");
		int[] arr= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14};
		System.out.println(java.util.Arrays.toString(rotate(arr, 3)));
		System.out.println("=====================");
		//Q12
		System.out.println("Longest Palindromic Subsequence");
		char[] chars = {'a','g','b','d','b','a'};
		lps1(chars);
		System.out.println("======================");
		//Q11
		System.out.println("Longest Palindromic Substring");
		char[] chars2 = {'d','o','o','o','o','d'};
		lps2(chars2);
		System.out.println("=====================");
		//Q14
		System.out.println("Lcsubstr");
		char[] in1={'c','b','c','f','l','h'};
		char[] in2={'c','e','d','c','b','c','h'};
		lcs1(in1,in2);
		System.out.println("=====================");
		//Q13
		System.out.println("LCsubseq");
		lcs2(in1,in2);
		System.out.println("======================");
		//Q53
		System.out.println("Edit Distance");
		System.out.println(editDistance(new String("abcdef").toCharArray(), new String("azced").toCharArray()));
		System.out.println("================");
		//Q32 2 versions of coin change no. of ways to make given some and min number of coins to make the no.
		System.out.println("Coin Change");
		System.out.println(coinChange(new int[]{2,3,5,6},10));
		System.out.println("===============");
		System.out.println("Min CoinChange");
		System.out.println(minCoinChange(new int[]{1,5,6,8},11));
		System.out.println("===============");
		//Q16
		System.out.println("LIS");
		System.out.println(LIS(new int[]{3,4,-1,0,6,2,3}));
		System.out.println("===============");
		//Q25
		System.out.println("Knapsack");
		System.out.println(knapSack(new int[]{1,1,1},new int[]{1,4,9},2));
		System.out.println("=========================");
		//Q15
		System.out.println("MaxcontinousSum");
		System.out.println(mcs(new int[]{1,2,-1,4,5,6,-2,1}));
		System.out.println("====================");
		//Q19
		System.out.println("Two Sum");
		System.out.println(twoSum(new int[]{2,3,6,7,9},5));
		System.out.println("====================");
		//Q39
		int [] array = {1,2,3,-1,-5,6,7};
		System.out.println("negPosonEachSide");
		System.out.println(negpos(array));
		System.out.println("=================");
		//Q40
		System.out.println("BuySell");
		buysell();
		System.out.println("=================");
		//Q43s
		System.out.println("TriangeTypes");
		triangletypes(3, 4, 5);
		System.out.println("====================");
		//Q46
		System.out.println("Power");
		System.out.println(pow(2,5));
		System.out.println("=================");
		//Q49
		System.out.println("Sqrt");
		System.out.println(sqrt(10));
		System.out.println("=================");
		//Q61
		System.out.println("allsubarr");
		allsubstr(new int[]{1,2,3,4,5,6});
		System.out.println("===================");
		//Q38
		System.out.println("shuffle");
		System.out.println(java.util.Arrays.toString(shuffle(new int[]{1,2,3,4,5})));
		//System.out.println("Rectangles Intersect");
		//Q56 sum to N
		//(n*(n+1))/2
	}
	


   public static int knapSack(int[]wt,int[] val,int total)
   {
	   int[][] dp = new int[wt.length+1][total+1];
	   boolean[][] sol = new boolean[wt.length+1][total+1];
	   for(int i=0;i<=wt.length;i++)
	   {
		   dp[i][0]=0;
	   }
	   for(int i=0;i<=wt.length;i++)
	   {
		   for(int j=0;j<=total;j++)
		   {
			   if(i==0||j==0)
			   {
				   dp[i][j]=0;
				   continue;
			   }
			   if(wt[i-1]>j)
				   dp[i][j] = dp[i-1][j];
			   else
			   {
				   if(dp[i-1][j]>(val[i-1]+dp[i-1][j-wt[i-1]]))
				   {
					   dp[i][j]= dp[i-1][j];
				   }
				   else
				   {
					   dp[i][j]=val[i-1]+dp[i-1][j-wt[i-1]];
					   sol[i][j]=true;
				   }
			   }
		   }
	   }
	   printDoubleMatrix(dp);
	   boolean[] take = new boolean[wt.length+1];
	   for(int i=wt.length,w=total;i>0;i--)
	   {
		   if(sol[i][w])
		   {
			   take[i-1] = true;
			   
			   w= w-wt[i-1];
		   }
		   else
		   {
			   take[i-1]=false;
		   }
		   
	   }
	   // print results
       System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
       for (int n = 1; n <= wt.length; n++) {
           System.out.println(n + "\t" + val[n-1] + "\t" + wt[n-1] + "\t" + take[n-1]);
       }
	   return dp[wt.length][total];
			   
   }
   public static int LIS(int[] arr)
   {
	   int max = Integer.MIN_VALUE;
	   int[] dp = new int[arr.length];
	   for(int i=0;i<arr.length;i++)
		   dp[i]=1;
	   
	   for(int i=1;i<arr.length;i++)
	   {
		   for(int j=0;j<i;j++)
		   {
		     if(arr[j]<arr[i])
		     {
		    	 if(dp[i]<dp[j]+1)
		    		 dp[i] = dp[j]+1;
		     }
		   }
	   }
	   for(int iter:dp)
	   {
		   if(iter>max)
			   max = iter;
	   }
	   return max;
   }
	
   
   public static int minCoinChange(int[] S,int N)
	{
		int[][]dp = new int[S.length+1][N+1];
		for(int i =1;i<=N;i++)
		{
			dp[0][i]=i;
		}
		for(int i =1;i<=S.length;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(S[i-1]>j)
				{
					dp[i][j]=dp[i-1][j];
				}
				else
				{
				dp[i][j]=Math.min(dp[i-1][j], 1+dp[i][j-S[i-1]]);
				}
			}
		}
		printCoins(dp,S);
		return dp[S.length][N];
	}
	public static int coinChange(int[] S,int N)
	{
		int[][]dp = new int[S.length+1][N+1];
		for(int i =0;i<=S.length;i++)
		{
			dp[i][0]=1;
		}
		for(int i =1;i<=S.length;i++)
		{
			for(int j=1;j<=N;j++)
			{
				if(S[i-1]>j)
				{
					dp[i][j]=dp[i-1][j];
				}
				else
				{
					dp[i][j]=dp[i-1][j]+dp[i][j-S[i-1]];
				}
			}
		}
		return dp[S.length][N];
	}
	public static void printCoins(int[][] dp,int[]S)
	{
		int i = dp.length-1;
		int j=dp[0].length-1;
		int k= dp[i][j];
		while(k>0)
		{
			if(dp[i][j]==dp[i-1][j])
			{
				k=dp[i-1][j];
				i=i-1;
			}
			else
			{
				k=dp[i][j-S[i-1]];
				j=j-S[i-1];
				if(S[i-1]!=0)
				System.out.print(S[i-1]+",");
			}
		}
		System.out.println();
	}
	public static int editDistance(char[] s1,char[] s2)
	{
		int[][] dp =new int [s1.length+1] [s2.length+1];
		for(int i=0;i<=s1.length;i++)
		{
			dp[i][0]= i;
		}
		for(int j=0;j<=s2.length;j++)
		{
			dp[0][j]= j;
		}
		for(int i=1;i<=s1.length;i++)
		{
			for(int j=1;j<=s2.length;j++)
			{
			  if(s1[i-1]==s2[j-1])
			  {
				  dp[i][j] = dp[i-1][j-1];
			  }
			  else
			  {
				  int min1 = dp[i][j-1];
				  int min2=  dp[i-1][j-1];
				  int min3=  dp[i-1][j];
				  
				  int finalmin =Math.min(min1, min2);
				  finalmin = Math.min(finalmin, min3);
				  dp[i][j] = finalmin+1;
			  }
			}
		}
		printOperations(s1,s2,dp);
		return dp[s1.length][s2.length];
	}
	
	public static void printOperations(char[] s1,char[] s2,int[][] dp)
	{
		printDoubleMatrix(dp);
		
		int i= dp.length-1;
		int j = dp[0].length-1;
		int k=dp[i][j];
		
		while(k>=1)
		{
			
			if(dp[i-1][j-1]==dp[i][j] && s1[i-1]==s2[j-1])
			{
				k =dp[i-1][j-1];
				i=i-1;
				j=j-1;
			}
			
			else if(dp[i-1][j-1] +1 ==dp[i][j])
			{
				System.out.println(s2[j-1]+"->"+s1[i-1]);
				k =dp[i-1][j-1];
				i=i-1;
				j=j-1;
			}
			else if(dp[i][j-1] +1 ==dp[i][j])
			{
				System.out.println("d"+s1[i-1]);
				k = dp[i][j-1];
				j=j-1;
			}
			else
			{
				System.out.println("y"+s1[i-1]);
				k = dp[i-1][j];
				i=i-1;
			}
			
		}
		
	}
	
	public static void lcs2(char[] chars1,char[] chars2)
	{
		String ans="";
		//dp array
		int start = -1;
		int max = 1;
		int i,j,k;
		int[][] dp =new int[chars1.length+1][chars2.length+1];
		
		for(i = 0;i<=chars1.length;i++)
		{
			for(j=0;j<=chars2.length;j++)
			{
			if(i==0||j==0)
				dp[i][j]=0;
			else if(chars1[i-1]==chars2[j-1])
			{
				dp[i][j]=dp[i-1][j-1]+1;
			}
			else
			{
				dp[i][j]=Math.max(dp[i-1][j],dp[i] [j-1]);
			}
			}
		}
		System.out.println(dp[chars1.length][chars2.length]);
		backtrack2(chars1, dp);
		
	}
    
	public static void lcs1(char[] chars1,char[] chars2)
	{
		String ans="";
		//dp array
		int start = -1;
		int max = -1;
		int indexi =-1;
		int indexj =-1;
		int i,j,k;
		int[][] dp =new int[chars1.length+1][chars2.length+1];
		
		for(i = 0;i<=chars1.length;i++)
		{
			for(j=0;j<=chars2.length;j++)
			{
			if(i==0||j==0)
				dp[i][j]=0;
			else if(chars1[i-1]==chars2[j-1])
			{
				dp[i][j]=dp[i-1][j-1]+1;
				if(dp[i][j]>max)
				{
					indexi=i;
					indexj=j;
					max=dp[i][j];
				}
			}
			else
			{
				dp[i][j]=0;
			}
			}
		}
		System.out.println(max);
	while(dp[indexi][indexj]>0)
	{
		System.out.print(chars1[indexi-1]+",");
		indexi--;
		indexj--;
	}
	System.out.println();
		
	}
	public static void lps2(char[] chars)
	{
		String in=new String(chars);
		String ans="";
		//dp array
		int start = -1;
		int max = 1;
		int i,j,k;
		int[][] dp =new int[chars.length][chars.length];
		
		for(i=0;i<chars.length;i++)
		{
			dp[i][i] = 1;
			if(i<chars.length-1)
			{
			if(chars[i]==chars[i+1] )
			{
			  dp[i][i+1] =1;
			  max =2;
			  start =i;
			}
			else
				dp[i][i+1]=0;
			}
		}
		
		for(k=3;k<=chars.length;k++)
		{
			for(i = 0;i<chars.length-k+1;i++)
			{
				j = i+k-1;
			    if(chars[i]==chars[j] && dp[i+1][j-1] == 1)
				{
					dp[i][j]= 1;
					start =i;
					max = k;
				}
				else
				{
					dp[i][j]=0;
				}
			}
		}
		System.out.println(max);
		System.out.println(in.substring(start, start+max));
		
	}
	public static void lps1(char[] chars)
	{
		
		int i,j,k;
		int[][] dp =new int[chars.length][chars.length];
		
		for(i=0;i<chars.length;i++)
		{
			dp[i][i] = 1;
			if(i<chars.length-1)
			{
			if(chars[i]==chars[i+1] )
			{
			  dp[i][i+1] =2;
			}
			else
				dp[i][i+1]=1;
			}
		}
		
		for(k=3;k<=chars.length;k++)
		{
			for(i = 0;i<chars.length-k+1;i++)
			{
				j = i+k-1;
				if(chars[i]==chars[j])
				{
					dp[i][j]=2+dp[i+1][j-1];
				}
				else
				{
					dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
				}
			}
		}
		System.out.println(dp[0][chars.length-1]);
		backtrack(chars,dp);
		
	}
	public static void printDoubleMatrix(int[][] dp)
	{
		for(int i=0;i<dp.length;i++)
		{
			for(int j=0;j<dp[i].length;j++)
			{
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void backtrack2(char[] chars,int[][] dp)
	 {

		List<Integer> index = new ArrayList<Integer>();
        String ans="";
		int k = dp[dp.length-1][dp[0].length-1];
		int i= dp.length-1;
		int j = dp[0].length -1;
		while(k>1)
		{
			
			if(k==dp[i][j-1])
			{
				k=dp[i][j-1];
				j= j-1;
			}
			else if(k==dp[i-1][j])
			{
				k=dp[i-1][j];
				i=i-1;
			}
			else
			{
			index.add(i-1);
			k= dp[i-1][j-1];
			i = i-1;
			j=j-1;
			}
			
		}
		index.add(i-1);
		Collections.sort(index);
		for(Integer inter:index)
		{
		ans=ans+(chars[inter]+",");	
		}
		ans=ans.substring(0, ans.length()-1);
		System.out.println(ans);
	
	}
	public static void backtrack(char[] chars,int[][] dp)
	{
		List<Integer> index = new ArrayList<Integer>();
        String ans="";
		int k = dp[0][chars.length-1];
		int i=0;
		int j = chars.length -1;
		while(k>1)
		{
			
			if(k==dp[i][j-1])
			{
				k=dp[i][j-1];
				j= j-1;
			}
			else if(k==dp[i+1][j])
			{
				k=dp[i+1][j];
				i=i+1;
			}
			else 
			{
			index.add(i);
			index.add(j);
			k= dp[i+1][j-1];
			i = i+1;
			j=j-1;
			}
			
		}
		index.add(i);
		Collections.sort(index);
		for(Integer inter:index)
		{
		ans=ans+(chars[inter]+",");	
		}
		ans=ans.substring(0, ans.length()-1);
		System.out.println(ans);
	
	}
	public static int gcd(int a,int b)
	{
		if(b == 0)
			return a;
		else
	     return gcd(b,a%b);
	}
	public static int[] rotate(int[] arr,int d)
	{
		int temp,i,j,k;
		for(i=0;i<gcd(d,arr.length);i++)
		{
			j=i;
			temp=arr[i];
			while(true)
			{
				k = j + d;
				if(k >= (arr.length))
					k = k - (arr.length);
				if(k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		return arr;
	}

	public static void makeZero(int[][] b) {
		boolean[] row = new boolean[b.length];
		boolean[] column = new boolean[b[0].length];
		int i, j;
		for (i = 0; i < b.length; i++) {
			for (j = 0; j < b[i].length; j++) {
				if (b[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		System.out.println("initial array");
		for (i = 0; i < b.length; i++) {
			for (j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}

		for (i = 0; i < b.length; i++) {
			for (j = 0; j < b[i].length; j++) {
				if (row[i] || column[j])
					b[i][j] = 0;
			}
		}

		System.out.println("final array");
		for (i = 0; i < b.length; i++) {
			for (j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void ninetyDegrees(int[][] a) {

		for (int layer = 0; layer < a.length / 2; layer++) {
			int first = layer;
			int last = a.length - 1 - layer;

			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = a[first][i];

				a[first][i] = a[last - offset][first];

				a[last - offset][first] = a[last][last - offset];

				a[last][last - offset] = a[i][last];

				a[i][last] = top;
			}

		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[] negpos(int[] array)
	{
	int n=array.length;
	int solution[] = new int[n];
	for (int i= 0,j=0 ; i < n ; i++ ) {
	     if (array[i] < 0) solution[j++] = array[i];
	}
	for (int i = n-1,j=n-1 ; i > 0 ; i--) {
	     if (array[i] >= 0) solution[j--] = array[i];
	}
	return solution;
	}
	
	public static int[] oddeven(int[] array)
	{
	int n=array.length;
	int solution[] = new int[n];
	for (int i= 0,j=0 ; i < n ; i++ ) {
	     if (array[i]%2==0) solution[j++] = array[i];
	}
	for (int i = n-1,j=n-1 ; i > 0 ; i--) {
	     if (array[i]%2!=0) solution[j--] = array[i];
	}
	return solution;
	}
	
	public static int mcs(int[] A)
	{
		int[] M = new int[A.length];
		int maxSum=0;
		if(A[0]>0)
			M[0]=A[0];
		else
			M[0]=0;
		for(int i=1;i<A.length;i++)
		{
			if(M[i-1]+A[i]>0)
				M[i]=M[i-1]+A[i];
			else
				M[i]=0;
		}
		
		for(int i=0;i<A.length;i++)
		{
			if(M[i]>maxSum)
				maxSum = M[i];
		}
		return maxSum;
	}
	
	public static boolean twoSum(int[] a,int target)
	{
		HashSet<Integer> hset = new HashSet();
		for(int i = 0;i<a.length;i++)
		{
			if(hset.contains(target - a[i]))
				return true;
			else
				hset.add(a[i]);
		}
		return false;
	}
	//Q45
//  Rectangles Intersect
//	if (RectA.X1 < RectB.X2 && RectA.X2 > RectB.X1 &&
//		    RectA.Y1 < RectB.Y2 && RectA.Y2 > RectB.Y1) 
//		Say you have Rect A, and Rect B. Proof is by contradiction. Any one of four conditions guarantees that no overlap can exist:
//
//		Cond1. If A's left edge is to the right of the B's right edge, - then A is Totally to right Of B
//		Cond2. If A's right edge is to the left of the B's left edge, - then A is Totally to left Of B
//		Cond3. If A's top edge is below B's bottom edge, - then A is Totally below B
//		Cond4. If A's bottom edge is above B's top edge, - then A is Totally above B
//		So condition for Non-Overlap is
//
//		Cond1 Or Cond2 Or Cond3 Or Cond4
//		Therefore, a sufficient condition for Overlap is the opposite (De Morgan)
//
//		Not Cond1 And Not Cond2 And Not Cond3 And Not Cond4
	public static void triangletypes(int a ,int b,int c)
	{
		if(c==Math.sqrt((Math.pow(a, 2)+(Math.pow(b, 2)))) ||
				b==Math.sqrt((Math.pow(a, 2)+(Math.pow(c, 2))))||
						a==Math.sqrt((Math.pow(c, 2)+(Math.pow(b, 2))))
				)
				{
			 System.out.println("Right Triangle");
				}
		else if(a == b && b==c)
		{
			System.out.println("Equi");
		}
		else if(a==b || b==c || a==c)
		{
			System.out.println("Isoceles");
		}
		else if (c > a+b || a>b+c || b>a+c)
		{
			System.out.println("Not a triangle");
		}
		else
		{
			System.out.println("Scalene");
		}
	}
	
	public static void buysell()
	{
	    double[] values = { 55.39, 109.23, 48.29, 81.59, 81.58, 105.53, 94.45, 12.24 };

	    double max = Double.MIN_VALUE, maxDiff = Double.MIN_VALUE, diff = 0;
	    double bottom = values[0];

	    for (int i = 1; i < values.length; i++)
	    {
	        diff += values[i] - values[i - 1];

	        if (diff > maxDiff)
	        {
	            maxDiff = diff;
	            max = values[i];
	        }

	        if (values[i] < bottom)
	        {
	            bottom = values[i];
	            diff = 0;
	        }
	    }
	    
	    double buyat=max-maxDiff;

	    System.out.println("Buy at "+buyat+"Sell at "+max);
	}
	
	public static boolean find(int a[][],int rows,int cols,int x){
	    int m=0;
	    int n=cols-1;
	while(m<rows&&n>=0){
	    if(a[m][n]==x)
	        return true;
	    else if(a[m][n]>x)
	        n--;
	    else m++;
	}
	return false;

	}
	
	public static long pow(long base, long exp){        
	    if(exp ==0){
	        return 1;
	    }
	    if(exp ==1){
	        return base;
	    }

	    if(exp % 2 == 0){
	        long half = pow(base, exp/2);
	        return half * half;
	    }else{
	        long half = pow(base, (exp -1)/2);
	        return base * half * half;
	    }       
	}
	
	public static double sqrt(int number) {
		double t;
	 
		double squareRoot = number / 2;
	 
		do {
			t = squareRoot;
			squareRoot = (t + (number / t)) / 2;
		} while ((t - squareRoot) != 0);
	 
		return squareRoot;
	}
	
//	function minimax(node, depth, maximizingPlayer)
//    if depth = 0 or node is a terminal node
//        return the heuristic value of node
//    if maximizingPlayer
//        bestValue := -∞
//        for each child of node
//            val := minimax(child, depth - 1, FALSE)
//            bestValue := max(bestValue, val)
//        return bestValue
//    else
//        bestValue := +∞
//        for each child of node
//            val := minimax(child, depth - 1, TRUE)
//            bestValue := min(bestValue, val)
//        return bestValue
//
//     (* Initial call for maximizing player *)
//     minimax(origin, depth, TRUE)
// http://neverstopbuilding.com/minimax
	
	public static void allsubstr(int[] arr)
	   {
	      int length = arr.length;   
	      System.out.println("SubArrays of Array are :-");
	      for(int c = 0 ; c < length ; c++ )
	      {
	         for(int i = 1 ; i <= length - c ; i++ )
	         {
	            int[] sub= java.util.Arrays.copyOfRange(arr, c,c+i);
	            System.out.println(java.util.Arrays.toString(sub));
	         }
	      }
	   }
	
	public static int[] shuffle(int[] input)
	{
		for(int i=input.length -1; i> 0 ;i--)
		{
			int randomIndex =(int)(Math.random() * 100)%i;
			int temp = input[i];
			input[i]= input[randomIndex];
			input[randomIndex]=temp; 
		}
		return input;
	}
}
