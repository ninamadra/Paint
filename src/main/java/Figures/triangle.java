package Figures;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * A class that implements triangle drawing
 */
public class triangle extends polygon {

    /**
     * A method that draws a triangle with the given parameters on the indicated pane
     * @param pane  pane, on which the figure will be displayed
     * @param parameters a parameter list containing the coordinates of the three vertices of the triangle
     */
    @Override
    public void draw(Pane pane, ArrayList<Double> parameters) {

        for( int i = 0; i < 6; i += 2) {
            centreX+=parameters.get(i);
            centreY+=parameters.get(i+1);
        }
        polygon.getPoints().addAll(parameters);
        centreX/=3;
        centreY/=3;
        pane.getChildren().add(polygon);
    }
}
