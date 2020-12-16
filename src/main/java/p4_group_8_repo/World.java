package p4_group_8_repo;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.actor.Actor;

/**
 * An abstract class that extends {@link javafx.scene.layout.Pane} and handles a separate {@link #timer}
 * from the {@link GameScene#timer}.
 * @author Liew Yih Seng
 *
 */
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    /**
     * A constructor that instantiates the World class.
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					
					
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
					});
				}
			}
		});
    }
	
    /**
     * A method that creates a local timer by calling method {@link javafx.animation.AnimationTimer#AnimationTimer()}
     * within this class that handles the movements of actors that exist within the game.
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    /**
     * A method that handles the start of the local {@link #timer} created in method {@link #createTimer()}.
     */
    public void start() {
    	createTimer();
        timer.start();
    }
    
    /**
     * A method that stops the local timer within the {@link World} class by invoking
     * the stop method from {@link javafx.animation.AnimationTimer#AnimationTimer()}.
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * A method that adds new actors into the Pane.
     * @param actor An actor that represents the objects that exist within the pane.
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * A method that removes actors from the Pane.
     * @param actor An actor that represents the actor that has to be deleted off the pane.
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    /**
     * A method that looks for other objects
     * @param <A> List of objects that extends {@link p4_group_8_repo.actor.Actor} class.
     * @param cls A class that extends {@link p4_group_8_repo.actor.Actor}
     * @return The array of objects
     */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**
     * An abstract method that has to be inherited by the child class.
     * @param now A long integer that represents the current clock tick.
     */
    public abstract void act(long now);
}
