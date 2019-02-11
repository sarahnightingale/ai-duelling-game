package ntu.simplegame;

import java.util.Arrays;

public class NPC_Fuzzy {

	public static String fuzzyPlayerHealth;
	public static String fuzzyNpcHealth;
	public static String fuzzyNpcStamina;
	public static String npcPersonality;

	public static boolean EXTEND(double x)	
	{ return ((x < 0.3) ? false : true);}

	public static void main(int[] args) {

		FuzzyLogic fl = new FuzzyLogic();

		double playerHealth = Play.playerHealth;
		double npcHealth = Play.npcHealth, npcStamina = Play.npcStamina;
		
		System.out.println(playerHealth + " is low: " + fl.p_h_low(playerHealth) + "; and medium: " + fl.p_h_medium(playerHealth) + "; and high: " +  fl.p_h_high(playerHealth));		
		if (EXTEND(fl.p_h_low(playerHealth))){
			fuzzyPlayerHealth = "low";
			System.out.println(fuzzyPlayerHealth);
		}
		else if (EXTEND(fl.p_h_medium(playerHealth))){
			fuzzyPlayerHealth = "medium";
			System.out.println(fuzzyPlayerHealth);
		}
		else if (EXTEND(fl.p_h_high(playerHealth))){
			fuzzyPlayerHealth = "high";
			System.out.println(fuzzyPlayerHealth);
		}
	    	    
		System.out.println("\n");

		System.out.println(npcHealth + " is low: " + fl.n_h_low(npcHealth) + "; and medium: " + fl.n_h_medium(npcHealth) + "; and high: " +  fl.n_h_high(npcHealth));
		if (EXTEND(fl.n_h_low(npcHealth))){
			fuzzyNpcHealth = "low";
			System.out.println(fuzzyNpcHealth);
		}
		else if (EXTEND(fl.n_h_medium(npcHealth))){
			fuzzyNpcHealth = "medium";
			System.out.println(fuzzyNpcHealth);
		}
		else if (EXTEND(fl.n_h_high(npcHealth))){
			fuzzyNpcHealth = "high";
			System.out.println(fuzzyNpcHealth);
		}

		System.out.println("\n");
		System.out.println(npcStamina + " is low: " + fl.n_s_low(npcStamina) + "; and medium: " + fl.n_s_medium(npcStamina) + "; and high: " + fl.n_s_high(npcStamina));

		if (EXTEND(fl.n_s_low(npcStamina))){
			fuzzyNpcStamina = "low";
			System.out.println(fuzzyNpcStamina);
		}
		else if (EXTEND(fl.n_s_medium(npcStamina))){
			fuzzyNpcStamina = "medium";
			System.out.println(fuzzyNpcStamina);
		}
		else if (EXTEND(fl.n_s_high(npcStamina))){
			fuzzyNpcStamina = "high";
			System.out.println(fuzzyNpcStamina);
		}
		
		if (CharacterSelect.getChar() == "Slytherin")
		{
			npcPersonality = "agressive";
		}
		else if (CharacterSelect.getChar() == "Ravenclaw")
		{
			npcPersonality = "neutral";
		}
		else if (CharacterSelect.getChar() == "Hufflepuff")
		{
			npcPersonality = "cowardly";
		}
		
		
		String[] arguments = new String[] {(fuzzyPlayerHealth), (fuzzyNpcHealth), (fuzzyNpcStamina), (npcPersonality)};
		System.out.println(Arrays.toString(arguments));
	    BayesClassifier.main(Arrays.toString(arguments));

	}
}



