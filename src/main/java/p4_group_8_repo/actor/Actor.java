package p4_group_8_repo.actor;

import javafx.scene.image.ImageView;
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
     * Gets the world in the application.
     * @return The world in the application.
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Gets the horizontal width of this {@link Actor}.
     * @return A double representing the width.
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Gets the vertical height of this {@link Actor}.
     * @return A double representing the height.
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Checks for all other {@link Actor} that currently intersect with this.
     * @param <A> A class that extends class {@link Actor}.
     * @param cls Represents the class that extends {@link Actor} to look for.
     * @return The array of {@link Actor} that intersects one another.
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * Checks for a single {@link Actor} object that intersects with this.
     * @param <A> A class that extends class {@link Actor}.
     * @param cls Represents the class that extends {@link Actor} to look for.
     * @return The first intersecting {@link Actor} object that intersects with this.
     */
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
    
    /**
     * A method that sets the X-coordinate and the Y-coordinate of the actor.
     * It invokes {@link #setX(double)} and {@link #setY(double)} to position the
     * actor within the game scene.
     * @param x An integer representing the X-coordinate of the actor in the game scene.
     * @param y An integer representing the Y-coordinate of the actor in the game scene.
     */
    public void setCoordinate(int x, int y) {
    	setX(x);
    	setY(y);
    }
    
    /**
     * This method reloops the actor back into the screen from the left side.
     * It checks if the actor has exited the game scene from the right, if the condition returns true, it
     * will invoke the method {@link #setX(double)} to reset the position of the actor in the X-axis
     * then allowing the actor to reenter the game scene.
     * @param xEnteringLeft An integer representing the initial X-coordinate of the actor within the game scene.
     * @param xCompLeft An integer representing the completion X-coordinate of the actor within the game scene.
     * @param speed A double that represents the movement speed of the actor.
     */
    public void loopEnterScreenLeft(int xEnteringLeft, int xCompLeft, double speed) {
    	if (getX() > xCompLeft && speed > 0)
    		setX(xEnteringLeft); //Enter from left
    }
    
    /**
     * This method reloops the actor back into the screen from the right side.
     * It checks if the actor has exited the game scene from the left, if the condition returns true,
     * if will invoke the method {@link #setX(double)} to reset the position of the actor in the X-axis
     * then allowing the actor to reenter the game scene.
     * @param xEnteringRight An integer representing the initial X-coordinate of the actor within the game scene.
     * @param xCompRight An integer representing the completion X-coordinate of the actor within the game scene.
     * @param speed A double that represents the movement speed of the actor.
     */
    public void loopEnterScreenRight(int xEnteringRight, int xCompRight, double speed) {
    	if(getX() < xCompRight && speed < 0)
    		setX(xEnteringRight); //Enter from right
    }
    
    /**
     * An abstract method that should be inherited by its child class to 
     * represent how its child class should react during clock tick.
     * @param now A long integer representing the current clock tick.
     */
    public abstract void act(long now);

}
