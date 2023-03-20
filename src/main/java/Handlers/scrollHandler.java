package Handlers;

import Figures.figure;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

/**
 * A Class implementing the scroll event handler in the figure
 */
public class scrollHandler implements EventHandler<ScrollEvent> {

    /**
     * the figure on which the change is made
     */
    final private figure figure;

    /**
     * A constructor that assign event source figure to the figure class field
     * @param figure the figure on which the change is made
     */
    public scrollHandler(Figures.figure figure) { this.figure = figure; }

    /**
     * A method which calls the methods of widening and lengthening the figure, if figure is hit
     * @param scrollEvent
     */
    public void scale(ScrollEvent scrollEvent) {

        double initX = scrollEvent.getSceneX();
        double initY = scrollEvent.getSceneY();
        figure.addHeight(scrollEvent.getDeltaY() * 0.001);
        figure.addWidth(scrollEvent.getDeltaY() * 0.001);
    }

    /**
     * A method that calls the scaling method if the figure is active
     * @param scrollEvent
     */
    @Override
    public void handle(ScrollEvent scrollEvent) {
        if (scrollEvent.getEventType() == ScrollEvent.SCROLL && figure.isClicked()) { scale(scrollEvent); }
    }
}