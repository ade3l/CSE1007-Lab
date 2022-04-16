import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.geometry.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileLab extends Application{
    public static void main (String[] args) {
        Application.launch(ProfileLab.class, args);
    }
    public void start(Stage stage) throws IOException {
//        Create label and textfields to take name email and mobile number
        Label nameLabel = new Label("Your name");
        Label emailLabel = new Label("Your email");
        Label mobileLabel = new Label("Your mobile number");
        Label dateLabel = new Label("Your date of birth");
        Label genderLabel = new Label("Gender");
        Label uploadLabel = new Label("Upload Profile Picture");
        Label fileUploaded = new Label();
        //Create textfields for the above labels
        TextField nameTextField = new TextField();
        TextField emailTextField = new TextField();
        TextField mobileTextField = new TextField();
        DatePicker dateTextField = new DatePicker();
        //Radio buttons for gender
        RadioButton maleRadioButton = new RadioButton("Male");
        RadioButton femaleRadioButton = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadioButton.setToggleGroup(genderGroup);
        femaleRadioButton.setToggleGroup(genderGroup);
        AtomicBoolean fileSelected = new AtomicBoolean(false);
        //Choose profile picture button
        Button chooseProfilePictureButton = new Button("Choose Profile Picture");
        //Create a button to submit the form
        Button submitButton = new Button("Submit Profile");
        //Add all the controls to the gridpane
        GridPane gridPane = new GridPane();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameTextField, 1, 0);
        gridPane.add(emailLabel, 0, 1);
        gridPane.add(emailTextField, 1, 1);
        gridPane.add(mobileLabel, 0, 2);
        gridPane.add(mobileTextField, 1, 2);
        gridPane.add(dateLabel, 0, 3);
        gridPane.add(dateTextField, 1, 3);
        gridPane.add(genderLabel, 0, 4);
        gridPane.add(maleRadioButton, 1, 4);
        gridPane.add(femaleRadioButton, 2, 4);
        gridPane.add(uploadLabel, 0, 5);
        gridPane.add(chooseProfilePictureButton, 1, 5);
        gridPane.add(fileUploaded, 2, 5);
        gridPane.add(submitButton, 1, 6);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        //Code for submit profile button
        submitButton.setOnAction(event -> {	 	  	 		     		    	   	 	     	 	
            if (validateForm(nameTextField, emailTextField, mobileTextField, dateTextField, genderGroup, fileSelected.get())) {
                 try{
                    //Save the profile to a new file called data.txt
                    //Check if data.txt exists. otherwise create it
                    File file = new File("data.txt");
                    if (!file.exists()) {
                            file.createNewFile();
                    }
                    //Write the data to the file
                    file.setWritable(true);
                     FileWriter fileWriter = new FileWriter(file);
                     fileWriter.write("Name: "+nameTextField.getText() + "\n");
                     fileWriter.write("Email: "+emailTextField.getText() + "\n");
                     fileWriter.write("Mobile: "+mobileTextField.getText() + "\n");
                     fileWriter.write("Date of Birth: "+dateTextField.getValue() + "\n");
                    //Get the selected radio button
                     RadioButton selectedRadioButton = (RadioButton) genderGroup.getSelectedToggle();
                     fileWriter.write("Gender: "+ selectedRadioButton.getText()+"\n");


                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Profile");
                    alert.setHeaderText("Profile");
                    alert.setContentText("Your profile has been submitted successfully");
                    alert.showAndWait();
                } catch (FileNotFoundException e) {
                     Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Profile");
                    alert.setHeaderText("File not found exception");
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

            }

        });
        chooseProfilePictureButton.setOnAction(event -> {	 	  	 		     		    	   	 	     	 	
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.jpeg", "*.jpg"));
            File selectedFile = fileChooser.showOpenDialog(null);
//            Show the image in an alert
            if (selectedFile != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Profile Picture");
                alert.setHeaderText("Profile Picture");
                //Insert the image into the alert
                Image image = new Image(selectedFile.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                alert.getDialogPane().setContent(imageView);
                alert.showAndWait();
                fileSelected.set(true);
                fileUploaded.setText(selectedFile.getName());
            }
                });
        //Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 600, 400);
        stage.setTitle("Profile Submission Form");
        stage.setScene(scene);
        stage.show();
    }

    private boolean validateForm(TextField nameTextField, TextField emailTextField, TextField mobileTextField, DatePicker dateTextField, ToggleGroup genderGroup, boolean fileSelected) {
        boolean valid = true;
        if (nameTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Name cannot be empty");
            alert.showAndWait();
            valid = false;
        }	 	  	 		     		    	   	 	     	 	
        else if (emailTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email cannot be empty");
            alert.showAndWait();
            valid = false;
        }
        //Check if mobile number has numbers only and is of 10 digits
        else if (mobileTextField.getText().isEmpty() || !mobileTextField.getText().matches("[0-9]{10}")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Mobile number cannot be empty and must be of 10 digits");
            alert.showAndWait();
            valid = false;
        }
        //Check if date of birth is in the format dd/mm/yyyy
        else if (dateTextField.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Date of birth must be in the format dd/mm/yyyy");
            alert.showAndWait();
            valid = false;
        }
        //Check if a gender is selected
        else if(genderGroup.getSelectedToggle()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please select a gender");
            alert.showAndWait();
            valid = false;
        }
        if(!fileSelected){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please select a profile picture");
            alert.showAndWait();
            valid = false;
        }	 	  	 		     		    	   	 	     	 	
        return valid;
    }
    
}
