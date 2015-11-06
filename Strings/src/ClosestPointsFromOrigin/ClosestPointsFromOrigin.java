package ClosestPointsFromOrigin;
import java.util.Collections;
//Q67
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
public class ClosestPointsFromOrigin {
	static Map<String,Double> hm =new TreeMap<String,Double>(); 
	

	 
	
	  public static double calculateDistance(double x1, double y1, double x2, double y2)
	  {
	    return Math.sqrt( Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2) );
	  }
	  public static void main (String[] args)
	  {
	    
	    Scanner scan = new Scanner (System.in);
	    System.out.println("Enter number of points other than orgin ");
	    int numbers = scan.nextInt();
	    System.out.println("Fill in the points: ");
	    double[][] list = new double[numbers+1][2];
	    double n1=0,n2=0,n3=0,n4=0;
	    
	    list[0][0] = 0;
	    list[0][1] = 0;
	    
	    for (int i = 1;i<list.length;i++)
	    {     
	      list[i][0] = scan.nextDouble();
	      list[i][1] = scan.nextDouble();
	    }
//	    double min = calculateDistance(list[0][0],list[0][1],list[1][0],list[1][1]);
//	    System.out.println(min);
	     findclosest(list);
	   
	  }
	   private static void findclosest(double list[][])
	   {
		   double min;
		   for (int j=1;j<list.length;j++)
		    {
		          min = calculateDistance(list[0][0],list[0][1],list[j][0],list[j][1]);
	             hm.put(list[j][0]+","+list[j][1],min);
		        
		      }
		    hm=sortMap(hm,true);
		    printMap(hm);
	   }
	  
	  private static Map<String, Double> sortMap(Map<String, Double> unsortMap, final boolean order)
	    {

	        List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(unsortMap.entrySet());

	        // Sorting the list based on values
	        Collections.sort(list, new Comparator<Entry<String, Double>>()
	        {
	            public int compare(Entry<String, Double> o1,
	                    Entry<String, Double> o2)
	            {
	                if (order)
	                {
	                    return o1.getValue().compareTo(o2.getValue());
	                }
	                else
	                {
	                    return o2.getValue().compareTo(o1.getValue());

	                }
	            }
	        });

	        // Maintaining insertion order with the help of LinkedList
	        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
	        for (Entry<String, Double> entry : list)
	        {
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }

	        return sortedMap;
	    }

	    public static void printMap(Map<String, Double> map)
	    {
	        for (Entry<String, Double> entry : map.entrySet())
	        {
	            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
	        }
	    }
	   
	}

