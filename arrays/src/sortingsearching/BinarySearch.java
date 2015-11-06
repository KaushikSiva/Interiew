package sortingsearching;

import java.util.*;
//Q29
public class BinarySearch{
        public static void main(String[] args) {
                int[] intArray = new int[10];
                int searchValue = 0, index;
                System.out.println("Enter 10 numbers");
                Scanner input = new Scanner(System.in);
                for (int i = 0; i < intArray.length; i++) {
                        intArray[i] = input.nextInt();
                }
                System.out.print("Enter a number to search for: ");
                searchValue = input.nextInt();
                index = binarySearch(intArray, searchValue);
                if(index == 2)
                	System.out.println("Array not in order");
                if (index != -1) {
                        System.out.println("Found at index: " + index);
                } else {
                        System.out.println("Not Found");
                }
        }

        static int binarySearch(int[] search, int find) {
                int start, end, midPt;
                start = 0;
                end = search.length - 1;
                while (start <= end) {
                        midPt = (start + end) / 2;
                        if (search[midPt] == find) {
                                return midPt;
                        } else if (search[midPt] < find) {
                                start = midPt + 1;
                        } else {
                        	end = midPt- 1;
                        }
                }
                return -1;
        }
        
        public int binarySearch2(int[] a, int x) { 
            return binarySearch(a, x, 0, a.length - 1);
         }
        
         // need extra low and high parameters
         private int binarySearch(int[ ] a, int x,
               int low, int high) {
            if (low > high) return -1; 
            int mid = (low + high)/2;
            if (a[mid] == x) return mid;
            else if (a[mid] < x)
               return binarySearch(a, x, mid+1, high);
            else // last possibility: a[mid] > x
               return binarySearch(a, x, low, mid-1);
         }

}

