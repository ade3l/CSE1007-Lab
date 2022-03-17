## Activity-4 FileIO and Collections Live Session

You are expected to practice and understand the following concepts in Java
 - FileIO 
 - Collections (Generics, List, and Tuple)

**Activity Description**

Consider the following sample data set which contains students performance in math, reading and writing.  

    gender	group	test_preparation	math_score	reading_score	writing_score
    female	group B	none	72	72	74
    female	group C	completed	69	90	88
    female	group B	none	90	95	93
    male	group A	none	47	57	44
    male	group C	none	76	78	75
  
Write a generic data structure for reading and storing this data into List and then process the list with following conditions,  

1.  Find the average of marks in group wise
2.  Compare the any one of the scores based on the test preparation

**Note:**
-   You can create ALL Classes in the same Program
-   File Name should be the public class name which contains main method
-   You must follow ALL the Java Conventions discussed in Theory Class (Comments, CamelCase Rule ...)  
    
-   You must always create default and parametrized constructor for initializing class properties
-   You must always create Getter and Setter methods for ALL class properties
-   Always use try with resources for handling exceptions
-   To Open the File Java:  _try(BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://raw.githubusercontent.com/anthoniraj/datasets/main/StudentsPerformance.csv").openStream())))_  
    
-   Required Packages
    _import java.io.BufferedReader;   
    import java.io.InputStreamReader;
       import java.net.URL;_
    _import java.util.*;_
