import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Graphs {

	
	static public List<Node> nodes=new LinkedList();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node frankfurt = new Node("A");
		Node mannheim = new Node("B");
		Node wurzburg = new Node("C");
		Node stuttgard = new Node("D");
		Node kassel = new Node("E");
		Node karlsruhe = new Node("F");
		Node erfurt = new Node("G");
		Node numberg = new Node("H");
		Node augsburg = new Node("I");
		Node munchen = new Node("J");

		Graphs g = new Graphs();

		nodes.add(frankfurt);
		nodes.add(mannheim);
		nodes.add(wurzburg);
		nodes.add(stuttgard);
		nodes.add(kassel);
		nodes.add(karlsruhe);
		nodes.add(erfurt);
		nodes.add(numberg);
		nodes.add(augsburg);
	    nodes.add(munchen);

		frankfurt.addAdjacentNode(mannheim,1);
		frankfurt.addAdjacentNode(wurzburg,2);
		frankfurt.addAdjacentNode(kassel,3);

		mannheim.addAdjacentNode(karlsruhe,4);

		karlsruhe.addAdjacentNode(augsburg,5);

		augsburg.addAdjacentNode(munchen,6);

		munchen.addAdjacentNode(kassel,5);
		munchen.addAdjacentNode(numberg,5);

		wurzburg.addAdjacentNode(erfurt,3);
		wurzburg.addAdjacentNode(numberg,2);

		numberg.addAdjacentNode(stuttgard,1);
		System.out.println("KKKKKKKKKKKKKKKKKK");
		
		Node node=g.BFS(frankfurt,"J");
		while(node!=null)
		{
			System.out.println(node.data);
			node=node.previous;
		}
		System.out.println("KKKKKKKKKKKKKKKKKK");
		Node test=secondshortest(g,frankfurt,munchen);
		System.out.println(munchen.data);
		while(test!=null)
		{
			System.out.println(test.data);
			test=test.previous;
		}
		System.out.println("======================");
		for(Node graphNode:nodes)
		{
			graphNode.isVisited=false;
		}
		g.DFS(frankfurt);
		System.out.println("LLLLLLLLL");
		Node root=clone(frankfurt);
		Node root2=g.BFS(root,"J");
		while(root2!=null)
		{
			System.out.println(root2.data);
			root2=root2.previous;
		}
		System.out.println("LLLLLLLLL");
        System.out.println(map2);
	}
	
	
	public static Node secondshortest(Graphs g,Node node,Node endNode)
	{
		
		HashMap<String ,Integer> hm=g.djiksra(node);
		System.out.println(hm);
		Node result1=null;
		Node result2 = null;
		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
         for(Node noder:endNode.adjNodes)
         {
        	 if (hm.get(noder.data)+noder.edge.get(endNode)<min1)
        	 {
        		 min2=min1;
        		 result2=result1;
        	     min1=hm.get(noder.data)+noder.edge.get(endNode);
        	     result1=noder; 
        	 } 
        	 
        	 else if(hm.get(noder.data)+noder.edge.get(endNode)<min2)
        	 {
        		 min2=hm.get(noder.data)+noder.edge.get(endNode);
        	     result2=noder; 
        	 }
         }
         return result2;
         
         
	}
	public void DFS(Node rootNode) {

		Stack<Node> s = new Stack();
		s.add(rootNode);
		rootNode.isVisited = true;
		while(!s.isEmpty()){
			Node n = s.pop();
			System.out.println(n.data +  " ");
			for(Node adj : n.adjNodes){
				if(!adj.isVisited){
					adj.isVisited = true;
					s.push(adj);
				}
			}
		}
	}

	
	static HashMap<Node,Node> map = new HashMap<Node,Node>(); //This map is gonna be used to check if a node has been already created,
	static HashMap<String,String> map2 = new HashMap<String,String>(); 
	static //we use the original node as a key and the clone node as the value.
	 
	Node clone(Node node)
	{
	    if(map.containsKey(node)) //if the current node has been already cloned then just return the cloned node
	        return map.get(node);
	 
	    Node newNode = new Node(node.data);  // create the clone node
	    map.put(node, newNode); // put the clone into the map
	    map2.put(node.data, newNode.data);
	    ArrayList<Node> nei = new ArrayList<Node>(); //create a new arraylist of neighbors for the new node
	 
	// loop through the neighbors of the original node and call our function recursively to build the new list of neighbors
	    for(Node n : node.adjNodes)
	        nei.add(clone(n));
	 
	    newNode.adjNodes = nei;
	    return newNode;
	}
 // public static void djikstra

	public Node BFS(Node root,String needed)
	{
		Queue<Node> queue =new LinkedList();
		queue.add(root);
		root.isVisited=true;
		while(!queue.isEmpty())
		{
			Node out=queue.remove();
			//out.isVisited=true;
			//System.out.println(out.data);
			if(out.data.equals(needed))
			{
                
				queue.clear();
				return out;
			}
			for(Node node:out.adjNodes)
			{
		  if(!node.isVisited)
		  {
			queue.add(node);
			node.previous=out;
			node.isVisited=true;
			
		  }
			}
			
		}
		return null;
	}
	
	
	public HashMap djiksra(Node node)
	
	{
		System.out.println("=======dij==============");
		HashMap<String,Integer> dist=new HashMap();
		HashMap<String,String> previous=new HashMap();
        List<Node> allnodes=new LinkedList();
        List<Node> visitednodes=new LinkedList();
		for(Node city:nodes)
		{
			dist.put(city.data, Integer.MAX_VALUE);
			//previous.put(city.data, "");
			allnodes.add(city);
		}
		System.out.println(dist);
		dist.put(node.data,0);
		while(!allnodes.isEmpty())
		{
			
		visitednodes.add(node);
		allnodes.remove(node);
		for(Node out: node.adjNodes)
		{
			if(dist.get(node.data)!=Integer.MAX_VALUE&& out.edge.get(node) !=Integer.MAX_VALUE&& out.edge.get(node)+dist.get(node.data)<=dist.get(out.data) && !visitednodes.contains(out))
			{
				out.previous=node;
			 dist.put(out.data,out.edge.get(node)+dist.get(node.data));
            //previous.put(out.data, node.data);
			}
		}
		node=findMin(node,dist,visitednodes);;
		}
		System.out.println(dist);
		return dist;
	}
	
	public static Node findMin(Node node,HashMap<String,Integer> dist,List<Node> visited)
	{
	
		Node temp = null;
		int min=Integer.MAX_VALUE;
		for(Node out:nodes)
		{
			
			if(!visited.contains(out))
				{
				int x=dist.get(out.data);
				if(x<min)
				{
				   min=x;
				   temp=out;
				   }
				}
			
		}
		return temp;
	}
	
	
}

class Node{
	
	String data;
	
	Node previous=null;
	boolean isVisited=false;
	
	List<Node> adjNodes=new LinkedList<Node>();
	HashMap<Node,Integer> edge =new HashMap();
	public Node(String data)
	{
		this.data=data;
	}
	public void addAdjacentNode(Node node,int cost)
	{
		adjNodes.add(node);
		edge.put(node, cost);
		node.adjNodes.add(this);
		node.edge.put(this,cost);
	}
	
	public void removeAdjacentNode(Node node)
	{
		adjNodes.remove(node);
		edge.remove(node);
		node.adjNodes.remove(this);
		node.edge.remove(this);
	}
	

}
