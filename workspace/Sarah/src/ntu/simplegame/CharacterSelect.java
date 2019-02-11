package ntu.simplegame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import org.lwjgl.input.Mouse;

public class CharacterSelect extends BasicGameState {

	private TiledMap map = null;
	public String mouse = "No input";
	private static String character = null;
	
	public static String getChar(){
		return character;
	}
		
	public CharacterSelect(int state){
	}	
			
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {

		map = new TiledMap("data/dueltiles.tmx","data");

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.render(0,0);
			
		Image slytherinButton = new Image("data/SlytherinButton.png");
		g.drawImage(slytherinButton, 150, 100);
		
		Image ravenclawButton = new Image("data/RavenclawButton.png");
		g.drawImage(ravenclawButton, 150, 200);
		
		Image hufflepuffButton = new Image("data/HufflepuffButton.png");
		g.drawImage(hufflepuffButton, 150, 300);
			
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {

		Input input = gc.getInput();
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		if ((xpos>150 && xpos<467) && (ypos>422 && ypos<500) && (input.isMouseButtonDown(0))){
			character = "Slytherin";
			sbg.enterState(1);

		}
		
		
	    if ((xpos>150 && xpos<467) && (ypos>322 && ypos<400) && (input.isMouseButtonDown(0))){
			character = "Ravenclaw";
	    	sbg.enterState(1);

		}
        
	    
	    if ((xpos>150 && xpos<467) && (ypos>222 && ypos<300) && (input.isMouseButtonDown(0))){
		    character = "Hufflepuff";
	    	sbg.enterState(1);

		}
		     			
		mouse = "Mouse Position x: " + xpos + " y: " + ypos;
	
	}

	public int getID() {
		return 2;
	}
	
}