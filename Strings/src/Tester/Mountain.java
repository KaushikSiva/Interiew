package Tester;

import java.io.*;
public class Mountain {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int[] arr = {1,2,1,4,1,2,1,1,3,1};
    System.out.println(getWaterQuantity(arr));
}
    



public static int getWaterQuantity(int[] arr)
{
    
    int water = 0;
    for(int i=0;i<arr.length;i++)
    {
        int leftIndex ;
        int rightIndex;
        int j=i;
        int leftMax = i;
        int rightMax = i;
        while(j>0)
        {
            if(arr[j]>arr[leftMax])
            {
                leftMax = j;
            }
            j--;
        }
        j=i;
        while(j<arr.length )
        {
            if(arr[j]>arr[rightMax])
            {
                rightMax = j;
            }
            j++;
        }
        if(leftMax>=0 && rightMax<arr.length)
        {
        int thisIndex = Math.min(arr[leftMax],arr[rightMax]) - arr[i];
        water = water + thisIndex;
        }
    }

  return water;
    
    
}






}