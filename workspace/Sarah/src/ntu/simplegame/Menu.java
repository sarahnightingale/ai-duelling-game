package ntu.simplegame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState {
	
	public Menu(int state){
	}

	private TiledMap map = null;
	public String mouse = "No input";
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {

		map = new TiledMap("data/dueltiles.tmx","data");

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.render(0,0);
		
		Image title = new Image("data/Wizard Duel Title.png");
		g.drawImage(title, 60, 130);
		
		Image button = new Image("data/playbutton.png");
		g.drawImage(button, 60, 400);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {

		Input input = gc.getInput();
		
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		if ((xpos>120 && xpos<505) && (ypos>105 && ypos<190)){
			if (input.isMousePressed(0)){
				sbg.enterState(2);
			}
		}
					
		mouse = "Mouse Position x: " + xpos + " y: " + ypos;
	}

	public int getID() {
		return 0;
	}
}
	
