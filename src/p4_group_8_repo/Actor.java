package p4_group_8_repo;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;


public abstract class Actor extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

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
    		setX(xEnteringLeft);	//Enter from left
    	if(getX() < xCompRight && speed <0)
    		setX(xEnteringRight); //Enter from right
    }

    public abstract void act(long now);

}
