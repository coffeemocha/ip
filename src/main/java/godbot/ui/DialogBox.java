package godbot.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    public DialogBox(String message, Image img) {
        text = new Label(message);
        displayPicture = new ImageView(img);

        displayPicture.setFitWidth(50);
        displayPicture.setFitHeight(50);
        displayPicture.setClip(new Circle(25, 25, 25));

        text.setWrapText(true);
        this.setAlignment(Pos.TOP_RIGHT);
        this.getChildren().addAll(text, displayPicture);
    }

    public static DialogBox getUserDialog(String message, Image img) {
        return new DialogBox(message, img);
    }

    public static DialogBox getBotDialog(String message, Image img) {
        DialogBox db = new DialogBox(message, img);
        db.setAlignment(Pos.TOP_LEFT);
        ObservableList<javafx.scene.Node> tmp = FXCollections.observableArrayList(db.getChildren());
        FXCollections.reverse(tmp);
        db.getChildren().setAll(tmp);
        return db;
    }
}

