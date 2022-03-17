import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
class Student{
    char gender,group;
    Boolean test_prep;
    int math, reading, writing;
    Student(){}
    Student(char gender, char group, Boolean test_prep, int ms, int rs, int ws){
        this.gender=gender;
        this.group=group;
        this.test_prep=test_prep;
        math=ms;
        reading=rs;
        writing=ws;
    }
    
    void setGender(char g){gender=g;}
    void setGroup(char gp) {group=gp;}
    void setPrep(Boolean prep) {test_prep=prep;}
    void setMathScore(int ms) {math=ms;}
    void setReadingScore(int rs) {reading=rs;}
    void setWritingScore(int ws) {writing=ws;}
    char getGender() {return gender;}
    char getGroup() {return group;}
    Boolean getPrep() {return test_prep;}
    int getMathScore() {return math;}
    int getReadingScore() {return reading;}
    int getWritingScore() {return writing;}
    @Override
    public String toString(){
        return "\nGender: " + gender+"\nGroup: " + group+"\nPrep: " + test_prep+"\nMath Score: " + math+"\nReading Score: " + reading+"\nWriting Score: "+ writing;
        
    }
    
}	 	  	 		     		    	   	 	     	 	
class lab4{
    public static void main(String args[]){
        List<Student> students= new ArrayList<>();
        int[] size= new int[5];
        Double[][] marks= new Double[5][3];
        Double[][] prep_maths_marks=new Double[5][2];
        int[] prep_size=new int[5];
        for(Double[] row:marks)
            Arrays.fill(row,0.0);
        for(Double[] row:prep_maths_marks)
            Arrays.fill(row,0.0);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://raw.githubusercontent.com/anthoniraj/datasets/main/StudentsPerformance.csv").openStream())))
        {   
            
            br.readLine();
            while(true){
                String line = br.readLine();
                if(line==null)
                    break;
                String[] parts = line.split(",");
                char gender=parts[0].charAt(0);
                char group=parts[1].charAt(6);
                Boolean prep= parts[2].equals("none")?false:true;
                int math_score=Integer.parseInt(parts[3]);
                int reading_score=Integer.parseInt(parts[4]);
                int writing_score =Integer.parseInt(parts[5]);
                Student s=new Student(gender,group,prep,math_score,reading_score,writing_score);
                // System.out.println(s.toString());
                students.add(s);
                for(Student stud: students){
                    // System.out.println(stud.toString());
                    int grpNum=stud.getGroup()-'A';
                    size[grpNum]+=1;
                    marks[grpNum][0]+=stud.getMathScore();
                    marks[grpNum][1]+=stud.getReadingScore();
                    marks[grpNum][2]+=stud.getWritingScore();
                    prep_maths_marks[grpNum][stud.getPrep()==true?0:1]+=stud.getMathScore();
                    if(stud.getPrep())
                        prep_size[grpNum]+=1;
                }	 	  	 		     		    	   	 	     	 	
                
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error!");
        }
        String[] subject={"Maths","Reading","Writing"};
        for(int i=0;i<5;i++){
            System.out.println("\n");
            int sum=0;
            for(int j=0;j<3;j++){
                System.out.println("Average of group "+(char)('A'+i)+" in "+subject[j]+" is: "+marks[i][j]/size[i]);
            }
            
        }
        System.out.println("\n");
        for(int i=0;i<5;i++){
            System.out.println("Average of group "+(char)('A'+i)+" who prepared in maths is: "+prep_maths_marks[i][0]/prep_size[i]);
            System.out.println("Average of group "+(char)('A'+i)+" who didnt prepare in maths is: "+(prep_maths_marks[i][1]/(size[i]-prep_size[i])));
        }
    }
}