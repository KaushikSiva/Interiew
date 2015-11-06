package Validate;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Stack;
import java.io.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
	public class ValidateStrings {
		    Stack<String> stack;
		    static ArrayList<String> operators;

		    String postFix;

		    int[] operand = {-1, -1, 1};
		    int[] plusorminus = {1,2,-1};
		    int[] timesordivide = {3,4,-1};
		    int[] raiseto = {6,5,-1};
		    int[] openparenthesis = {-1,0,-1};

		    public ValidateStrings(String infix) {

		        stack = new Stack<String>();
		        operators = new ArrayList<String>();

		        operators.add("+");
		        operators.add("-");
		        operators.add("*");
		        operators.add("/");
		        operators.add("^");
		        operators.add("(");
		        operators.add(")");

		        postFix = new String();

		        while(infix.length() > 0){

		            String operand = new String();
		            String operator = new String();

		            if(!operators.contains(infix.substring(0, 1))){
		                while(!infix.isEmpty() && !operators.contains(infix.substring(0, 1))){
		                    operand = infix.substring(0,1);
		                    infix = infix.substring(1);
		                }
		                postFix = postFix + operand;
		            }
		            else if(operators.get(5).equals(infix.substring(0, 1))){
		                stack.push(infix.substring(0, 1));
		                infix = infix.substring(1);
		            }
		            else if(operators.get(6).equals(infix.substring(0, 1))){
		                while(!stack.peek().equals("(")){
		                    postFix = postFix + stack.pop();
		                }
		                stack.pop();
		                infix = infix.substring(1);
		            }
		            else{
		                operator = infix.substring(0,1);

		                int[] current = getICPandISP(operator);

		                if(!stack.isEmpty()){
		                    int[] top = getICPandISP(stack.peek());
		                    while(current[0] < top[1] && !stack.isEmpty()){
		                        postFix = postFix + stack.pop();
		                        if(!stack.isEmpty())
		                            top = getICPandISP(stack.peek());
		                    }
		                }
		                stack.push(operator);
		                infix = infix.substring(1);
		            }
		        }
		        postFix = postFix + infix;

		        while(!stack.isEmpty()){
		            postFix = postFix + stack.pop();
		        }
		    }

		    public String toString(){
		        return postFix;
		    }

		    private int[] getICPandISP(String operator){
		        if(operator.equals("+") || operator.equals("-")){
		            return plusorminus;
		        }
		        else if(operator.equals("*") || operator.equals("/")){
		            return timesordivide;
		        }
		        else if(operator.equals("^")){
		            return raiseto;
		        }
		        else{
		            return openparenthesis;
		        }
		    }

		    public static void main(String[] args){
		    	ValidateStrings convert = new ValidateStrings("2*7-6+8");
		    	System.out.println(convert);
		    	try {
					removeExtra(convert.toString());
				} catch (ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		    }
		    public static void removeExtra(String postfix) throws ScriptException
		    {
		    	ScriptEngineManager mgr = new ScriptEngineManager();
		        ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    	operators = new ArrayList<String>();

		        operators.add("+");
		        operators.add("-");
		        operators.add("*");
		        operators.add("/");
		        operators.add("^");
		        operators.add("(");
		        operators.add(")");
		    	Stack <String> stch=new Stack<String>();
 		    	Queue <Character> chq=new LinkedList<Character>();
		    	char[] ch =postfix.toCharArray();
		    	for(char j:ch)
		    	{
		    		if(operators.contains(""+j))
		    		{
		    			chq.add(j);
		    		}
		    	}
		    	//System.out.println(chq);
		    	for(char i:ch)
		    	{
		    		if(!operators.contains(""+i))
		    		{
		    			//System.out.println(chq);
		    			stch.push(""+i);
		    			
		    		}
		    		else
		    		{
		    			char q=chq.peek();
		    			System.out.println(q);
		    			chq.remove(chq.peek());
		    			if(pre(i)>pre(q))
		    			{
		    				String h=stch.pop();
		    				stch.push(stch.pop()+q+h);
		    				
		    			}
		    			else
		    			{
		    				String h=stch.pop();
		    				stch.push("("+stch.pop()+q+h+")");
		    				System.out.println(stch);
		    			}
		    			
		    		}
		    	}
		    	System.out.println(stch);
		    	System.out.println(engine.eval(stch.peek().toString()));
		    	
		    }
		    static int pre(char ch)
		    {
		        switch(ch)
		        {
		            case '-':return 1;
		            case '+':return 1;
		            case '*':return 2;
		            case '/':return 2;
		        }
		        return 0;
		    }

		}