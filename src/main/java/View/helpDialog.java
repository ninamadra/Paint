package View;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Class that customizes the dialog to inform about program usage
 */
public class helpDialog extends Dialog {

    helpDialog() {

        VBox vbox = new VBox(5);
        vbox.setPadding(new Insets(10,20,10,20));
        setTitle("Help");
        Label paint = new Label("Paint");
        paint.setStyle("-fx-font-family: 'thewitcher';" + "-fx-font-size: 50;");

        Label Drawing = new Label("Drawing:");
        Drawing.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12;" + "-fx-font-weight:bold;" );
        Label DrawingInfo = new Label("select the desired figure in menu and click two or three times on the canvas");
        DrawingInfo.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12" );

        Label Moving = new Label("Moving:");
        Moving.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12;" + "-fx-font-weight: bold;" );
        Label MovingInfo = new Label("click the figure and drag it to the desired position");
        MovingInfo.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12" );

        Label Scaling = new Label("Scaling:");
        Scaling.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12;" + "-fx-font-weight: bold;" );
        Label ScalingInfo = new Label("click the figure and scroll with the mouse");
        ScalingInfo.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12" );

        Label Editing = new Label("Color changing and rotating:");
        Editing.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12;" + "-fx-font-weight: bold;" );
        Label EditingInfo = new Label("right-click the figure and choose an option from the menu");
        EditingInfo.setStyle("-fx-font-family: 'Courier New';" + "-fx-font-size: 12" );

        vbox.getChildren().addAll(paint,Drawing,DrawingInfo,Moving,MovingInfo,Scaling,ScalingInfo,Editing,EditingInfo);
        ButtonType button = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().setContent(vbox);
        getDialogPane().getButtonTypes().add(button);
    }
}