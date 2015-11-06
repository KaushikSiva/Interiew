import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
//Q80
public class MST {

	static ArrayList<Edge> edges = new ArrayList<Edge>();
	static ArrayList<VertextNode> nodes = new ArrayList<VertextNode>();
	static ArrayList<HashSet<VertextNode>> subsets = new ArrayList<HashSet<VertextNode>>();

	public static void main(String args[]) {

		double total = 0.0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double[][] matrix = new double[n][n];

		for (int i = 0; i < n; i++) {
			nodes.add(new VertextNode(i));
		}
		int t = scan.nextInt();

		while (count < t) {
			edges.add(new Edge(scan.nextInt(), scan.nextInt(), scan
					.nextDouble()));
			count++;
		}

		// make nodes to subsets
		for (int i = 0; i < nodes.size(); i++) {
			HashSet<VertextNode> set = new HashSet<VertextNode>();
			set.add(nodes.get(i));
			subsets.add(set);
		}

		// sort
		Collections.sort(edges, new CustomComparator());

		// union and find algorithm
		for (int i = 0; i < edges.size(); i++) {
			Edge edg = edges.get(i);
			VertextNode srcNode = nodes.get(edg.src);
			VertextNode destNode = nodes.get(edg.dest);

			if (find(srcNode) != find(destNode)) {
				total += edg.weight;
				System.out.println(edg.src + " " + edg.dest + " " + edg.weight);
				union(find(srcNode), find(destNode));
			}
		}
		System.out.println(total);
	}

	public static void union(int suba, int subb) {
		HashSet<VertextNode> aSet = subsets.get(suba);
		HashSet<VertextNode> bSet = subsets.get(subb);

		Iterator<VertextNode> iter = bSet.iterator();
		while (iter.hasNext()) {
			VertextNode b = iter.next();
			aSet.add(b);
		}
		subsets.remove(subb);
	}
	public static int find(VertextNode node) {
		int number = -1;

		for (int i = 0; i < subsets.size(); i++) {
			HashSet<VertextNode> set = subsets.get(i);
			Iterator<VertextNode> iterator = set.iterator();
			while (iterator.hasNext()) {
				VertextNode setnode = iterator.next();
				if (setnode.number == node.number) {
					number = i;
					return number;
				}

			}
		}
		return number;
	}
}

class CustomComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		if (o1.weight == o2.weight)
			return 0;
		return o1.weight - o2.weight < 0.0 ? -1 : +1;
	}
}

class VertextNode {

	LinkedList<VertextNode> subnodes = new LinkedList<VertextNode>();
	VertextNode parendNode = null;
	boolean isRoot = true;
	int number = 0;
	VertextNode(int number) {
		this.number = number;
	}
}

class Edge {
	int src;
	int dest;
	double weight;

	Edge(int src, int dest, double weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}