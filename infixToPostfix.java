
import java.util.Scanner;
import java.util.Stack;


public class infixToPostfix
{

    public static int Operator(char ch)
    {
   	 switch(ch)
   	 {
   	 case '+':
   	 case '-':
   		 return 1;
   	 case '*':
   	 case '/':
   		 return 2;
   	 case '^':
   		 return 3;
   	 }
   	 return -1;
   	 }

   	 static String postfix(String equ)
   	 {
   		 String result = new String("");
   		 Stack<Character> stack = new Stack<>();
   		 
   		 for (int i = 0; i<equ.length(); ++i)
   		 {
   			 char c = equ.charAt(i);
   			 if (Character.isLetterOrDigit(c))
   				 result += c;
   			 else if (stack.isEmpty()){
   				 stack.push(c);
   			 }
   			 else if (c == '(')
   				 stack.push(c);
   			 else if (c == ')')
   			 {
   				 while (!stack.isEmpty() &&
   						 stack.peek() != '(')
   					 result += stack.pop();
   				 
   					 stack.pop();
   			 }
   			 else
   			 {
   				 while (!stack.isEmpty() && Operator(c)
   						 <= Operator(stack.peek())){
   				 
   					 result += stack.pop();
   			 }
   				 stack.push(c);
   			 }
   	 
   		 }
   		 while (!stack.isEmpty()){
   			 if(stack.peek() == '(')
   				 return "Invalid Expression";
   			 result += stack.pop();
   		 }
   		 return result;
   	 }
   
	 public static void main(String[] args)
   	 {
   		 Scanner sc= new Scanner(System.in);
   		 System.out.println("Enter the equation to convert it to postfix notations");
   		 String equ=sc.nextLine();
   		 System.out.println("Post fix equation is");
   		 System.out.println(postfix(equ));
   		 sc.close();
   	 }
    }
