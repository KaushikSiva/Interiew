

public class mytries {

	public static void main(String args[])
	{
		TrieNode root=createTree();
		String[] words={"kaushik","is","a","ant","kou","rockstar","rock","an","ant"};
		for(String word:words)
		{
			insertWord(root,word);
		}
		System.out.println(findWord(root,"kaushik"));
		int level=0;
		char[] branch=new char[26];
		printtree(root,level,branch);
	}
	
	static void printtree(TrieNode root,int level,char[] branch)
	{
		if(root==null)return;
		
		for(int i=0;i<root.links.length;i++)
		{
			branch[level]=root.letter;
			printtree(root.links[i],level+1,branch);
		}
		
		if(root.fullword)
		{
			for(int j=1;j<=level;j++)
			{
				System.out.print(branch[j]);
				
			}
			System.out.println();
		}
	}
	static TrieNode createTree()
	{
		return (new TrieNode('\0'));
	}
	static void insertWord(TrieNode root,String word)
	{
		int offset=97;
		TrieNode curNode=root;
		char[] letter=word.toCharArray();
		
		for(int i=0;i<letter.length;i++)
		{
			if(curNode.links[letter[i]-offset]==null)
				curNode.links[letter[i]-offset] = new TrieNode(letter[i]);
				curNode=curNode.links[letter[i]-offset];
			
		}
		
		curNode.fullword=true;
	}
	
	static boolean findWord(TrieNode root,String word)
	{
		int offset=97;
		TrieNode curNode=root;
		char[] letter=word.toCharArray();
		
		for(int i=0;i<letter.length;i++)
		{
			if(curNode.links[letter[i]-offset]==null)
				return false;
				curNode=curNode.links[letter[i]-offset];
			
		}
		
		if(!curNode.fullword) return false;
		
		return true;
		
	}
}

class TrieNode
{
	char letter;
	TrieNode[] links;
	boolean fullword;
	TrieNode(char letter)
	{
		this.letter=letter;
		this.links=new TrieNode[26];
		this.fullword=false;
	}
}