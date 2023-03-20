package Handlers;

import Figures.figure;
import View.myContextMenu;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * A Class implementing the mouse event handler in the figure
 */
public class mouseHandler implements EventHandler<MouseEvent>  {

    /**
     * the figure on which the change is made
     */
    final private Figures.figure figure;

    /**
     * initial coordinate of mouse event on X axis
     */
    private double initX;

    /**
     * initial coordinate of mouse event on Y axis
     */
    private double initY;

    /**
     * A constructor that assign event source figure to the figure class field
     * @param figure the figure on which the change is made
     */
    public mouseHandler(figure figure) {
        this.figure = figure;
    }

    /**
     * A method which calls the methods of moving figure on X and Y axis to the desired position
     * @param mouseEvent
     */
    public void move(MouseEvent mouseEvent) {

        double dx = mouseEvent.getSceneX() - initX;
        double dy = mouseEvent.getSceneY() - initY;
        figure.addX(dx);
        figure.addY(dy);
        initX += dx;
        initY += dy;
    }

    /**
     * A method to turn on/off the activity and highlight, and invoke moving method or create a context menu in click point
     * @param mouseEvent
     */
    @Override
    public void handle(MouseEvent mouseEvent) {

        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED & mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            figure.setClicked(!(figure.isClicked()));
            initX = mouseEvent.getSceneX();
            initY = mouseEvent.getSceneY();
        }
        if(figure.isClicked() & mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            figure.highlight();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED ) {
                initX = mouseEvent.getSceneX();
                initY = mouseEvent.getSceneY();
            }
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_DRAGGED) { move(mouseEvent); }
        }
        if(!figure.isClicked()) { figure.unhighlight(); }
        if (figure.isClicked() & mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED & mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
            myContextMenu contextMenu = new myContextMenu(figure, mouseEvent.getSceneX(), mouseEvent.getSceneY());
        }
    }
}

