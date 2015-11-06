package Balanced;
import java.util.Stack;
//Q57
public class balance {
	
	
	public static void  balanced(String[] expr)
	{
		
		for(String string:expr)
		{
			if(isBalanced(string))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	//define method header
		//left and right remains are keeping track of how many remaining parenthesis left for printing
		//currentString is used to keep track of the current printout for each recursive call
		public static void PrintParenthesis(int leftRemain, int rightRemain, String currentString)
		{
			//firstly check if there is need to go further
			if(rightRemain==0)//all printed out
			{	
				System.out.println(currentString);
				return;
			}
			//now coming to the recursive part
			if(leftRemain>0)//more left parenthesis left for printing
			{
				//choice 1, print another left parenthesis
				PrintParenthesis(leftRemain-1, rightRemain, currentString+"(");
				//choice 2, print right parenthesis if valid
				if(leftRemain < rightRemain)//which means more left parenthesis have been used 
					PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
			}
			else//now there are only right parenthesis left
				PrintParenthesis(leftRemain, rightRemain-1, currentString+")");
		}
	
	    public static boolean isBalanced(String in)
	    {
	        Stack<Character> st = new Stack<Character>();

	        for(char chr : in.toCharArray())
	        {
	            switch(chr) {

	                case '{':
	                	st.push(chr);
	                    break;
	                case '(':
	                	st.push(chr);
	                    break;
	                case '[':
	                    st.push(chr);
	                    break;

	                case ']':
	                    if(st.isEmpty() || st.pop() != '[') 
	                        return false;
	                    break;
	                case ')':
	                    if(st.isEmpty() || st.pop() != '(')
	                        return false;
	                    break;
	                case '}':
	                    if(st.isEmpty() || st.pop() != '{')
	                        return false;
	                    break;
	            }
	        }
	        return st.isEmpty();
	    }
	    public static void main(String args[]) {
	    	String[] expr = new String[3];
	        expr[0]="({[]})";
	        expr[1]="{{}}";
	        expr[2]="[{]}()";
	        balanced(expr);
	        PrintParenthesis(3,3,"");//try 5 groups
	    }
}
