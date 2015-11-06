package sortingsearching;

//Q28
public class quicksort {

	public static void main(String[] args) {
		int num[] = {9,10,3,5,123,4545,6767,4,56,87,665,32};
		quicksort(num, 0, num.length-1);
		System.out.println("hope it works! ");
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + "\n");
		}
	
	}
	public static void quicksort(int[] num, int low, int high) {
		if (low < high) {
			int pivot = partition(num, low, high);
			quicksort(num, low, pivot-1);
			quicksort(num, pivot + 1, high);
		}
	}
	public static int partition(int[] num, int low, int high) {
		
		int pivot=low;
		int i = low;
		int temp;
		for (int j = low+1; j <= high; j++) {
			if (num[j] < num[pivot]) {
				i++;
				
                temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				//System.out.println("exchanging"+num[i]+num[j]);
				
			} 
		}
			temp = num[i];
			num[i] = num[pivot];
			num[pivot] = temp;

		return i;
	}

}
 