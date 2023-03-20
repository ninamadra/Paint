package View;

import Figures.circle;
import Figures.rectangle;
import Figures.triangle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class app extends Application {

    /**
     * A method of creating a GUI containing a drawing space and a menu with actions:
     * creating figures, opening dialog boxes and exiting the program
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();

        final Menu menu = new Menu("Paint");
        final Menu menuFigure = new Menu("Choose figure");
        final MenuItem help = new MenuItem("Help");
        help.setOnAction(e -> {
            helpDialog helpdialog = new helpDialog();
            helpdialog.showAndWait();
        });
        final MenuItem about = new MenuItem("About Paint");
        about.setOnAction(e -> {
            aboutDialog aboutdialog = new aboutDialog();
            aboutdialog.showAndWait();
        });
        final MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> stage.close());
        final MenuItem menuCircle = new MenuItem("Circle");
        final MenuItem menuRectangle = new MenuItem("Rectangle");
        final MenuItem menuTriangle = new MenuItem("Triangle");

        MenuBar menuBar = new MenuBar();
        menu.getItems().addAll(help, about, exit);
        menuFigure.getItems().addAll(menuCircle, menuRectangle, menuTriangle);
        menuBar.getMenus().addAll(menu, menuFigure);
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.getChildren().addAll(menuBar);

        menuCircle.setOnAction( e-> {
            circle circle = new circle();
            ArrayList <Double> parameters = new ArrayList<>();
            root.setOnMouseClicked( event -> {
                parameters.add(event.getX());
                parameters.add(event.getY());
                root.setOnMouseClicked( event2 -> {
                    parameters.add(event2.getX());
                    parameters.add(event2.getY());
                    circle.draw(root,parameters);
                    menuBar.toFront();
                    root.setOnMouseClicked(null);
                });

            });
        });

        menuRectangle.setOnAction( e-> {
            rectangle rectangle = new rectangle();
            ArrayList <Double> parameters = new ArrayList<>();
            root.setOnMouseClicked( event -> {
                parameters.add(event.getX());
                parameters.add(event.getY());
                root.setOnMouseClicked( event2 -> {
                    parameters.add(event2.getX());
                    parameters.add(event2.getY());
                    rectangle.draw(root,parameters);
                    menuBar.toFront();
                    root.setOnMouseClicked(null);
                });
            });
        });

        menuTriangle.setOnAction( e-> {
            triangle triangle = new triangle();
            ArrayList <Double> parameters = new ArrayList<>();
            root.setOnMouseClicked( event -> {
                parameters.add(event.getX());
                parameters.add(event.getY());
                root.setOnMouseClicked( event2 -> {
                    parameters.add(event2.getX());
                    parameters.add(event2.getY());
                    root.setOnMouseClicked( event3 -> {
                        parameters.add(event3.getX());
                        parameters.add(event3.getY());
                        triangle.draw(root,parameters);
                        menuBar.toFront();
                        root.setOnMouseClicked(null);
                    });
                });

            });
        });

        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            if( e.getCode() == KeyCode.ESCAPE ) {
                stage.close();
            }
        });

        Scene scene = new Scene(root,2560, 1800);
        stage.setTitle("Paint");
        stage.setMinHeight(700);
        stage.setMinWidth(1000);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();

    }
}