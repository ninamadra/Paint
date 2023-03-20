package Figures;

import Handlers.mouseHandler;
import Handlers.scrollHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

import static javafx.scene.paint.Color.DARKSALMON;
import static javafx.scene.paint.Color.TRANSPARENT;

/**
 * An abstract class that defines a polygon and implements methods for editing it
 */

abstract public class polygon extends figure {

    protected Polygon polygon;

    /**
     * Coordinate X of the center of gravity of a polygon
     */
    protected double centreX;

    /**
     * Coordinate Y of the center of gravity of a polygon
     */
    protected double centreY;

    @Override
    public void addX(double x) { polygon.setLayoutX(polygon.getLayoutX()+x); }

    @Override
    public void addY(double y) { polygon.setLayoutY(polygon.getLayoutY()+y); }

    @Override
    public void addWidth(double x) { polygon.setScaleX(polygon.getScaleX() + x); }

    @Override
    public void addHeight(double y) { polygon.setScaleY(polygon.getScaleY() + y); }

    @Override
    public void rotate(double angle) {
        Rotate rotate = new Rotate(angle);
        rotate.setPivotX(centreX);
        rotate.setPivotY(centreY);
        polygon.getTransforms().add(rotate);
    }

    @Override
    public void context(ContextMenu contextMenu, double x, double y) {contextMenu.show(polygon, x, y); }

    @Override
    public void setColor(Color color) { polygon.setFill(color); }

    @Override
    public Color getColor() { return (Color)polygon.getFill(); }

    @Override
    public void highlight() {
        Color color = (Color) polygon.getFill();
        polygon.setStroke(color.invert());
    }

    @Override
    public void unhighlight() { polygon.setStroke(TRANSPARENT); }

    /**
     * A constructor that creates a polygon and enables an event handlers
     */
    polygon() {

        polygon = new Polygon();
        polygon.setFill(DARKSALMON);
        polygon.setStrokeWidth(2);
        mouseHandler mouseHandler = new mouseHandler(this);
        polygon.setOnMouseClicked(mouseHandler);
        polygon.setOnMouseDragged(mouseHandler);
        polygon.setOnMousePressed(mouseHandler);
        polygon.setOnScroll(new scrollHandler(this));
    }
}