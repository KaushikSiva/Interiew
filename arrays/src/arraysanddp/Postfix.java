package arraysanddp;

import java.util.Stack;

public class Postfix
{public static int priority(char ch)
{if(ch=='^')
    return 3;
 if(ch=='/'||ch=='*')
    return 2;
 if(ch=='+'||ch=='-')
    return 1;
 return 0;
}
public static String toPostfix(String in)
{String copy=in+")";
 Stack s=new Stack();
 s.push('(');
 int i,l=copy.length();
 char ch;
 String r="";
 for(i=0;i<l;i++)
    {ch=copy.charAt(i);
     if(Character.isLetter(ch)==true)
        r+=ch;
     else if(ch=='(')
        s.push(ch);
     else if(ch==')')
        {while((char)s.peek()!='(')
            r+=s.peek();
         s.pop();
        }
     else
        {while(priority(ch)<=priority((char)s.peek()))
            r+=s.peek();
         s.push(ch);
        }
    }
 return r;
}
public static void main(String args[])
{
	String r=toPostfix("(3 + 4) * 2");
	System.out.println(r);
}
}