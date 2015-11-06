package sortingsearching;
//Q30
public class ModifiedBinarySearch {
//median unsorted median 2 jump out of hashcode and equals,add2 linked lists,operatring system,system design ,maths and bits,glassdoor and career cup 3,4 questions
	public static void main(String args[])
	{
		int [] x={7,8,33,-3,0,1,2,3,4,5,6};
		System.out.println(findMin(x));
	}
	static int findMin(int arr[])
	{
		// index of first element
		int l = 0;

		// index of last element.
		 int h = arr.length - 1;

		 int mid;
		// always restrict the search to the unsorted 
		// sub-array. The min is always there.
		while (arr[l] > arr[h]) {
		        // find mid.
		        mid = (l + h)/2;
		        // decide which sub-array to continue with.
		        if (arr[mid] > arr[h]) {
		                l = mid + 1;
		        } else {
		                h = mid;
		        }
		}
		// answer
		return arr[l];
	}
}
