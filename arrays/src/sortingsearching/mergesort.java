package sortingsearching;
//Q27
public class mergesort {
	public static void main(String[] args) {
		// input numbers here
		int num[] = { 5, 7, 6, 2, 13, 45, 66, 87, 12, 34 };
		int[] results = mergeSort(num);
		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i] + " ");
		}
		insSort(results);
	}
   //bogoSort
	//while not isInOrder(deck):
    //shuffle(deck)
	public static void insSort(int[] a) {
		int i, j, temp;
		for (i = 1; i < a.length; i++) {
			j = i - 1;
			while (j >= 0 && a[j] < a[i]) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i = j;
				j--;

			}
		}
		for (int x = 0; x < a.length; x++) {
			System.out.println(a[x]);
		}
	}

	public static int[] mergeSort(int[] num) {
		if (num.length <= 1)
			return num;
		int middle = num.length / 2;
		int left[] = new int[middle];
		int right[] = new int[num.length - middle];

		for (int i = 0; i < middle; i++) {
			left[i] = num[i];
		}

		for (int i = middle, j = 0; i < num.length && j < right.length; i++, j++) {
			right[j] = num[i];
		}

		left = mergeSort(left);
		right = mergeSort(right);

		int[] result = merge(left, right);
		// Find left and right of array
		// sort the smaller lists
		// once sorted merge the list according to the order

		return result;
	}

	public static int[] merge(int a[], int b[]) {
		int result[] = new int[a.length + b.length];
		int j = a.length - 1;
		int k = b.length - 1;
		int i = j + k + 1;
		while (j >= 0 || k >= 0) {
			if (j >= 0 && k >= 0) {
				if (a[j] >= b[k]) {
					result[i] = a[j];
					// remove from a
					--j;
				} else {
					result[i] = b[k];
					// remove from b
					--k;
				}
			} else if (j >= 0) {
				result[i] = a[j];
				--j;
				// remove from a
			} else {
				result[i] = b[k];
				--k;
			}
			--i;

		}
		return result;
	}
}