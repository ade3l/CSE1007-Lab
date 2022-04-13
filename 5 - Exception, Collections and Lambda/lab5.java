import java.util.*;
import java.io.*;

class Student{
    int roll;
    int a1, a2, a3, a4, a5, a6;
    Student(int r, int a, int b, int c, int d, int e, int f) throws InvalidMarksException{
        if(a>30 || b>30 || c>30 || d>30 || e>30 || f>30 || a<0 || b<0 || c<0 || d<0 || e<0 || f<0){
            throw new InvalidMarksException("Marks should be between 0 and 30");
        }
        roll = r;
        a1 = a;
        a2 = b;
        a3 = c;
        a4 = d;
        a5 = e; 
        a6 = f;
    }
    public int getA1(){return a1;}
    public int getA2(){return a2;}
    public int getA3(){return a3;}
    public int getA4(){return a4;}
    public int getA5(){return a5;}
    public int getA6(){return a6;}
    public int getRoll(){return roll;}
    
    public void setA1(int x){a1=x;}
    public void setA2(int x){a2=x;}
    public void setA3(int x){a3=x;}
    public void setA4(int x){a4=x;}
    public void setA5(int x){a5=x;}
    public void setA6(int x){a6=x;}
    
    @Override
    public String toString(){
        return "Roll Number: " + roll + 
        "\nA1: " + a1 + 
        "\tA2: " + a2 + 
        "\nA3: " + a3 + 
        "\tA4: " + a4 + 
        "\nA5: " + a5 + 
        "\tA6: " + a6 ; 
    }	 	  	 		     		    	   	 	     	 	
    
}

class InvalidMarksException extends Exception{
    InvalidMarksException(String message){
        super(message);
    }
}
public class lab5{
    public static void main (String[] args) {
        List<Student> students  = new ArrayList<>();
        try{
            students.add(new Student(10001,16,18,18,17,16,16));
            students.add(new Student(10002,20,20,19,19,19,17));
            students.add(new Student(10003,20,17,18,19,20,20));
            students.add(new Student(10004,13,19,11,13,16,19));
            students.add(new Student(10005,11,18,9,0,16,16));
            students.add(new Student(10006,17,20,19,13,18,16));
            students.add(new Student(10007,15,20,17,13,14,17));
            // System.out.println("Students List:");
            
            List<Student> grtrThan15 = students.stream()
                .filter(e-> (e.getA1() > 15 ))
                .filter(e-> (e.getA2() > 15 ))
                .filter(e-> (e.getA3() > 15 ))
                .filter(e-> (e.getA4() > 15 ))
                .filter(e-> (e.getA5() > 15 ))
                .filter(e-> (e.getA6() > 15 ))
                .toList();
                
            System.out.println("roll nums of students with marks greater than 15 in all subjects:");
            
            for(Student s : grtrThan15){
                System.out.println(s.getRoll());
            }
            DoubleSummaryStatistics stats = students.stream().mapToDouble(e->e.getA2()).summaryStatistics();
            System.out.printf("\n\nAverage of second assessment = %.2f", stats.getAverage());
            
            System.out.println("\n\nStudent marks in 100:");
            students.forEach(f->{	 	  	 		     		    	   	 	     	 	
                f.setA1(f.getA1()*5);
                f.setA2(f.getA2()*5);
                f.setA3(f.getA3()*5);
                f.setA4(f.getA4()*5);
                f.setA5(f.getA5()*5);
                f.setA6(f.getA6()*5);
            });
            for(Student s : students){System.out.println(s.toString()+"\n\n");}
        }
        catch(InvalidMarksException e){
            System.out.println("Error!!! " + e.getMessage());
        }
    }
}