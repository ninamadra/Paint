package Figures;

import javafx.scene.control.ContextMenu;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;

/**
 * Interface defining methods for geometric figures
 */
public interface figureInterface {

    /**
     * A method of moving the figure on the X axis
     * @param x shift value
     */
    public void addX(double x);

    /**
     * A method of moving the figure on the Y axis
     * @param y shift value
     */
    public void addY(double y);

    /**
     * Figure widening method
     * @param x widening scale
     */
    public void addWidth(double x);

    /**
     * Figure lengthening method
     * @param y lengthening scale
     */
    public void addHeight(double y);

    /**
     * A method of rotating the figure relative to its center by a given angle
     * @param angle
     */
    public void rotate(double angle);

    /**
     * A method for adding a context menu to the figure
     * @param contextMenu
     * @param x position of the context menu on the X axis
     * @param y position of the context menu on the Y axis
     */
    public void context(ContextMenu contextMenu, double x, double y);

    /**
     * A method that changes the figure's fill to a given color
     * @param color
     */
    void setColor(Color color);

    /**
     *A method that returns the figure's fill color
     * @return figure's fill color
     */
    Color getColor();

    /**
     * A method of highlighting the figure to a color opposite to its fullness
     */
    void highlight();

    /**
     * A method that turns off the highlight
     */
    void unhighlight();

    /**
     * A method of informing whether a figure is active
     * @return figure's activity (true if active and false otherwise)
     */
    boolean isClicked();

    /**
     * A method of setting the figure's activity
     * @param click Given activity (true if active and false otherwise)
     */
    void setClicked(boolean click);

    void draw(Pane pane, ArrayList <Double> parameters);

}