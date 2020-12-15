package p4_group_8_repo.actor;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import p4_group_8_repo.World;

import java.util.ArrayList;

/**
 * This abstract class provides the game with objects that has animations and movements.
 * @author Liew Yih Seng
 *
 */
public abstract class Actor extends ImageView{

	/**
	 * This method provides objects with movements. 
	 * It invokes the method {@link #setX(double)} and 
	 * {@link #setY(double)} to set the movement of the actor.
	 * @param dx A double that represents the movement in the X-axis.
	 * @param dy A double that represents the movement in Y-axis.
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Gets the world in the application
     * @return The world in the application
     */
    public World getWorld() {
        return (World) getParent();
    }

    
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }
    
    public void setCoordinate(int x, int y) {
    	setX(x);
    	setY(y);
    }
    
    public void loopEnterScreen(int xEnteringLeft, int xEnteringRight, int xCompLeft, int xCompRight, double speed) { //Making Images to enter the screen after exiting the screen
    	if (getX() > xCompLeft && speed > 0)
    		setX(xEnteringLeft); //Enter from left
    	if(getX() < xCompRight && speed < 0)
    		setX(xEnteringRight); //Enter from right
    }

    public abstract void act(long now);

}
