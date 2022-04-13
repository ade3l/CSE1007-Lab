## Activity 5 - Exception, Collections, and Lambda 

You are expected to develop the code using the following concepts in Java  
-   Exception Handling  
-   Collections (List and ArrayList)
-   Streams and Lambda expressions  
    

**Description**

Consider the set of students internal marks given below for 5 LAB assessments (Max of 20)

    ROLLNO,A1,A2,A3,A4,A5,A6  
    10001,16,18,18,17,16,16  
    10002,20,20,19,19,19,17  
    10003,20,17,18,19,20,20  
    10004,13,19,11,13,16,19  
    10005,11,18,9,0,16,16  
    10006,17,20,19,13,18,16  
    10007,15,20,17,13,14,17

  
  

-   Use ArrayList for storing the above data (Create a custom class for storing students marks) - (2 Marks)  
    
-   Create a custom exception while storing the marks into ArrayList (Condition: Number should be between 0 and 30)
    
-   Use Only Stream and Lambda for following  
    -   List the student who scored greater than 15 marks in ALL assessments.
        
    -   Find the average mark of the students' second assessment (A2).  
        
    -   Convert ALL assessment marks to 100
        

Hint: For Parsing List withing List in Stream  

E.g.  

    List<Student> courses = Arrays.asList(new Student("19BBS0001", Arrays.asList("CSE1001","CSE1002", "CSE1003")));
    
    System.out.println(
    
        courses.stream()
    
            .mapToLong(e->e.getCourses().stream()
    
                 .filter(x->x.equals("CSE1001"))
    
                  .count()
    
           ).sum());
