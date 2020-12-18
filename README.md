
# Frogger Arcade
##### Name		: Liew Yih Seng 
##### Student Id: 20090325
 
 
# Key Changes

### Maintenance
1.	Giving GUI a whole new wrap.
	-	Initially, program runs in a retro theme.
	-	Re-illustrated all artworks in the program into
		a more solid looking theme, in the hope to provide users with a
		better experience and usability throughout the entire program.
			
2.	Refactored Animal Class.
	-	Code smell is detected in the method act(), initiatives taken
		to produce a clean code by breaking Long Method into several other
		methods. Example, setHeightBound(), setCarDeathAnimation(now) and setCrashObstacle() which further promotes readability of the code.

3.	Breaking Obstacle Class into meaningful classes.
	-	Initially, this class represented too many types of objects with too many
		different types of parameter being injected into it.
	-	Broken down into subclasses that promotes better code readability, example 
		Class RedCar, RedTruck, TaxiCar and LongTruck each being
		separated into respective classes. Classes of the same type will implement
		the same interface which contain their standardized constant value. Example, 
		Class RedCar and TaxiCar both implements Interface SedanCar.
	-	This has effectively reduce the number of parameter being injected into the
		constructor of these classes in Class GameScene.

4.	Introduced design pattern to the program.
	- 	Abstract Factory
		- 	This pattern can be found in the Interface PagesNavAbstractFactory where
				it provides a model of methods for classes like MenuSceneController and 
				PauseSceneController to implement.
				
	- 	Singleton
		- 	This pattern can be found in Class HighScores, where the constructor has 
				been declared as private and a public static method getInstance()has been 
				created to only allow the entire program to have one copy of this 
				HighScores class being constructed.
				
	- 	Prototype
		- 	This creational pattern can be found in Abstract Class Obstacle, where it 
				has been treated as a prototype interface, allowing its concrete subclasses
				to extend it, resulting in creation of an object without code coupling 
				with the superclass object.

### Extension
1.	Extended the program becoming a multiscene program.
	-	Initially this program has only one scene that holds the gameplay, 
		but have been extended into 8 scenes excluding the game play scene.
	-	All the 8 scenes obey the MVC design pattern, where all controllers are stored 
		in the src/main/java/group_8_repo.controller package while their views are
		being stored in the src/main/resources/views folder.

2.	Added levels to the GameScene.
	-	Initially the program comes with only one level, now the game has 10 levels 
		with 10 different difficulties.
	-	As the user's level increases, the speed of the moving obstacles increases.
	-	The number of ends for each level varies too. Where level 1, 4, 7, 10 has 
		5 Lilypads, level 2, 5, 8 has 3 Lilypads and level 3, 6, 9 has 2 Lilypads 
		as their ends.
	- 	Snake obstacle will be introduced after level 4.


###Installation



 
