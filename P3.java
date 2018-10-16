import java.util.Scanner;

public class P3 {
   public static Boolean isDouble(String mark){
       try {
           Double.parseDouble(mark);
       } catch(NumberFormatException e) {
           System.out.println("Invalid Operand");
           return false;
       } catch(NullPointerException e) {
           System.out.println("Invalid Operand");
           return false;
       }
       return true;
   }
   public static String evaluate(String expression) {
	   
       System.out.print(expression);

       
       double operand1=0,operand2 = 0,result=0;
       char operator;
       Boolean check=Boolean.FALSE;//for if operators were not listed
       String returnString = "";
       String mark[]=new String[expression.length()];//for storing all token from expression

       
       int i=0;
       Scanner scanner = new Scanner(expression);
       while(scanner.hasNext()){
           mark[i]=scanner.next();
           i++;
       }
       scanner.close();

       
       if(isDouble(mark[0])){
           operand1=Double.parseDouble(mark[0]);
       }
       if(isDouble(mark[2])){
           operand2=Double.parseDouble(mark[2]);
       }
       operator=mark[1].charAt(0);
       if(operand1!=0&&operand2!=0){
           switch(operator){
           case '+':
               result=operand1+operand2;
               break;
           case '-':
               result=operand1-operand2;
               break;
           case '*':
               result=operand1*operand2;
               break;
           case '/':
               result=operand1/operand2;
               break;
           case '%':
               result=operand1%operand2;
               break;
           case '^':
               result=Math.pow(operand1, operand2);
               break;
           default:
               System.out.println("Invalid Operator");
               check=Boolean.TRUE;
               break;
           }

           
           returnString=Double.toString(result);
          
           if(check){
               return null;
           }
           
           return returnString;
       }else{
           return null;
       }
   }
}