package ReverseBinary;

import java.util.Scanner;

public class ReversedBinary {
    public static void main(String[] args) {
        int number; 
System.out.println(Integer.toBinaryString(2>>1));
System.out.println(2>>1);
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer");
        number=in.nextInt();

        if (number <0)
            System.out.println("Error: Not a positive integer");
        else { 
        	System.out.println(Integer.toBinaryString(number));
            System.out.print("Convert to binary is:");
            binaryform(number);
    /// System.out.println(binaryform(number));
        }
    }

    private static void binaryform(int number) {
        int remainder;
boolean cont=true;
        if (number <=1) {
            System.out.print(number);
            cont=false;
            //  return number;// KICK OUT OF THE RECURSION
        }

        if(cont)
        {
        remainder= number %2; 
        binaryform(number >>1);
        System.out.print(remainder);
        }
        //return number;
    }
}
