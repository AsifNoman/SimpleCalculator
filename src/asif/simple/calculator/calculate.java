package asif.simple.calculator;

import java.util.*;
import java.math.*;

public class calculate{
	
	private double result;
	private String error = "";
	
	public double Calculation(String operation)
    {
       char[] InputOperation = operation.toCharArray(); 
       Stack<Double> number = new Stack<Double>();
       Stack<Character> operator = new Stack<Character>();
       
       try
       {   
    	   for (int i = 0; i < InputOperation.length; i++)
           {
               if (InputOperation[i] == ' ')
                            continue;
               
               if (InputOperation[i] >= '0' && InputOperation[i] <= '9' || InputOperation[i] == '.')
               {
                     StringBuffer MoreInput = new StringBuffer();
                          
                     while(i < InputOperation.length && (InputOperation[i] >= '0' && InputOperation[i] <= '9' || InputOperation[i]=='.'))
                     {
                        		MoreInput.append(InputOperation[i++]);
                     }
                               number.push(Double.parseDouble(MoreInput.toString()));
                     
                   }
               	
                   else if (InputOperation[i] == '(')
                   {
                   	 operator.push(InputOperation[i]);
                   }
           
                   else if (InputOperation[i] == ')')
                   {
                       while (operator.peek() != '(')
                       {
                       	 number.push(permittedOperator(operator.pop(), number.pop(), number.pop()));
                       }
                            operator.pop();
                   }
        
                 
                   else if (InputOperation[i] == '+' || InputOperation[i] == '-' || InputOperation[i] == '*' || InputOperation[i] == '/' || InputOperation[i] == '^' || InputOperation[i] == '%')
                   {
                       while (!operator.empty() && OperatorRank(InputOperation[i], operator.peek()))
                       {
                       	number.push(permittedOperator(operator.pop(), number.pop(), number.pop()));
                       }
                           operator.push(InputOperation[i]);
                   }
               }
    
           while (!operator.empty())
           {
           	 number.push(permittedOperator(operator.pop(), number.pop(), number.pop()));
           }
    
           result=number.pop();
         
       }
       catch(Exception e)
       {
    	   error = "Error In Calculation";
       }

        return result;
    }
  
    public boolean OperatorRank(char operator, char TopOperator)
    {	
    	if (TopOperator == '(' || TopOperator == ')')
            return false;
    	
    	if (( operator == '*' ||  operator == '/') && (TopOperator == '+' || TopOperator == '-'))
            return false;
    	
    	if (( operator == '%') && (TopOperator == '/' || TopOperator == '*'))
            return false;
    	
    	if (( operator == '%') && (TopOperator == '+' || TopOperator == '-'))
            return false;
        
        if (( operator == '^') && (TopOperator == '/' || TopOperator=='*'))
            return false;
        
        if (( operator == '^') && (TopOperator == '+' || TopOperator=='-'))
            return false;
        
        else
            return true;
    	
    }
     
    public double permittedOperator(char operator, double input2, double input1)
    {
    	double sum;
    	
    	try
    	{
    		if(operator=='+')
        	{
        		return sum=input1 + input2;
        	}
        	else if(operator=='-')
        	{
        		return sum=input1 - input2;
        	}
        	else if(operator=='*')
        	{
        		return sum=input1 * input2;
        	}
        	else if(operator=='/')
        	{	
        		return sum=input1/input2;
        	}
        	else if(operator=='^')
        	{	
        		return sum=Math.pow(input1, input2);
        	}
        	else if(operator=='%')
        	{	
        		return sum=(input1*input2)/100;
        	}
    	}
    	catch(Exception e)
    	{
    		error = "Error";
    	}
    	
        return 0;
   }
    
    public double getResult()
	{
		return result;
	}
    
    public String getError()
	{
		return error;
	}
    
}
