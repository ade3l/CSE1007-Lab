import java.util.*;
class Member{
    String name, id, department;
    Member(String name, String id, String department){
        this.name=name;
        this.id=id;
        this.department=department;
    }
    String getName(){return name;}
    String getId(){return id;}
    String getDept(){return department;}
}
class Faculty extends Member{
    Faculty(String name, String facultyId, String department){
        super(name,facultyId,department);
    }
}

class Student extends Member{
    int currCredits=0, totalCredits;
    Map<Course,Faculty> registered= new HashMap<>();
    
    // boolean initialised=false;
    Student(String name, String studentId, String department,int totalCredits){
        super(name, studentId, department);
        this.totalCredits=totalCredits;
    }
    
    List<Faculty> facs = new ArrayList<>(){{
            add(new Faculty("SMART","19502","Scope"));
            add(new Faculty("ETHNUS","19502","Scope"));
            add(new Faculty("FACE","19502","Scope"));
    }};
    List<Course> mandatory=new ArrayList<>(){{
        add(new Course("STS2201","Numerical Ability",facs,1,"SENSE"));
    }};
    
    boolean register(Course course, Faculty fac){	 	  	 		     		    	   	 	     	 	
        registered.put(course,fac);
        currCredits+=course.getCredits();
        return true;
    }
    void printDetails(){
        System.out.printf("Name: %s\n",getName());
        System.out.printf("Roll number: %s\n",getId());
        System.out.printf("Registered credits: %d\n",getCredits());
        // System.out.printf("Registered credits: %d\n", credits);
    }
    int getCredits(){return currCredits;}
    boolean isRegistered(Course course){
        return registered.keySet().contains(course);
    }
    
    boolean mandatoryRegistered(){
        for(Course c:mandatory){
            if(!registered.keySet().contains(c))
                return false;
        }
        return true;
    }
    List<Course> getMandatory(){
        return mandatory;
    }
    
    // void viewRegistered(){
    //     int index=1;
    //     for(Map.Entry<Course,Faculty> entry: Map.entrySet()){
    //         Course c=entry.getKey();
    //         Faculty f= entry.getValue();
    //         System.out.printf("%d. %s - %s : %s",index,c.getCode(),c.getName(),f.getName());
    //     }
    // }
}

class Course{
    String code, name, schoolName;
    List<Faculty> faculties = new ArrayList<>();
    int credits;
    Course(String code, String name,List faculties, int credits,String schoolName){
        this.code=code;
        this.name=name;
        this.faculties=faculties;
        this.credits=credits;
        this.schoolName=schoolName;
    }
    void printDetails(){
        System.out.println("Course Id: "+code);
        System.out.println("Course Name: "+name);
        System.out.printf("Credits: %d\n",credits);
        int index=1;
        for(Faculty fac:faculties){
            System.out.printf("\n%d. %s-%s",index++,fac.getId(),fac.getName());
        }
    }
    String getName(){return name;}
    String getCode(){return code;}
    int getCredits(){return credits;}
    Faculty getFac(int n){return faculties.get(n);}
}

class registration{
    
    
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        List<Faculty> facs = new ArrayList<>(){{
            add(new Faculty("Anthoniraj Amalanathan","19502","Scope"));
            add(new Faculty("Govinda K","19502","Scope"));
            add(new Faculty("Swathi JN","19502","Scope"));
        }};
        List<Course> listCourses = new ArrayList<>(){{	 	  	 		     		    	   	 	     	 	
            add(new Course("CSE1007","Programming in Java",facs,4,"SCOPE"));
            add(new Course("CSE1004","Network and Communication",facs,4,"SCOPE"));
        }};
        
        boolean choice=true;
        int num=0;
        Student student= new Student("Adeel","20BCE0910","SCOPE",80);
        List<Course> courses= new ArrayList<>();
        while(choice){
            courses=listCourses;
            clearScreen();
            if(!student.mandatoryRegistered()){
                courses=student.getMandatory();
            }
            int inputNum=mainPage();
            if(inputNum==2)
                registrationPage(courses,student);
            
        }
    }
    public static int mainPage(){
        System.out.println("1. View registered courses");
        System.out.println("2. Register for courses");
        System.out.println("3. Delete registered courses");
        int inputNum=-1;
        Scanner input=new Scanner(System.in);
        
        while(inputNum<=3 && inputNum>=1){
            System.out.println("Enter a valid option from the list");
            inputNum=input.nextInt();
        }
        return inputNum;
        
    }
    public static void registrationPage(List<Course> courses, Student student){
        clearScreen();
        Scanner input=new Scanner(System.in);
        student.printDetails();
        int index=1;
        for(Course course: courses){
            System.out.printf("\n%d. %s - %s",index++,course.getCode(),course.getName());
        }
        System.out.println("\nEnter course number to register");
        int num=input.nextInt();
        clearScreen();
        Course selected=courses.get(num-1);
        if(student.isRegistered(selected)){
            clearScreen();
            System.out.println("Course has already been registered");
            wait(3000);
        }
        else{
            selected.printDetails();
            System.out.println("\nEnter faculty numeber: ");
            num=input.nextInt();
            if(student.register(selected,selected.getFac(num-1))){
                clearScreen();
                System.out.println("Course registered successfully");
                wait(3000);
            }
        }
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    
    public static void wait(int ms)
        {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}