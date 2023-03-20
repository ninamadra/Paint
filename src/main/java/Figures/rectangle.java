package Figures;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * A class that implements rectangle drawing
 */
public class rectangle extends polygon {

    /**
     * A method that draws a triangle with the given parameters on the indicated pane
     * @param pane  pane, on which the figure will be displayed
     * @param parameters a parameter list containing the coordinates of the two opposite vertices of the rectangle
     */
    @Override
    public void draw(Pane pane, ArrayList<Double> parameters) {

        double x1 = parameters.get(0);
        double y1 = parameters.get(1);
        double x2 = parameters.get(2);
        double y2 = parameters.get(3);
        centreX = ( x1 + x2 )/2;
        centreY = ( y1 + y2 )/2;
        polygon.getPoints().addAll(x1, y1, x2, y1, x2, y2, x1, y2);
        pane.getChildren().add(polygon);
    }

}
