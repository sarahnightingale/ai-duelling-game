package ntu.simplegame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import org.lwjgl.input.Mouse;

public class Play extends BasicGameState {

	public Play(int state){	

	}

	private TiledMap map = null;
	public String mouse = "No input";
	public static int playerHealth = 100;
	public static int npcHealth = 100;
	public static int playerStamina = 10;
	public static int npcStamina = 10;
	public int protegoCost = 2;
	public int expelliarmusCost = 5;
	public int stupifyCost = 1;
	public int incendioCost = 3;
	public int protegoDam = 0;
	public int expelliarmusDam = 20;
	public int stupifyDam = 5;
	public int incendioDam = 15;	
	private boolean playerTurn = true;
	private boolean NPCTurn = false;
	public String npcSpell;
	public String playerSpell;
	public boolean npcLowHealth;

	BayesClassifier bc = new BayesClassifier();

	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {

		map = new TiledMap("data/dueltiles.tmx","data");
	}

	public static int getPlayerHealth(){
		return playerHealth;
	}

	public static int getPlayerStamina(){
		return playerStamina;
	}

	public static int getNpcHealth(){
		return npcHealth;
	}

	public static int getNpcStamina(){
		return npcStamina;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.render(0,0);

		Image harryChar = new Image("data/HarryCharacter.png");
		g.drawImage(harryChar, -50, 200);

		if (CharacterSelect.getChar() == "Slytherin"){
			Image slytherinChar = new Image("data/SlytherinCharacter.png");
			g.drawImage(slytherinChar, 400, 225);
		}
		else if (CharacterSelect.getChar() == "Ravenclaw"){
			Image ravenclawChar = new Image("data/RavenclawCharacter.png");
			g.drawImage(ravenclawChar, 400, 225);
		}
		else if (CharacterSelect.getChar() == "Hufflepuff"){
			Image hufflepuffChar = new Image("data/HufflepuffCharacter.png");
			g.drawImage(hufflepuffChar, 400, 225);
		}

		if (playerSpell == "Protego"){
			Image protegoSpell = new Image("data/ProtegoSpell.png");
			g.drawImage(protegoSpell, 100, 225);
		}
		else if (playerSpell == "Incendio"){
			Image incendioSpell = new Image("data/IncendioSpell.png");
			g.drawImage(incendioSpell, 100, 225);
		}
		else if (playerSpell == "Expelliarmus"){
			Image expelliarmusSpell = new Image("data/ExpelliarmusSpell.png");
			g.drawImage(expelliarmusSpell, 100, 225);
		}
		else if (playerSpell == "Stupify"){
			Image stupifySpell = new Image("data/StupifySpell.png");
			g.drawImage(stupifySpell, 100, 225);
		}
		if (npcSpell == "Protego"){
			Image protegoSpell = new Image("data/ProtegoSpell.png");
			g.drawImage(protegoSpell, 300, 225);
		}
		else if (npcSpell == "Incendio"){
			Image incendioSpell = new Image("data/IncendioSpell.png");
			g.drawImage(incendioSpell, 300, 225);
		}
		else if (npcSpell == "Expelliarmus"){
			Image expelliarmusSpell = new Image("data/ExpelliarmusSpell.png");
			g.drawImage(expelliarmusSpell, 300, 225);
		}
		else if (npcSpell == "Stupify"){
			Image stupifySpell = new Image("data/StupifySpell.png");
			g.drawImage(stupifySpell, 300, 225);
		}
		
		if (playerHealth <= 0) {
			Image npcWins = new Image("data/NpcWins.png");
			g.drawImage(npcWins, 50, 125);
		}
		else if (npcHealth <= 0) {
			Image playerWins = new Image("data/PlayerWins.png");
			g.drawImage(playerWins, 50, 125);
		}
	
		g.setColor(Color.green);
		g.fillRect(25, 150, playerHealth, 10);
		g.fillRect(475, 150, npcHealth, 10);

		g.setColor(Color.blue);
		g.fillRect(25, 175, (playerStamina*10), 10);
		g.fillRect(475, 175, (npcStamina*10), 10);

		Image stupifyButton = new Image("data/Stupify.png");
		g.drawImage(stupifyButton, 25, 550);

		Image incendioButton = new Image("data/Incendio.png");
		g.drawImage(incendioButton, 210, 550);

		Image expelliarmusButton = new Image("data/Expelliarmus.png");
		g.drawImage(expelliarmusButton, 400, 550);

		Image protegoButton = new Image("data/Protego.png");
		g.drawImage(protegoButton, 210, 500);

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		Input input = gc.getInput();

		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "Mouse Position x: " + xpos + " y: " + ypos;



		if ((playerTurn == true) && (xpos>210 && xpos<382) && (ypos>60 && ypos<100) && (input.isMousePressed(0)) && (playerStamina>=protegoCost) && (playerHealth > 0) && (npcHealth > 0)) {	
			playerSpell = "Protego";
			npcHealth = npcHealth - protegoDam;
			playerStamina = playerStamina - protegoCost;
			if (playerStamina < 10){
				playerStamina = playerStamina +2;
			}
			playerTurn = false;
			NPCTurn = true;

		}

		else if ((playerTurn == true) && (xpos>25 && xpos<198) && (ypos>10 && ypos<48) && (input.isMousePressed(0)) && (playerStamina>=stupifyCost) && (playerHealth > 0) && (npcHealth > 0)) {	
			playerSpell = "Stupify";
			npcHealth = npcHealth - stupifyDam;
			playerStamina = playerStamina - stupifyCost;
			if (playerStamina < 10){	
				playerStamina = playerStamina +2;
			}
			playerTurn = false;
			NPCTurn = true;		
		}

		else if ((playerTurn == true) && (xpos>210 && xpos<382) && (ypos>10 && ypos<48) && (input.isMousePressed(0)) && (playerStamina>=incendioCost) && (playerHealth > 0) && (npcHealth > 0)) {	
			playerSpell = "Incendio";
			npcHealth = npcHealth - incendioDam;
			playerStamina = playerStamina - incendioCost;
			if (playerStamina < 10){	
				playerStamina = playerStamina +2;
			}
			playerTurn = false;
			NPCTurn = true;
		}

		else if ((playerTurn == true) && (xpos>400 && xpos<573) && (ypos>10 && ypos<48) && (input.isMousePressed(0)) && (playerStamina>=expelliarmusCost) && (playerHealth > 0) && (npcHealth > 0)) {	
			playerSpell = "Expelliarmus";
			npcHealth = npcHealth - expelliarmusDam;
			playerStamina = playerStamina - expelliarmusCost;
			if (playerStamina < 10){	
				playerStamina = playerStamina +2;
			}
			playerTurn = false;
			NPCTurn = true;
		}

		if ((playerTurn == false) && (NPCTurn == true) && (playerHealth > 0) && (npcHealth > 0)){
			int[] args = new int[] {(playerHealth), npcHealth, npcStamina};
			NPC_Fuzzy.main(args);
			npcSpell = BayesClassifier.npc_spell;
			System.out.println(npcSpell);

			if ((npcSpell == "Protego") && (npcStamina>=protegoCost) && (npcHealth > 0) && (playerHealth > 0)) {	
				npcSpell = "Protego";
				playerHealth = playerHealth - protegoDam;
				npcStamina = npcStamina - protegoCost;
				npcStamina = npcStamina +2;
				
				playerTurn = false;
				NPCTurn = true;

			}

			else if ((npcSpell == "Incendio") && (npcStamina>=incendioCost) && (npcHealth > 0) && (playerHealth > 0)) {	
				npcSpell = "Incendio";
				playerHealth = playerHealth - incendioDam;
				npcStamina = npcStamina - incendioCost;
				npcStamina = npcStamina +2;

				playerTurn = false;
				NPCTurn = true;

			}

			else if ((npcSpell == "Expelliarmus") && (npcStamina>=expelliarmusCost) && (npcHealth > 0) && (playerHealth > 0)) {	
				npcSpell = "Expelliarmus";
				playerHealth = playerHealth - expelliarmusDam;
				npcStamina = npcStamina - expelliarmusCost;
				npcStamina = npcStamina +2;

				playerTurn = false;
				NPCTurn = true;

			}

			else if ((npcSpell == "Stupify") && (npcStamina>=stupifyCost) && (npcHealth > 0) && (playerHealth > 0)) {	
				npcSpell = "Stupify";
				playerHealth = playerHealth - stupifyDam;
				npcStamina = npcStamina - stupifyCost;
				npcStamina = npcStamina +2;

				playerTurn = false;
				NPCTurn = true;

			}

			else if (npcStamina < 1){
				npcStamina = npcStamina +2;

				playerTurn = false;
				NPCTurn = true;
			}

			playerTurn = true;
			NPCTurn = false;

		}

	}


	public int getID() {
		return 1;
	}

}


