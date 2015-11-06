package arraysanddp;

public class PowersOfTwo {
	
	public static void main(String args[])
	{
		sum_powers_of_two(4);
	}

	static void
	sum_powers_of_two(int n)
	{
		int i=1;
		long sum=0;
		int cnt=0;

		while (cnt < n) {
			System.out.println("2 power"+cnt+"="+i);
			sum += i;
			i = i << 1;
			cnt++;
		}

		System.out.println("Sum of first n powers of two is: "+ sum);
		int x= (2 << n)-2;
		System.out.println(x);
	}
}
