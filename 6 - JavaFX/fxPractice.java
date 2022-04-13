import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
public class fxPractice extends Application{
    
    public static void main (String[] args) {
        Application.launch(fxPractice.class,args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        Button divButton = new Button("/");
        Button multButton = new Button("*");
        Button addButton = new Button("+");
        Button minButton = new Button("-");
        TextField num1 = new TextField();
        TextField num2 = new TextField();
        Label resultLabel = new Label("?");
        Button clearButton = new Button("Clear");
        
        GridPane layout = new GridPane();
        layout.setVgap(15);
        layout.setHgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.add(divButton, 0, 1);
        layout.add(multButton, 1, 1);
        layout.add(addButton, 0, 2);
        layout.add(minButton, 1, 2);
        layout.add(num1, 0, 3);
        layout.add(num2, 1, 3);
        layout.add(resultLabel,0 ,4, 2, 1);
        layout.add(clearButton, 0, 5, 2, 1);
        GridPane.setHalignment(resultLabel, HPos.CENTER);
        GridPane.setHalignment(clearButton, HPos.CENTER);
        
        divButton.setMaxWidth(Double.MAX_VALUE);
        multButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setMaxWidth(Double.MAX_VALUE);
        minButton.setMaxWidth(Double.MAX_VALUE);
        resultLabel.setStyle("-fx-border-size: 10px; -fx-border-color:black;");
        resultLabel.setMaxWidth(Double.MAX_VALUE);
        resultLabel.setAlignment(Pos.CENTER);
        
        divButton.setOnAction(e -> {	 	  	 		     		    	   	 	     	 	
            try{
                int result = calculate(num1, num2, 1);
                resultLabel.setText(String.valueOf(result));
            }
            catch(invalidInputException exp){
                resultLabel.setText(exp.getMessage());
            }
            
        });
        
        
        multButton.setOnAction(e -> {
            try{
                int result = calculate(num1, num2, 2);
                resultLabel.setText(String.valueOf(result));
            }
            catch(invalidInputException exp){
                resultLabel.setText(exp.getMessage());
            }
            
        });
        
        addButton.setOnAction(e -> {
            try{
                int result = calculate(num1, num2, 3);
                resultLabel.setText(String.valueOf(result));
            }
            catch(invalidInputException exp){
                resultLabel.setText(exp.getMessage());
            }
            
        });
        
        minButton.setOnAction(e -> {
            try{
                int result = calculate(num1, num2, 4);
                resultLabel.setText(String.valueOf(result));
            }	 	  	 		     		    	   	 	     	 	
            catch(invalidInputException exp){
                resultLabel.setText(exp.getMessage());
            }
            
        });
        
        clearButton.setOnAction(e -> {
            resultLabel.setText("?");
            num1.clear();
            num2.clear();
        });
        Scene scene = new Scene(layout,800 ,800);
        stage.setScene(scene);
        stage.show();
    }
    int calculate(TextField field1, TextField field2, int optn) throws invalidInputException{
        try{
            int num1 = Integer.parseInt(field1.getText()); 
            int num2 = Integer.parseInt(field2.getText()); 
            switch(optn){
                case 1: return num1/num2;
                case 2: return num1*num2;
                case 3: return num1+num2;
                case 4: return num1-num2;
            }
        }
        catch(NumberFormatException e){
            throw new invalidInputException("Make sure both the fields have valid numbers");
        }
        catch(ArithmeticException e){
            throw new invalidInputException("Operation not valid");
        }
        return -1;
        
    }
}	 	  	 		     		    	   	 	     	 	
class invalidInputException extends Exception{
    invalidInputException(String message){
        super(message);
    }
}
