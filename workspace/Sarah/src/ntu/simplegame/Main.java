package ntu.simplegame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{
   
   public static final String gamename = "Wizard Duel";
   public static final int menu = 0;
   public static final int play = 1;
   public static final int character = 2;
   public static final int xSize = 600;
   public static final int ySize = 600;
   
   public Main(String gamename){
      super(gamename);
      this.addState(new Menu(menu));
      this.addState(new Play(play));
      this.addState(new CharacterSelect(character));
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(menu).init(gc, this);
      this.getState(play).init(gc, this);
      this.getState(character).init(gc, this);
      this.enterState(menu);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(xSize, ySize, false);
         appgc.setTargetFrameRate(40);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
 }
