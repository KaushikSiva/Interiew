package arraysanddp;
import java.util.*;
public class fib {

	/**
	 * @param args
	 */
	//Q33 //Q34
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fibrec(5));
		fib(10);
	}
	
	public static int fibrec(int n)
	{
	if(n<=1)
	return n;
	else
	{
	return fibrec(n-1)+fibrec(n-2);
	}
	}

	public static void fib(int n)
	{
	int a=0;
	int b=1;
	int c=0;
	System.out.println(a);
	System.out.println(b);
	  for(int i=0;i<n;i++)
	   {
			c=a+b;
			a=b;
			b=c;
			System.out.println(c);
			
	   }
	}
}
