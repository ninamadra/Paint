package View;

import Figures.figure;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;

/**
 * Class that customizes the context menu and passes it to the figure
 */
public class myContextMenu extends ContextMenu {

    /**
     * Constructor that creates the color picker and slider in the menu that will invoke the edit functions in the figure
     * @param figure the figure on which the change is made
     * @param x position of the context menu on the X axis
     * @param y position of the context menu on the Y axis
     */
    public myContextMenu(figure figure, double x, double y) {

        Slider slider = new Slider(0,360,0);
        final MenuItem rotate = new MenuItem("",slider);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                figure.rotate(((double) newValue) - ((double)oldValue));
            }
        });
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(figure.getColor());
        final MenuItem changeColor = new MenuItem("",colorPicker);
        changeColor.setOnAction(e -> {
            colorPicker.show();
            figure.setColor(colorPicker.getValue());
        });
        getItems().addAll(rotate, changeColor);
        figure.context(this, x, y);
    }
}