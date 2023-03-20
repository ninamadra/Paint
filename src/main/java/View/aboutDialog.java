package View;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * Class that customizes the dialog to inform about the program
 */
public class aboutDialog extends Dialog {

    aboutDialog() {

        VBox vbox = new VBox(3);
        vbox.setPadding(new Insets(10,20,10,20));
        setTitle("About");
        Label paint = new Label("Paint");
        paint.setStyle("-fx-font-family: 'thewitcher';" + "-fx-font-size: 50;");
        Label author = new Label("Author: Nina Madra");
        author.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 16;"+ "-fx-font-weight: bold;"  );
        Label info = new Label("Program to draw and edit simple shapes :)");
        info.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 16" );
        vbox.getChildren().addAll(paint,author,info);
        ButtonType button = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().setContent(vbox);
        getDialogPane().getButtonTypes().add(button);

    }
}