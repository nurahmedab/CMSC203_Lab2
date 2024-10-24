package application;




import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FXMainPane extends VBox {

    // Declare an instance of DataManager
    private DataManager dataManager;

    // Declare five buttons, a label, and a text field
    private Button helloButton;
    private Button howdyButton;
    private Button chineseButton;
    private Button clearButton;
    private Button exitButton;
    private Button otherLangButton; // Sixth button for another greeting
    private Label feedbackLabel;
    private TextField inputField;

    // Declare two HBoxes
    private HBox buttonBox;
    private HBox inputBox;

    // Constructor
    FXMainPane() {
        // Instantiate DataManager
        dataManager = new DataManager();

        // Instantiate the buttons
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");
        otherLangButton = new Button("Bonjour"); // For example, "Hello" in French

        // Instantiate the label
        feedbackLabel = new Label("Feedback:");

        // Instantiate the text field
        inputField = new TextField();

        // Instantiate the HBoxes
        inputBox = new HBox(10);
        buttonBox = new HBox(10);

        // Add label and text field to the inputBox
        inputBox.getChildren().addAll(feedbackLabel, inputField);
        
        // Add buttons to the buttonBox
        buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton, otherLangButton);

        // Set alignment for HBoxes
        inputBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        // Set padding and margins
        inputBox.setPadding(new Insets(10));
        buttonBox.setPadding(new Insets(10));

        // Set margins for buttons
        HBox.setMargin(helloButton, new Insets(5));
        HBox.setMargin(howdyButton, new Insets(5));
        HBox.setMargin(chineseButton, new Insets(5));
        HBox.setMargin(clearButton, new Insets(5));
        HBox.setMargin(exitButton, new Insets(5));
        HBox.setMargin(otherLangButton, new Insets(5));

        // Add the HBoxes to the FXMainPane
        this.getChildren().addAll(inputBox, buttonBox);

        // Set spacing between components in the VBox
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);

        // Set button click handlers
        helloButton.setOnAction(new ButtonHandler());
        howdyButton.setOnAction(new ButtonHandler());
        chineseButton.setOnAction(new ButtonHandler());
        clearButton.setOnAction(new ButtonHandler());
        exitButton.setOnAction(new ButtonHandler());
        otherLangButton.setOnAction(new ButtonHandler());
    }

    // Inner class for button handling
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Determine which button was clicked
            if (event.getTarget() == helloButton) {
                inputField.setText(dataManager.getHello());
            } else if (event.getTarget() == howdyButton) {
                inputField.setText(dataManager.getHowdy());
            } else if (event.getTarget() == chineseButton) {
                inputField.setText(dataManager.getChinese());
            } else if (event.getTarget() == clearButton) {
                inputField.setText("");
            } else if (event.getTarget() == exitButton) {
                Platform.exit();
                System.exit(0);
            } else if (event.getTarget() == otherLangButton) {
                inputField.setText(dataManager.getOtherLanguageGreeting()); // Handle other language
            }
        }
    }
}
