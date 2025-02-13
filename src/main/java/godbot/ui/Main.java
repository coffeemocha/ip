package godbot.ui;

import godbot.GodBot;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private GodBot godBot = new GodBot("./data/godbot.txt");

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/godbotUser.jpg"));
    private Image godBotImage = new Image(this.getClass().getResourceAsStream("/images/godbotBot.jpg"));

    @Override
    public void start(Stage stage) {
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        dialogContainer.getChildren().addAll(DialogBox.getBotDialog("Welcome, mortal!", godBotImage));

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.setTitle("GodBot");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);
        dialogContainer.setPrefHeight(javafx.scene.layout.Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);
        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);
        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);
        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        sendButton.setOnAction(event -> handleUserInput());
        userInput.setOnAction(event -> handleUserInput());

        stage.show();
    }

    private void handleUserInput() {
        String input = userInput.getText();
        String response = godBot.getResponse(input);

        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getBotDialog(response, godBotImage)
        );

        userInput.clear();
	if (input.equalsIgnoreCase("bye")){
	    Platform.exit();
	}
    }

    public static void main(String[] args) {
        launch(args);
    }
}

