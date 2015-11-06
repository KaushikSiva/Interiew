import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class LinkedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double los=new Double(100);
		System.out.println(los.MAX_VALUE);
	Double[] temp= new Double[2147483645];
   LinkedList<Integer> a=new LinkedList();
   LinkedList<Integer> b=new LinkedList();
   LinkedList<Integer> c=new LinkedList();
   LinkedList<Integer> d=new LinkedList();
   d.add(1);
   d.add(2);
   d.add(3);
   d.add(3);
   d.add(2);
   d.add(6);
   d.add(1);
   a.add(3);
   a.add(3);
   a.add(4);
   a.add(5);
   a.add(6);
   a.add(9);
   a.add(14);
   b.add(1);
   b.add(2);
   b.add(7);
   b.add(8);
   b.add(19);
   b.add(20);
  a.add(20);
  c=dups2(d);
  System.out.println(c);
   c=dups(a);
  System.out.println(c);
   c=merge(a,b);
   for(int x:c)
   {
	   System.out.println(x);
   }
   c=intersection(a,b);
   for(int x:c)
   {
	   System.out.println(x);
   }
	}
	
	
	
	public static LinkedList intersection(LinkedList<Integer> a,LinkedList<Integer> b)
	{
		LinkedList<Integer> c=new LinkedList();
        HashMap<Integer,Integer> valmap=new HashMap();
		for(int x:a)
		{
			if( valmap.get(x)==null)
			valmap.put(x, 1);
			
		}
		for(int y:b)
		{
			if(valmap.get(y) !=null && !c.contains(y))
			{
				c.add(y);
			}
		}
		return c;
	}
	public static LinkedList dups(LinkedList<Integer> a)
	{
	  LinkedList<Integer> c=new LinkedList<Integer> ();
	  int prev=0;
	  for(int x:a)
	  {
		  if(prev!=x)
		  {
		  c.add(x);
		  prev=x;
		  }
			  
	  }
	  return c;
	}
	public static LinkedList dups2(LinkedList<Integer> a)
	{
		HashSet<Integer> set=new HashSet<Integer>();
	  LinkedList<Integer> c=new LinkedList<Integer> ();
	  int prev=0;
	  for(int x:a)
	  {
		 set.add(x);
			  
	  }
	  c.addAll(0, set);
	  return c;
	}
	public static LinkedList merge(LinkedList a,LinkedList b)
	{
		LinkedList<Integer> c=new LinkedList();
         int count1=0;int count2=0;
		int i1=(int) a.get(0), i2=(int)b.get(0);
		while(count1<a.size() && count2<b.size())
			
		{
			if(i1<=i2)
			{
				c.add(i1);

				count1++;
				if(count1<a.size())
				i1=(int)a.get(count1);

				
			}
			else
			{
				c.add(i2);
				count2++;
				if(count2<b.size())
				i2=(int)b.get(count2);
			}
		}
		while(count1<a.size())
		{
			c.add((int)a.get(count1));
			count1++;
		}
		while(count2<b.size())
		{
			c.add((int)b.get(count2));
			count2++;
		}
		return c;
	}

	
	
	
}
