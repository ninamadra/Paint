package Figures;

/**
 * An abstract figure class implementing methods related to its activity
 */
abstract public class figure implements figureInterface {

    /**
     * a boolean variable that stores the current activity of the figure (true if active and false otherwise)
     */
    protected boolean clicked;

    @Override
    public boolean isClicked() { return clicked; }

    @Override
    public void setClicked(boolean click) { clicked = click; }

}