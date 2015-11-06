import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTrees {
    static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	public static void main(String args[]) {
		Node root = new Node(25);
		Node node1=insert(root, 15);
		Node node3=insert(root, 10);
		Node node2=insert(root, 17);
		Node node6=insert(root, 13);
		Node node5=insert(root, 32);
		Node node4=insert(root, 27);
		
		
		Node root2=new Node(10);
		Node node7=insert(root2,13);
		print(root);
		System.out.println("===========subtree===================");
		System.out.println(containstree(root,root2));
		System.out.println("===========postorder===================");
		PrintPostOrder(root);
		System.out.println("===========preorder======================");
		PrintPreOrder(root);
		System.out.println("===========pinorder======================");
		PrintInOrder(root);
		 System.out.println("==============save=====================");
		 try
		 {
		 File file=new File("c:\\kaushik\\test.txt");
		 OutputStreamWriter os=null;
		 os=new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		 save(root,os);
		 InputStreamReader br = null;
		 BufferedReader br2=null;
         br=new InputStreamReader(new FileInputStream(file), "UTF-8");
		 br2=new BufferedReader(br);
		 Node p=	read(br2,Integer.MIN_VALUE,Integer.MAX_VALUE);
		 PrintInOrder(p);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }

		System.out.println("============kthsmallvalue=====================");
		Node small=kthsmallest(root,3);
		System.out.println(small.value);
		System.out.println("===========bounded traversal======================");
		boundedtraversal(root);
		System.out.println("==========printsums=======================");
		printSums(root, 23, 0, "");
		System.out.println("==========inorder successor=======================");
        Node g=inOrderSuccessor(root,node3);
        System.out.println(g.value);
        System.out.println("===========diameter======================");//
		System.out.println(diameter(root));
	
		System.out.println("==========search===================");
		 System.out.println(search(root, 32));
		 print(root);
		 System.out.println("=============findMin====================");//
		 System.out.println(findMin(root).value);
		 System.out.println("=============findLCA==================");
		   Node x = findLCA(root, node3, node5);
		  System.out.println(x.value);
		 System.out.println("=============isHeightBalanced===================");//
		 System.out.println(isHeightBalanced(root));
		 System.out.println("==========zigzagbfs=======================");//
		 zigzagBFS(root);
		 System.out.println("==========reversebfs=======================");
		 reverseBFS(root);
		 System.out.println("============BFS=====================");
		 BFS(root);
		 System.out.println("==============levelbylevel===================");//
		
		LinkedList<Node> levels[] = levelbylevel(root);
		for (LinkedList<Node> k : levels) {
			if (k != null) {
				for (Node n : k) {
					System.out.print(n.value+" ");
				}
			}
			System.out.println();
		}
		System.out.println("===========mirror======================");
		Node x2=swap_node(root);
		print(x2);
		int a[]=new int[26];
		for(int i=0;i<=25;i++)
		{
			a[i]=i+1;
		}
		System.out.println("=========buildbinarytree========================");//
		Node node=buildbinarytree(a,0,a.length-1);
         print(node);
         System.out.println("==============delete===================");
		 delete(root, 15);
		 print(root);
		 System.out.println("=================verticalsumof====================");
		 vsum(root,0);
		 System.out.println(map);
	}
	
	
	public static void vsum(Node root,int col)
	{
		if(root == null)
			return;
		vsum(root.left,col-1);
		if(map.containsKey(col))
		{
			int value = map.get(col);
		    map.put(col, value+root.value);
		}
		else
		{
			map.put(col, root.value);
		}
		vsum(root.right,col+1);
	}
	static Node tempnode=null;
	public static Node kthsmallest(Node root,int k)
	{
		
		
		int sizeofleftsubtree=0;
		int count=k;
		while(root!=null)
		{
			System.out.println("Node:"+root.value);
		sizeofleftsubtree=sizeofleftsubtree(root.left);
		reset();
		System.out.println("size:"+sizeofleftsubtree);
		 if(sizeofleftsubtree+1==count)
		 {
			 tempnode= root;
			 System.out.println(tempnode.value);
			 break;
		 }
		 else if(sizeofleftsubtree<count)
		 {
			 root=root.right;
		     count=count-(sizeofleftsubtree+1);

		 }
		 else
		 {
			 root=root.left;
		 }	
		}
		
		return tempnode;
		
		
	}
	
	public static void boundedtraversal(Node root)
	
	{
		
		
		System.out.println(root.value);
		printleftboundary(root.left);
		printleaves(root.left);
		printleaves(root.right);
		printrightboundary(root.right);
		
		
		
	}
	
	public static void printleftboundary(Node root)
	{
		if(root!=null)
		{
			if(root.left!=null)
			{
				System.out.println(root.value);
				printleftboundary(root.left);
			}
			else if(root.right!=null)
			{
				System.out.println(root.value);
				printleftboundary(root.right);	
			}
		}
	}
	public static void printrightboundary(Node root)
	{
		if(root!=null)
		{
			if(root.right!=null)
			{
				
				printrightboundary(root.right);
				System.out.println(root.value);
			}
			else if(root.left!=null)
			{
				
				printrightboundary(root.left);	
				System.out.println(root.value);
			}
		}
	}
	public static void printleaves(Node root)
	{
		if(root!=null)
		{
			printleaves(root.left);
			if(root.left== null && root.right == null)
				System.out.println(root.value);
			printleaves(root.right);
		}
	}
	static Node temp = null;
	public static Node insert(Node root, int value) {
		
		if (value < root.value) {
			if (root.left != null)
				insert(root.left, value);
			else {
				root.left = new Node(value);
				temp= root.left;
			}
		} else {
			if (root.right != null)
				insert(root.right, value);
			else {
				root.right = new Node(value);
				temp= root.right;
			}

		}
		return temp;
	}
	


	static boolean found = false;

	public static boolean search(Node root, int value) {

		if (root != null) {
			if (value == root.value) {
				found = true;
			}

			else if (value < root.value) {
				search(root.left, value);
			} else {
				search(root.right, value);
			}

		}
		return found;

	}
	
	
	public static List search(Node root, Node node) {

	     ArrayList<Node> list = new ArrayList<Node>();
		 Stack<Node> nodes =new Stack<Node>();
		 while(!nodes.isEmpty()||root !=null)
		 {
		 if(root!=null)
		 {
		 nodes.push(root);
		 list.add(root);
		 if(root.equals(node))
		 {
			return list;
		 }
		 root=root.left;
		 }
		 else
		 { 
		 root=nodes.pop();
		 System.out.println(root.value);
		 root=root.right;
		 }
	     }
		 nodes.clear();
		 return null;
		
	}

	public static Node findMin(Node root) {
		if(root == null)
		       return null;
		else if (root.left == null)
			return root;
		else
			return findMin(root.left);
	}
	
	public static Node swap_node(Node root)
	{
		
		if(root!=null)
		{
			Node temp=root.left;
			root.left=root.right;
			root.right= temp;
			swap_node(root.left);
			swap_node(root.right);
		}
		
		return root;
	}
	
	
	
	

	public static Node findMax(Node root) {
      if(root == null)
	       return null;
	    else if (root.right == null)
			return root;
		else
			return findMax(root.right);
	}

	public static Node delete(Node root, int value) {
		if (root == null)
			return null;
		if (root.value > value) {
			return delete(root.left, value);
		} else if (root.value < value) {
			return delete(root.right, value);
		} else {
			if (root.left != null && root.right != null) {
				
				temp = findMin(root.right);
				root.value = temp.value;
				root.right = delete(temp, value);
			} else {
				temp = root;
				if (root.left == null)
					root = root.right;
				else
					root = root.left;
				temp = null;
			}
		}
		return root;
	}

	public static Node findLCA(Node root, Node  p, Node q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;

		else {
			Node l = findLCA(root.left, p, q);
			Node r = findLCA(root.right, p, q);
			if (l != null && r != null)
				return root;
			else if (l != null)
				return l;
			else
				return r;

		}
	}
	
	public static Node findLCA2(Node root, Node n1, Node n2)
	{
	    List<Node> nodes1= search(root, n1);
	    List<Node> nodes2= search(root, n2);
	    // Find paths from root to n1 and root to n1. If either n1 or n2
	    // is not present, return -1
	    if ( nodes1==null|| nodes2==null)
	          return null;
	 
	    /* Compare the paths to get the first different value */
	    int i;
	    for (i = 0; i < nodes1.size() && i < nodes2.size() ; i++)
	        if (nodes1.get(i) != nodes2.get(i))
	            break;
	    return nodes1.get(i-1);
	}
	public static void print(Node root) {
		if (root != null)
		{
			print(root.left);
			System.out.println(root.value);
			print(root.right);

		}

	}
	static int count=0;
	public static int sizeofleftsubtree(Node root) {
		
		if (root != null)

		{
			sizeofleftsubtree(root.left);
			count++;
			sizeofleftsubtree(root.right);

		}
		return count;
   
	}

	public static void reset()
	{
		count=0;
	}
	

	public static boolean isHeightBalanced(Node root) {
		return (root == null)
				|| (isHeightBalanced(root.left) && isHeightBalanced(root.right) && Math
						.round(height(root.left) - height(root.right)) <= 1);
	}
	static int height(Node node) {
		return (node == null) ? 0 : 1 + Math.max(height(node.left),
				height(node.right));
	}

	static int diameter(Node root) {
		if (root == null)
			return 0;
		else
			return (Math.max(
					diameter(root.left),
					Math.max(diameter(root.right), height(root.left)
							+ height(root.right) + 1)));
	}

	public static void BFS(Node root)

	{
		Queue<Node> queue = new LinkedList();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.println(n.value);
			if (n.left != null) {
				queue.add(n.left);
			}
			if (n.right != null) {
				queue.add(n.right);
			}
		}
	}
	
	public static void reverseBFS(Node root)

	{
		Queue<Node> queue = new LinkedList();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.println(n.value);
			
			if (n.right != null) {
				queue.add(n.right);
			}
			if (n.left != null) {
				queue.add(n.left);
			}
		}
	}

	
	public static void zigzagBFS(Node root)

	{
		int count =1;
		Stack<Node> queue = new Stack();
		Stack<Node> queue2 = new Stack();
		Stack<Node> temp = new Stack();
		queue.add(root);
         boolean rtol=false;
		while (!queue.isEmpty()) {
			Node n = queue.pop();
			System.out.println(n.value);
			if(rtol)
			{
			if (n.right != null) {
				queue2.add(n.right);
			}
			if (n.left != null) {
				queue2.add(n.left);
			}
			}
			else
			{
				if (n.left != null) {
					queue2.add(n.left);
				}
				if (n.right != null) {
					queue2.add(n.right);
				}
				
			}
			if(queue.isEmpty())
			{
				if(rtol)
					rtol=false;
				else
					rtol=true;
				temp=queue;
				queue =queue2;
				queue2=temp;
			}
			
			count++;
		}
		
	}
	public static LinkedList[] levelbylevel(Node root)

	{
		int count = 1;
		Queue<Node> queue = new LinkedList();
		Queue<Node> tempqueue = new LinkedList();
		queue.add(root);
		LinkedList<Node>[] levels = new LinkedList[4];
		levels[0] = new LinkedList();
		levels[0].add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();

			if (n.left != null) {
				tempqueue.add(n.left);
				if(levels[count]==null)
				levels[count] = new LinkedList();
				levels[count].add(n.left);
			}
			if (n.right != null) {
				tempqueue.add(n.right);
				if(levels[count]==null)
				levels[count] = new LinkedList();
				levels[count].add(n.right);
			}
			if(queue.isEmpty())
			{
			queue = tempqueue;
			tempqueue= new LinkedList();
			count++;
			}
		}
		return levels;
	}
	
	public static Node buildbinarytree(int []data,int low ,int end)
	{
		if(low>end)
			return null;
		double mid=Math.floor((low+end)/2);
		int imid=(int)mid;
		Node node =new Node(data[imid]);
		node.left=buildbinarytree(data,low,(int)(imid-1));
		node.right=buildbinarytree(data,(int)(imid+1),end);
		return node;
	}
	
	public static void printSums(Node n, int sum, int currentSum, String buffer) {
	     if (n == null) {
	         return;
	     }
	     int newSum = currentSum + n.value;
	     String newBuffer = buffer + " " + n.value;
	     if (newSum == sum) {
	         System.out.println(newBuffer);
	     }
	     printSums(n.left, sum, newSum, newBuffer);
	     printSums(n.right, sum, newSum, newBuffer);
	     printSums(n.left, sum, 0, "");
	     printSums(n.right, sum, 0, "");
	} 

	
	 static Node  inOrderSuccessor(Node root, Node n)
	{
	    // step 1 of the above algorithm
	    if( n.right != null )
	        return findMin(n.right);
	 
	    Node succ = null;
	 
	    // Start from root and search for successor down the tree
	    while (root != null)
	    {
	        if (n.value < root.value)
	        {
	            succ = root;
	            root = root.left;
	        }
	        else if (n.value > root.value)
	            root = root.right;
	        else
	           break;
	    }
	   if(root!=null)
	    return succ;
	   else
		   return null;
	}

	 static void PrintInOrder(Node root)
	 {
		 Stack<Node> nodes =new Stack<Node>();
		 while(!nodes.isEmpty()||root !=null)
		 {
		 if(root!=null)
		 {
		 nodes.push(root);
		 root=root.left;
		 }
		 else
		 {
			 
		 
		 root=nodes.pop();
		 System.out.println(root.value);
		 root=root.right;
		 }
	     }
		 nodes.clear();
	 }
	 
	 static void PrintPreOrder(Node root)
	 {
		 Stack<Node> nodes =new Stack<Node>();
		 while(root!=null || !nodes.isEmpty())
		 {
		 if(root!=null)
		 {
	     System.out.println(root.value);
		 if (root.right != null) nodes.push(root.right);
		 root=root.left;
		 }
		 else
		 {
		 root=nodes.pop();
		 }
		 }
		 nodes.clear();
	 }
	 
	 static void save(Node root,OutputStreamWriter os) throws IOException
	 {
		 Stack<Node> nodes =new Stack<Node>();
		 while(root!=null || !nodes.isEmpty())
		 {
		 if(root!=null)
		 {
	     os.write(root.value+"\n");
	     
		 nodes.push(root);
		 root=root.left;
		 }
		 else
		 {
		 root=nodes.pop();
		 
		 root=root.right;
		 }
		 }
		 os.close();
		 nodes.clear();
		 
		 
		 
	 }
	 
	   private static int cur;
	 private static Node read(BufferedReader br, int min, int max) throws NumberFormatException, IOException {
		 Node p = null;
		      if (cur >= min && cur <= max) {
		    	  p = new Node(cur);
	            String s=br.readLine();
	            if (s!=null) {
	                cur = Integer.parseInt(s);
	                p.left = read(br, min, p.value);
	                p.right = read(br, p.value, max);
	            }
	            return p;
	        }
	        return null;
	    }
	 static void PrintPostOrder(Node root)
	 {
		 Stack<Node> nodes =new Stack<Node>();
		 Node lastvisitednode=null;
		 while(root!=null || !nodes.isEmpty())
		 {
		 if(root!=null)
		 {
		 nodes.push(root);
		 root=root.left;
		 }
		 else 
			 {
			 Node peekNode=nodes.peek();
			 if(peekNode.right!=null && peekNode.right != lastvisitednode)
			 {
				 root=peekNode.right;
			 }
			 else
			 {
				 nodes.pop();
				 System.out.println(peekNode.value);
				 lastvisitednode=peekNode;
			 }
		 }
		 }
		 nodes.clear();
	 }
	 
	 static boolean containstree(Node r1,Node r2)
	 {
		 if(r2==null)return true;
		 else return subtree(r1,r2);
	 }
	 
	 static boolean subtree(Node r1,Node r2)
	 {
		 
		 if(r1==null)
			 return false;
		 if(r1.value== r2.value)
		 {
			 if(matchtree(r1,r2))return true;
		 }
		 boolean found=subtree(r1.right,r2)||subtree(r1.left,r2);
		 return found;
	 }
	 
	 static boolean matchtree(Node r1,Node r2)
	 {
		 if(r1==null && r2==null)
			 return true;
		 if(r1==null || r2==null)
			 return false;
		 if(r1.value!=r2.value)
			 return false;
		 return (matchtree(r1.left,r2.left)&& matchtree(r1.right,r2.right));
	 }
	 
	 

   
}
