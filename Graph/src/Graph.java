import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Graph {

static int visited[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Enter the number of Nodes");
Scanner scan=new Scanner(System.in);
int nodes=scan.nextInt();
int[][] matrix={{0,1,0,0,0,0},
                {1,0,1,0,1,0},
                {0,1,0,1,0,0},
                {0,0,1,0,0,0},
                {0,1,0,0,0,1},
                {0,0,0,0,1,0}
               };
int visited[]=new int[nodes];
//Q76
BFS(0,nodes,matrix);
//Q77
dfs(0,nodes,matrix);
System.out.println("kaushik");
DFS(0,nodes,matrix,visited);

int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 15, 10, 0, 2, 0, 0},
        {0, 0, 0, 14, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}
       };
//Q78
djiktra(graph, 9,0);
	}

	
	static void BFS(int start,int nodes,int[][] graph)
	{
		Queue<Integer> queue=new LinkedList();
		int visited[]=new int[nodes];
		for(int i=0;i<nodes;i++)
		  visited[i]=0;
		queue.add(start);
		System.out.println("\n visit"+start);
		visited[start]=1;
		while(!queue.isEmpty())
		{
			start=queue.remove();
			// visit and add adjecency vertices
			for(int i=0;i<nodes;i++)
				if(visited[i]==0 && graph[start][i]!=0)
				{
					queue.add(i);
					visited[i]=1;
					System.out.println(i);
				}
		}
	}
	
	static void dfs(int start, int nodes,int[][] graph)
	{
		Stack<Integer> queue=new Stack();
		int visited[]=new int[nodes];
		for(int i=0;i<nodes;i++)
		  visited[i]=0;
		queue.push(start);
		System.out.println("\n visit"+start);
		visited[start]=1;
		while(!queue.isEmpty())
		{
			start=queue.pop();
			System.out.println(start);
			// visit and add adjecency vertices
			for(int i=0;i<nodes;i++)
				if(visited[i]==0 && graph[start][i]!=0)
				{
					queue.push(i);
					visited[i]=1;
				}
		}
	}
	
	static void DFS(int start,int nodes,int[][] graph,int[] visited)
	{
		System.out.println(start);
		visited[start]=1;
		for(int i=0;i<nodes;i++)
			if(visited[i]==0 && graph[start][i]!=0)
			{
				DFS(i,nodes,graph,visited);
			}
	}
	
	static void djiktra(int[][]graph,int nodes,int start)
	{
		int[] dist=new int[nodes];
		int[] previous=new int[nodes];
		boolean splset[]=new boolean[nodes];
		for(int i=0;i<dist.length;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			previous[i]=Integer.MAX_VALUE;
			splset[i]=false;
		}
		dist[start]=0;
		for(int count=0;count<nodes;count++)
		{
		int n=findmin(splset,dist);
		splset[n]=true;
		for(int i=0;i<nodes;i++)
		{
			if(graph[n][i]!=0 && dist[n] != Integer.MAX_VALUE && 
					dist[n]+graph[n][i]<dist[i] && splset[i]==false)
			{
			dist[i]=dist[n]+graph[n][i];
			previous[i]=n;
			}
		}
		}
		print(dist,nodes,previous);
	}
	
	static void print(int []dist,int nodes,int[] previous)
	{
		for(int i=0;i<nodes;i++)
		{
		System.out.println("NODE:"+i+"Value"+dist[i]);
		System.out.println("Path");
		printpath(previous,i);
		
		}
	}
	
	static void printpath(int[]previous,int i)
	{
		System.out.println(i);
		while(previous[i]!=Integer.MAX_VALUE)
		{
			System.out.println(previous[i]);
			i=previous[i];
    	}
	}
	static int findmin(boolean[] splset,int[] dist)
	{
		int min=Integer.MAX_VALUE;
		int index=0;
		for(int x=0;x<dist.length;x++)
		{
			if(dist[x]<min && splset[x]==false)
			{
				min=dist[x];
				index=x;
			}
		}
		return index;
	}


}
