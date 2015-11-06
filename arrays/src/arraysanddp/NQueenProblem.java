package arraysanddp;
//Q62
public class NQueenProblem {
	
	static boolean[][] board;
	static int N;
	public static void main(String[] args) {
		 N = 4;
		board = new boolean[N][N];
		solveNQUtil(0);
		printBoard(board);
	}
	
	public static boolean QueenSafe(int row ,int col)
	{
		  int i, j;
		  
		    /* Check this row on left side */
		    for (i = 0; i < col; i++)
		    {
		        if (board[row][i])
		            return false;
		    }
		 
		    /* Check upper diagonal on left side */
		    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
		    {
		        if (board[i][j])
		            return false;
		    }
		 
		    /* Check lower diagonal on left side */
		    for (i = row, j = col; j >= 0 && i < N; i++, j--)
		    {
		        if (board[i][j])
		            return false;
		    }
		 
		    return true;
	}
	
	/* A recursive utility function to solve N Queen problem */
	public static boolean solveNQUtil(int col)
	{
	    /* base case: If all queens are placed then return true */
	    if (col >= N)
	        return true;
	 
	    /* Consider this column and try placing this queen in all rows
	       one by one */
	    for (int i = 0; i < N; i++)
	    {
	        /* Check if queen can be placed on board[i][col] */
	        if ( QueenSafe(i, col) )
	        {
	            board[i][col] = true;
	 
	            /* recur to place rest of the queens */
	            if (solveNQUtil(col + 1))
	                return true;
	            board[i][col] = false;
	        }
	    }
	 
	     /* If queen can not be place in any row in this colum col
	        then return false */
	    return false;
	}
	 
	
	public static void printBoard(boolean[][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}
}


