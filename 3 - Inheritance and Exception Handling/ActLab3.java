import java.lang.Exception;
import java.util.*;
class divByZeroExc extends Exception{
    public divByZeroExc(){
        super("Division by zero");
    }
}
class invalidExpression extends Exception{
    public invalidExpression(){
        super("Entered string is not a valid mathematical expression\n\n");
    }
}
class invalidNumException extends Exception{
    public invalidNumException(String num){
        super("Entered string "+num+" is not a number");
    }
}
class invalidOperatorExc extends Exception{
    public invalidOperatorExc(){}
}
interface CalculatorFunctions{
    public  double add(double x,double y);
    public  double subtract(double x,double y);
    public  double divide(double x, double y) throws divByZeroExc;
    public  double multiply(double x, double y);
    public  double power(double x, double y);
    public  double percentage(double x, double y);
}

abstract class BasicCalculator implements CalculatorFunctions {
    @Override 
    public double add(double x, double y)  {return x+y; }
    
    @Override public double subtract(double x, double y)  {return x-y;}
    
    @Override
    public double divide(double x, double y) throws divByZeroExc{	 	  	 		     		    	   	 	     	 	
        if(y==0)
            throw new divByZeroExc();
        else
            return x/y;
    }
    
    @Override 
    public double multiply(double x, double y) { return x*y; }
}

class ScientificCalculator extends BasicCalculator{
    @Override
    public double power(double x, double y){
        return Math.pow(x,y);
    }
    @Override
    public double percentage(double x, double y){
        return (x/100)*y;
    }

}

class ActLab3{
    public static void main(String args[]) throws invalidExpression{
        Scanner input= new Scanner(System.in);
        ScientificCalculator calculator=new ScientificCalculator();
        Double a,b;
        while(true){
            System.out.println("\nEnter a calculation to do with each part seperated by a space E.g: 7 / 3\nEnter 0 to quit");
            String x= input.nextLine();
            if(x.equals("0"))
                return;
            String[] parts= x.split(" ");
            try{
                if(parts.length!=3)
                    throw new invalidExpression();
                if(!parts[0].matches("-?\\d+(\\.\\d+)?")){	 	  	 		     		    	   	 	     	 	
                    throw new invalidNumException(parts[0]);
                }
                if(!parts[2].matches("-?\\d+(\\.\\d+)?")){
                    throw new invalidNumException(parts[2]);
                }
                a=Double.parseDouble(parts[0]);
                b=Double.parseDouble(parts[2]);
                switch(parts[1]){
                    case "+":
                        System.out.println(calculator.add(a,b));
                        break;
                    case "-":
                       System.out.println(calculator.subtract(a,b));
                        break; 
                    case "/":
                       System.out.println(calculator.divide(a,b));
                       break;
                    case "*":
                        System.out.println(calculator.multiply(a,b));
                        break;
                    case "^":
                        System.out.println(calculator.power(a,b));
                        break;
                    case "%":
                        System.out.println(calculator.percentage(a,b));
                        break;
                    default:
                        throw new invalidOperatorExc();
                        
                }
            }
            catch(invalidExpression e ){
                System.out.println("Invalid expression\n\n");
                continue;
            }
            catch(invalidNumException e){	 	  	 		     		    	   	 	     	 	
                e.printStackTrace();
                System.out.println("\n\n");
                continue;
            }
            catch(divByZeroExc e){
                System.out.println("Division by zero\n\n");
                
            }
            catch(invalidOperatorExc e){
                System.out.println("Invalid operator\n\n");
            }
        }
    }
}