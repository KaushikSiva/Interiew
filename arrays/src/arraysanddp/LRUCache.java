package arraysanddp;
//Q71
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LRUCache <K,V>{
	int size;
	double lf=0.75;
	int intcap=16;
	
	public  LRUCache( int size)
	{
		this.size=size;
	}
	
 LinkedHashMap<K, V> cache=new LinkedHashMap<K,V>(intcap,(float) lf,true)
{
	  @Override
		public boolean removeEldestEntry(java.util.Map.Entry<K,V> eldest)
		{
			boolean ifrem=this.size()>size;
			return ifrem;
		}
	};
	
	public synchronized void put(K key,V Value)
	{
		if(key!=null && Value!=null)
		cache.put(key, Value);
	}

	public synchronized V get(K key)
	{
		return cache.get(key);
	}
	
	public synchronized void clear()
	{
		cache.clear();
	}

	public static void main(String[] args) {
		  LRUCache<String, String> c = new LRUCache<String, String>(3);
		  c.put("1", "one"); // 1
		  c.put("2", "two"); // 2 1
		  c.put("3", "three"); // 3 2 1
		  c.put("4", "four"); // 4 3 2
		  System.out.println(c.get("3"));

		  System.out.println(c.get("2"));

		  System.out.println(c.get("4"));
		  for (Map.Entry<String, String> e : c.cache.entrySet()) {
			   System.out.println(e.getKey() + " : " + e.getValue());
			  }
		 }


}
