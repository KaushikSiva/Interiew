package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Strings {
	
	public static void main(String args[]) {
		
		System.out.println("hasDuplicateCharacters:::::::::");
		//Q1
		System.out.println(hasDuplicateCharacters("abcecd", true));
		//Q1
		System.out.println(hasDuplicateCharacters("abcefd", false));
		System.out.println("======================");
		//Q2
		System.out.println("reverse:::::::::::::::");
		reverse("uidsumdc fecve r ");
		System.out.println("======================");
		//Q4
		System.out.println("are anagrams??:::::::::::::::");
		System.out.println(areAnagrams("abcd", "dcba", false));
		System.out.println(areAnagrams("abcd", "dcba", true));
		System.out.println("======================");
		//Q3
		System.out.println("RemoveDuplicates");
		String s = "aaaaaaaaaaaaaaaaabbbbbbbbbbbccccccccd";
		char[] str = s.toCharArray();
		System.out.println(removeDups(str));
		System.out.println("======================");
		//Q5
		System.out.println("Replace String");
		System.out.println(replaceString("a b c d"));
		System.out.println("======================");
		//Q8
		System.out.println("IsSubstring");
		System.out.println(isRotation("abcde","cdabe"));
		System.out.println("======================");
		//Q17
		System.out.println("Wordladder");
		String[] dictarr = new String[]{"hot","dog","dot","log","lot"};
		Set<String> dict = new HashSet<String>();
		for(String str2:dictarr)
		{
			dict.add(str2);
		}
	    System.out.println(wordLadder("hit","cog",dict));
	    System.out.println("=======================");
	    //Q60
	    System.out.println("AllSubstrings");
	    allsubstr("kaushik");
	    System.out.println("=======================");
	    //Q66 www to w3 abbba to ab3a
	    System.out.println("Compress");
	    System.out.println(compress("aaaaaaaaabbcccd"));
	   System.out.println("======================");
	   System.out.println("NewReverse");
	   newReverse("boy is fooods");
	    
	}
	
	public static void newReverse(String s)
	{
	String[] words =  s.split(" ");

	String rev = "";
	for(int i = words.length - 1; i >= 0 ; i--)
	{
	   rev += words[i] + " ";
	}
	System.out.println(rev);
	}
	  public static String compress(String str)
	  {
		  String result ="";
		  int count =0;
		  char prev=str.charAt(0);
		  for(int i=0;i<str.length();i++)
		  {
			  if(str.charAt(i)==prev)
			  {
				  count++;
			  }
			  else
			  {
				  result = result + prev + count;
				  prev = str.charAt(i);
				  count =1 ;
			  }
		  }
		  if(count >0 )
		  {
			  result = result + prev + count;
		  }
		  return result;
	  }
      public static void allsubstr(String string)
	   {
	      int length = string.length();   
	      System.out.println("Substrings of \""+string+"\" are :-");
	      for(int c = 0 ; c < length ; c++ )
	      {
	         for(int i = 1 ; i <= length - c ; i++ )
	         {
	            String sub = string.substring(c, c+i);
	            System.out.println(sub);
	         }
	      }
	}
	
	public static int wordLadder(String beginWord,String endWord,Set<String> dict)
	{
		List<WordNode> queue = new LinkedList<WordNode>();
		WordNode beginWordNode = new WordNode(beginWord, 1);
		queue.add(beginWordNode);
		dict.add(endWord);
		while(!queue.isEmpty())
		{
			WordNode top = queue.remove(0);
			String topWord = top.word;
			if(topWord.equals(endWord))
			{
				return top.numSteps;
			}
			char[] arr = topWord.toCharArray();
			for(int i=0;i<arr.length;i++)
			{
			  for(char c='a';c<='z';c++)
			  {
				  char temp = arr[i];
				  if(arr[i]!=c)
				  {
					  arr[i]=c;
				  }
				  String newWord = new String(arr);
				  WordNode newWordNode= new WordNode(newWord, top.numSteps+1);
				  if(dict.contains(newWord))
				  {
					queue.add(newWordNode);  
					dict.remove(newWord);
				  }
				  arr[i]=temp;
				  
			  }
			}
		}
		return 0;
	}
 public static boolean isRotation(String s1,String s2)
 {
	 if(s1== null || s2 ==null||s1.length()!=s2.length())
		 return false;
	 String s1s1=s1+s1;
	 return isSubstring(s2,s1s1);
 }
 public static boolean isSubstring(String s2,String s1)
 {
	 return true;
 }
	public static String replaceString(String s) {
		String result = "";
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			if (i != str.length - 1)
				result = result + str[i] + "%20";
			else
				result = result + str[i];
		}
		return result;
	}
	
	public static boolean areAnagrams(String s1, String s2, boolean betterWay) {

		if (!betterWay) {
			s1 = s1.toLowerCase().trim();
			s2 = s2.toLowerCase().trim();
			s1 = sort(s1);
			s2 = sort(s2);
			if (s1.equals(s2))
				return true;
			else
				return false;
		} else {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < s1.length(); i++) {
				if (map.containsKey(s1.charAt(i)))
					map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
				else
					map.put(s1.charAt(i), 1);
			}
			for (int j = 0; j < s2.length(); j++) {
				if (map.containsKey(s2.charAt(j)) && map.get(s2.charAt(j)) > 0)
					map.put(s2.charAt(j), map.get(s2.charAt(j)) - 1);
				else
					return false;
			}
			return true;
		}
	}

	public static void reverse(String s) {
		char temp;
		char[] chars = s.toCharArray();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		s = String.valueOf(chars);
		System.out.println(s);
	}

	public static String sort(String s) {
		char temp;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[j] < chars[i]) {
					temp = chars[i];
					chars[i] = chars[j];
					chars[j] = temp;
				}
			}
		}
		return String.valueOf(chars);
	}

	public static boolean hasDuplicateCharacters(String s, boolean additional) {

		s = s.toLowerCase();
		s = s.trim();
		if (additional) {
			HashSet<Character> hset = new HashSet<Character>();
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (hset.contains(chars[i])) {
					return false;
				} else {
					hset.add(chars[i]);
				}
			}
			return true;
		}
		if (additional) {
			HashSet<Character> hset = new HashSet<Character>();
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (hset.contains(chars[i])) {
					return false;
				} else {
					hset.add(chars[i]);
				}
			}
			return true;
		} else {
			char temp;
			char[] chars = sort(s).toCharArray();
			temp = '\0';
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == temp) {
					return false;
				} else {
					temp = chars[i];
				}
			}
			return true;
		}
	}

	public static String removeDups(char[] str) {
		HashSet<Character> hs = new HashSet<Character>();
		int count = 0;
		int tail = 0;
		while (count < str.length) {
			if (!hs.contains(str[count])) {
				str[tail] = str[count];
				hs.add(str[count]);
				tail++;
			}
			count++;
		}
		str = Arrays.copyOf(str, tail);
		return String.valueOf(str);
	}
}