import java.util.Scanner;
import java.lang.Exception;
/**
 * @author : Adeel Abdul Sakkeer
 * @version : 1.0
 * @description : Program to print IN pattern with differenct characters
 */
class printingPattern{
    public static void main(String[] args) throws Exception{
        Scanner input= new Scanner(System.in);
        int rows = input.nextInt();
        
        if(rows<3){
            /*This block checks if the row value is less than 3
            Incase it is, it will throw an exception*/
            throw new Exception("Row should be greater than 3");
        }
        // Printing with *
        System.out.println();
        char op='*';
        for(int i=0;i<rows;i++){
            System.out.print(op+" "+op);
            for(int j=0;j<i-1;j++)
                System.out.print(" ");
            if(i!=0){
                System.out.print(op);
            }
            for(int j=0;j<rows-i-2;j++)
                System.out.print(" ");
            if(i!=(rows-1))
                System.out.print(op);
            System.out.println();
        }
        
        // Printing with Indian flag emoji
        System.out.println();
        String india="\uD83C\uDDEE\uD83C\uDDF3";
        for(int i=0;i<rows;i++){	 	  	 		     		    	   	 	     	 	
            System.out.print(india+" "+india);
            for(int j=0;j<i-1;j++)
                System.out.print(" ");
            if(i!=0)
                System.out.print(india);
            for(int j=0;j<rows-i-2;j++)
                System.out.print(" ");
            if(i!=(rows-1))
                System.out.print(india);
            System.out.println();
        }
        
    }
}