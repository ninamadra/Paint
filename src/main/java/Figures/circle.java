package Figures;

import Handlers.mouseHandler;
import Handlers.scrollHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

import static java.lang.Math.sqrt;
import static javafx.scene.paint.Color.DARKSALMON;
import static javafx.scene.paint.Color.TRANSPARENT;

/**
 * A class that defines a circle and implements methods for editing it
 */
public class circle extends figure {

    private Circle circle;

    @Override
    public void addX(double x) { circle.setCenterX(circle.getCenterX() + x); }

    @Override
    public void addY(double y) { circle.setCenterY(circle.getCenterY() + y); }

    @Override
    public void addWidth(double x) { circle.setScaleX(circle.getScaleX() + x); }

    @Override
    public void addHeight(double y) { circle.setScaleY(circle.getScaleY() + y); }

    @Override
    public void rotate(double angle) {}

    @Override
    public void context(ContextMenu contextMenu, double x, double y) { contextMenu.show(circle, x, y); }

    @Override
    public void setColor(Color color) { circle.setFill(color); }

    @Override
    public Color getColor() { return (Color)circle.getFill(); }

    @Override
    public void highlight() {
        Color color = (Color) circle.getFill();
        circle.setStroke(color.invert());
    }

    @Override
    public void unhighlight() { circle.setStroke(TRANSPARENT); }

    /**
     * A method that draws a circle with the given parameters on the indicated pane
     * @param pane pane, on which the figure will be displayed
     * @param parameters a parameter list containing the coordinates of the center and the point on the circle
     */
    @Override
    public void draw(Pane pane, ArrayList<Double> parameters) {

        circle.setLayoutX(parameters.get(0));
        circle.setLayoutY(parameters.get(1));
        circle.setRadius(sqrt(Math.pow(parameters.get(0) - parameters.get(2), 2) + Math.pow((parameters.get(1) - parameters.get(3)), 2)));
        pane.getChildren().add(circle);

    }

    /**
     * Constructor creating a circle and enabling event handlers
     */
    public circle() {

        circle = new Circle();
        circle.setRadius(50);
        circle.setFill(DARKSALMON);
        circle.setStrokeWidth(2);
        mouseHandler mouseHandler = new mouseHandler(this);
        circle.setOnMouseClicked(mouseHandler);
        circle.setOnMouseDragged(mouseHandler);
        circle.setOnMousePressed(mouseHandler);
        circle.setOnScroll(new scrollHandler(this));

    }
}
