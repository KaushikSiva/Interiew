package arraysanddp;
//Q9
public class Spiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0, 1, 2, 3, 4, 5 }, 
				        {  6, 7, 8, 9, 10, 11 },
				        { 12, 13, 14, 15, 16, 17 },  
				        { 18, 19, 20, 21, 22, 23 } };
        spiral(matrix);
        System.out.println();
		spiralOrderFromTopLeft(matrix);
		System.out.println();
		spiralOrderFromTopRight(matrix);
	}

	public static void spiral(int[][] matrix)
	{
	if(matrix.length == 0)
	return;

	int top = 0;
	int down = matrix.length - 1;
	int left = 0;
	int right = matrix[0].length - 1;

	try
	{
	while(top<down && left < right)
	{
	for(int j=left;j<=right;j++)
	System.out.print(matrix[top][j]+" ");

	top++;

	for(int i=top;i<=down;i++)
	System.out.print(matrix[i][right]+" ");

	right--;

	for(int j=right;j>=left;j--)
	System.out.print(matrix[down][j]+" ");

	down--;

	for(int i=down;i>=top;i--)
	System.out.print(matrix[i][left]+" ");

	left++;
	}

	}
	catch(Exception e)
	{
	System.out.print("Incorrect matrix");
	}

	}
	public static void spiralOrderFromTopLeft(int[][] matrix) {
		if (matrix.length == 0)
			return;
		int top = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		try {
			while (top < down && left < right) {
				// Print top row
				for (int j = left; j <= right; j++)
					System.out.print(matrix[top][j] + " ");
				top++;
				// Print right column
				for (int i = top; i <= down; i++)
					System.out.print(matrix[i][right] + " ");
				right--;
				// Print bottom row
				for (int j = right; j >= left; j--)
					System.out.print(matrix[down][j] + " ");
				down--;
				// Print left column
				for (int i = down; i >= top; i--)
					System.out.print(matrix[i][left] + " ");
				left++;
			}
		} catch (ArrayIndexOutOfBoundsException ae) {
			System.out.println("Incorrect matrix format");
		}
	}

	public static void spiralOrderFromTopRight(int[][] matrix) {
		if (matrix.length == 0)
			return;
		int top = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		try{
		while (top < down && left < right) {
			// Print top row
			for (int j = right; j >= left; j--)
				System.out.print(matrix[top][j] + " ");
			top++;
			// Print right column
			for (int i = top; i <= down; ++i)
				System.out.print(matrix[i][left] + " ");
			left++;
			// Print bottom row
			for (int j = left; j <= right; ++j)
				System.out.print(matrix[down][j] + " ");
			down--;
			// Print left column
			for (int i = down; i >= top; --i)
				System.out.print(matrix[i][right] + " ");
			right--;
		}
	} catch (ArrayIndexOutOfBoundsException ae) {
		System.out.println("Incorrect matrix format");
	}
	}
}
