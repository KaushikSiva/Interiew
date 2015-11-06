package arraysanddp;

import java.util.Stack;
//Q26
public class AreaofHistogram {

	static int getMaxArea(int hist[], int n) {
		Stack<Integer> stack = new Stack<Integer>();
		int tp;
		int area_with_top;// top is smallest stack
		int i = 0;
		int max_area = 0;
		while (i < n) {
			if (stack.isEmpty() || hist[stack.peek()] < hist[i]) {
				stack.push(i++);
				System.out.println("pushing "+i);
			} else {
				tp = stack.pop();
				area_with_top = hist[tp]
						* (stack.isEmpty() ? i : i - stack.peek() - 1);
				if (area_with_top > max_area) {
					max_area = area_with_top;
				}

			}
		}

		while (!stack.isEmpty()) {
			tp = stack.pop();
			area_with_top = hist[tp]
					* (stack.isEmpty() ? i : i - stack.peek() - 1);
			if (area_with_top > max_area) {
				max_area = area_with_top;
			}
		}
		return max_area;
	}

	public static void main(String[] args) {
int hist[] ={6,2,5,4,5,1,6};
int n=hist.length;
System.out.println("sssssss");
System.out.println(getMaxArea(hist,n));
System.out.println("ff");
	}

}
