package ntu.simplegame;

public class BayesClassifier { 

	private static String trainingdata[][] = { 
			//  PlayerHealth NPCHealth NPCStamina NPCPersonality SpellUsed 
			{"high",    "high",    "high",    "agressive",   "Expelliarmus"}, 
			{"high",     "low",    "low",     "cowardly",    "Protego"}, 
			{"medium",   "low",    "high",    "neutral",     "Expelliarmus"}, 
			{"low",      "high",   "low",     "agressive",   "Stupify"}, 
			{"low",      "high",   "high",    "cowardly",    "Incendio"}, 
			{"medium",   "medium", "medium",  "cowardly",    "Stupify"},
			{"high",     "medium", "high",    "neutral",     "Expelliarmus"}, 
			{"medium",   "high",   "low",     "neutral",     "Stupify"}, 
			{"high",     "low",    "medium",  "neutral",     "Incendio"}, 
			{"low",      "low",    "low",     "agressive",   "Stupify"}, 
			{"high",     "low",    "high",    "neutral",     "Expelliarmus"}, 
			{"medium",   "medium", "high",    "agressive",   "Incendio"}, 
			{"low",      "high",   "medium",  "neutral",     "Incendio"}, 
			{"high",     "high",   "low",     "cowardly",    "Protego"}, 
			{"low",      "medium", "low",     "coawrdly",    "Protego"}, 
			{"medium",   "low",    "high",    "agressive",   "Expelliarmus"}, 
			{"low",      "low",    "low",     "agressive",   "Stupify"}, 
			{"high",     "medium", "low",     "cowardly",    "Protego"}, 
			{"medium",   "high",   "medium",  "neutral",     "Incendio"}, 
			{"high",     "medium", "low",     "agressive",   "Stupify"}, 
			{"medium",   "low",    "medium",  "neutral",     "Incendio"}, 
			{"medium",   "medium", "medium",  "cowardly",    "Stupify"}, 
			{"medium",   "high",   "low",     "neutral",     "Stupify"}, 
			{"medium",   "medium", "high",    "agressive",   "Expelliarmus"}, 
			{"low",      "high",    "low",    "neutral",     "Stupify"} 

	}; 

	private static double m; 
	private static double p; 
	private static int num_attr = 4; 
	private static int train_size = 25; 
	private static int num_category = 4; 
	private static int test_size = 1; 
	public static String npc_spell;

	public BayesClassifier() { 

		m = 2.0; 
		p = 0.5; 

	} 

	public static double CalculateProbability(String[] test, String category) { 

		int count[] = new int[num_attr]; 
		for (int i=0; i<num_attr; i++) 
			count[i] = 0; 

		double p_category = 0.0; 
		int num_category = 0; 

		for (int j=0; j<train_size; j++) 
			if (category.equals(trainingdata[j][num_attr])) 
				num_category ++; 

		System.out.println(category + ": " + num_category); 
		p_category = (double)num_category/(double)train_size; 

		for (int i=0; i<num_attr; i++) 
		{ 
			for (int j=0; j<train_size; j++) 
				if ((test[i].equals(trainingdata[j][i])) && (category.equals(trainingdata[j][num_attr]))) 
					count[i] ++; 


			p_category *=  ((double)count[i] + m * p)/((double)num_category + m); 

			System.out.println(test[i] + " : " + count[i] + " (probability = " + ((double)count[i] + m * p)/((double)num_category + m) + ")"); 
		} 

		return p_category; 

	} 

	public static String main(String string)  
	{ 
		System.out.println(NPC_Fuzzy.fuzzyPlayerHealth);
		System.out.println(NPC_Fuzzy.fuzzyNpcHealth);
		System.out.println(NPC_Fuzzy.fuzzyNpcStamina);
		System.out.println(NPC_Fuzzy.npcPersonality);

		String testdata[][] = {
				{NPC_Fuzzy.fuzzyPlayerHealth, NPC_Fuzzy.fuzzyNpcHealth, NPC_Fuzzy.fuzzyNpcStamina,  NPC_Fuzzy.npcPersonality}
		};
		
		double result[] = new double[num_category]; 
		String category[] = {"Protego", "Expelliarmus", "Stupify", "Incendio"}; 

		for (int k = 0; k<test_size; k++) 
		{ 
			System.out.println("********************* the " + k + " test data ********************"); 
			for (int i=0; i<num_category; i++) 
			{ 
				result[i] = BayesClassifier.CalculateProbability(testdata[k], category[i]); 
				System.out.println(category[i] + ": " + result[i]); 

			} 

			double max = -1000.0; 
			int max_position = -1; 
			for (int i=0; i<num_category; i++) 
				if (result[i]> max) 
				{  
					max_position = i; 
					max = result[i]; 

				} 

			System.out.println("the " + k + " test data is classified as: " + category[max_position] + " with " + max); 
			npc_spell = category[max_position];
			System.out.println(npc_spell);
			
		} 
		return npc_spell;
	} 

}