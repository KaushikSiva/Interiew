import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LinkedList {

	
	static Node head=null;
	static Node tail=null;
	static Node inter=null;
	
	public static  void main(String args[])
	{
		
		
		createll(10);
	 	print(head);
		insert(false,20);
		insert(false,30);
		insert(false,40);
		insert(false,50);
		insert(false,70);
	 	print(head);
		insert(true,60);
	    print(head);
		print(head);
		inter=interveawe(head);
	    print(inter.next);
		System.out.println(search(head,30));
		delete(true);
		print(head);
		delete(false);
		print(head);
		deletemiddle(3,head);
		print(head);
		insertmiddle(2,99,head);
		System.out.println("here");
		head=reverse(head);
		print(head);
		Node n=ntolast(head,1);
		System.out.println(n.data);
		head=deleteall(head);
		print(head);
	}
	
	
	
	public static void createll(int data)
	{
		Node node=new Node(data);
		head=tail=node;
	}
	
	
	public static void print(Node node)
	
	{
		while(node!=null)
		{
			System.out.print(node.data+"->");
			node=node.next;
		}
		System.out.println();
	}
	
	public static boolean search(Node node,int data)
	{
		while(node!=null)
		{
			if(node.data==data)
				return true;
			node=node.next;
		}
		return false;
	}
	
	public static void delete(boolean first)
	{
		if(first)
		{
			Node temp=head;
			head=head.next;
			temp=null;
		}
		else
		{
			Node temp=head;
			Node prev=null;
			while(temp.next!=null)
			{
				prev=temp;
				temp=temp.next;
			}
			tail=prev;
			temp=null;
			tail.next=temp;
			
		}
	}
	
	public static boolean deletemiddle(int post,Node node)
	{
		int count=0;
		Node prev=null;
		Node nextnode;
		while(node.next!=null && count<post-1)
		{
			prev=node;
			node=node.next;
			count++;
		}
		if(count==post-1)
		{
			nextnode=node.next;
			prev.next=nextnode;
			node=null;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static void insert(boolean addtofirst,int data)
	
	{
		Node node=new Node(data);
		if(addtofirst)
		{
			node.next=head;
			head=node;
		}
		else
		{
			tail.next=node;
			tail=node;
		}
	}
	
	public static void insertmiddle(int pos,int data,Node node)
	{
		int count=0;
		Node newnode =new Node(data);
		while(node!=null && count<pos-1)
		{
			node=node.next;
			count++;
		}
		if(count==pos-1)
		{
			Node nextnode=node.next;
			node.next=newnode;
		    newnode.next=nextnode;
		}
		else
		{
			tail.next=newnode;
			tail=newnode;
		}
	}
	
	public static Node reverse(Node node)
	
	{
		Node temp=node;
		Node prev=null;
		while(node!=null)
		{
			temp=node.next;
			node.next=prev;
			prev=node;
			node=temp;
		}
		return prev;
	}
	
	public static boolean loop(Node node)
	
	{
		if(node==null)
			return false;
		Node fast=node;
		Node slow=node;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	public static Node ntolast(Node node,int n)
	{
		if(node==null)
			return null;
		int count=0;
		Node first=node;
		Node second=node;
		while(first!=null && count<n)
		{
			first=first.next;
			count++;
		}
		if(count!=n)
			return null;
		while(first!=null)
		{
			first=first.next;
			second=second.next;
		}
		return second;
	}
	public static void delete(Node node)
	{
		Node temp=node.next;
		node.data=temp.data;
		node.next=temp.next;
		temp=null;
	}
	
	public static Node deleteall(Node node)
	{
		Node temp=null;
		while(node!=null)
		{
			 temp=node.next;
			 node=null;
			 node=temp;
		}
		return node;
	}
	
	public static Node interveawe(Node node)
	{
		Node slow=node;
		Node fast=node;
		Node temp=null;
		
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast.next!=null)
			slow=slow.next;
		temp=reverse(slow);
	    Node link=merge(node,temp);
        return link;
	}
	
	public static Node merge(Node node,Node temp)
	{
		Node headmerged=new Node();
		Node tailmerged=headmerged;
		boolean turn=true;
		while(node!=null && temp!=null)
		{
			if(turn==false)
			{
		headmerged.next=temp;
		temp=temp.next;
		turn=true;
			}
			else
			{
				headmerged.next=node;
				node=node.next;
				turn=false;
			}
			headmerged=headmerged.next;
		}
		return tailmerged;
	}

}


class Node
{
	
	int data;
	Node next;
	
	public Node()
	{
		
	}
	public Node(int data)
	{
		this.data=data;
		this.next=null;
	}
}