
public class Solution {

		
		static boolean[][] board;
		static int N;
		public static void main(String[] args) {
			
			
			int[] a = {3,1,4,2};
			N = a.length;
			int max =0;
			board = new boolean[N][N];
			for(int i=0;i<a.length;i++)
			{
				board[i][a[i]-1]=true;
			}
			
			for(int i=0;i<a.length;i++)
			{
				int targets=QueenSafe(i, a[i]-1);
				if(targets>max)
					max = targets;
			}

			System.out.println(max);
		}
		
		public static int QueenSafe(int row ,int col)
		{
			  int count =0;
			  int i, j;
			    /* Check this row on left side */
			    for (i = 0; i < N; i++)
			    {
			        if (board[row][i] && i!=col)
			        {
			        	count++;
			        	break;
			        }
			    }
			    for (j = 0; j < N; j++)
			    {
			        if (board[j][col] && j!=row)
			        {
			        	count++;
			        	break;
			        }
			    }
			    for (i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
			    {
			    	
			        if (board[i][j])
			        {
			            count++;
			            break;
			        }
			    } 
			    for (i = row-1, j = col+1; i >= 0 && j <N; i--, j++)
			    {
			    	
			        if (board[i][j])
			        {
			            count++;
			            break;
			        }
			    }
			    
			    for (i = row+1, j = col-1; j >= 0 && i < N; i++, j--)
			    {
			        if (board[i][j])
			        {
			        	count++;
			        	break;
			        }
			    }
			    
			    for (i = row+1, j = col+1; j <N && i < N; i++, j++)
			    {
			        if (board[i][j])
			        {
			        	count++;
			        	break;
			        }
			    }
			    return count;
			    
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


