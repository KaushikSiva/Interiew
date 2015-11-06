package arraysanddp;


import java.util.ArrayList;
import java.util.Arrays;
//Q51

public class Skyline {
	
	/*
	 * The solution uses the divide and conquer strategy -> time complexity: O(nlogn)
	 * Divide - split the problem into subproblems 
	 * Conquer - solve the subproblems 
	 * Merge - merge the subsolutions.
	 * 
	 * Space complexity O(n)
	 */
	public static ArrayList<Point> findSkyline(Building[] buildings,int l,int h){
		if(l==h){
			ArrayList<Point> sl = new ArrayList<Point>();
			sl.add(new Point(buildings[l].left, buildings[l].height));
			sl.add(new Point(buildings[l].right, 0));
			return sl;
		}
		int mid = (l +h)/2;
		ArrayList<Point> sl1 = findSkyline(buildings, l,mid);
		ArrayList<Point> sl2 = findSkyline(buildings, mid+1, h);
		return merge(sl1, sl2);
		
		
	}
	
	public static ArrayList<Point> merge(ArrayList<Point> sl1, ArrayList<Point> sl2){
		ArrayList<Point> skyline = new ArrayList<Point>();
		int i=0,j=0;
		int curH1=0, curH2=0, curX=0,curX2;
		while(i<sl1.size()&& j<sl2.size()){
			if(sl1.get(i).x < sl2.get(j).x){
				curX = sl1.get(i).x;
				curH1 = sl1.get(i).y;
				skyline.add(new Point(curX, Math.max(curH1, curH2)));
				i++;
			}else{
				curX2 = sl2.get(j).x;
				curH2 = sl2.get(j).y;
				skyline.add(new Point(curX2, Math.max(curH1, curH2)));
				j++;
			}
		}
		while(i<sl1.size())
		{
			skyline.add(sl1.get(i));
		    i++;
		}
	   while(j<sl2.size())
	   {
		 skyline.add(sl2.get(j));
	     j++;
	   }
		return skyline;
		
		
	}
	
	public static void main(String args[])
	{
		Building b1 = new Building(1,5,11);
		Building b2 = new Building(2,7,6);
		Building b3 = new Building(3,9,13);
		Building b4 = new Building(12,16,7);
		Building b5 = new Building(14,25,3);
		Building b6 = new Building(19,22,18);
		Building b7 = new Building(23,29,13);
		Building b8 = new Building(24,28,4);
		Building[] barr ={b1,b2,b3,b4,b5,b6,b7,b8};
		ArrayList<Point> points =findSkyline(barr,0,barr.length-1);
		Point prev = null;
		for(Point point:points)
		{
			if(prev ==null || prev.y!=point.y)
			{
			System.out.println("x:"+point.x);
			System.out.println("y:"+point.y);
			System.out.println("===========");
			}
			prev =point;
		}
		
	}

	public static class Building{
		int left, right, height;

		public Building(int left, int right, int height) {
			this.left = left;
			this.right = right;
			this.height = height;
		}
		
		
	}
	
	public static class Point{
		public int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}