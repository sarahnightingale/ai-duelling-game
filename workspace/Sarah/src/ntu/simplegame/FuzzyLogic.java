package ntu.simplegame;

public class FuzzyLogic { 

	public FuzzyLogic()  

	{System.out.println("This is a fuzzy logic application");}; 
	
	public double downslope(double x, double left, double right) 
	{ 
		return ((right-x)/(right-left)); 
	} 

	public double upslope(double x, double left, double right) 
	{ 
		return ((x-left)/(right-left)); 
	} 

	public double p_h_low(double x) 
	{ 
		double left = 20.0; 
		double right = 30.0; 
		if (x<left) return 1; 
		else if (x>=right) return 0; 
		else return downslope(x, left, right); 
	}
	
	public double p_h_high(double x) 
	{ 
		double left = 60.0; 
		double right = 80.0; 
		if (x<left) return 0; 
		else if (x>=right) return 1; 
		else return upslope(x, left, right); 
	} 

	public double p_h_medium(double x)
	{
		double left_b = 20.0;
		double left_t = 35.0;
		double right_t = 60.0;
		double right_b = 80.0;

		if (x<=left_b) return 0;

		else if ((x>left_b) && (x<left_t))
		     return upslope(x, left_b, left_t);

		else if ((x>right_t) && (x<right_b))
		     return downslope(x, right_t, right_b);

		else if (x>=right_b) return 0;

		else return 1; /* for plateau */
	}

	public double n_h_low(double x) 
	{ 
		double left = 20.0; 
		double right = 30.0; 
		if (x<=left) return 1; 
		else if (x>=right) return 0; 
		else return downslope (x, left, right); 

	} 

	public double n_h_medium(double x)
	{
		double left_b = 20.0;
		double left_t = 35.0;
		double right_t = 60.0;
		double right_b = 80.0;


		if (x<=left_b) return 0;

		else if ((x>left_b) && (x<left_t))
		     return upslope(x, left_b, left_t);

		else if ((x>right_t) && (x<right_b))
		     return downslope(x, right_t, right_b);

		else if (x>=right_b) return 0;

		else return 1; /* for plateau */
	}

	public double n_h_high(double x) 
	{ 
		double left = 60.0; 
		double right = 80.0; 
		if (x<=left) return 0; 
		else if (x>=right) return 1; 
		else return upslope (x, left, right); 

	} 

	public double n_s_low(double x) 
	{ 
		double left = 0.0; 
		double right = 4.0; 
		if (x<=left) return 1; 
		else if (x>=right) return 0; 
		else return downslope (x, left, right); 

	} 

	public double n_s_medium(double x)
	{
		double left_b = 2.0;
		double left_t = 4.0;
		double right_t = 6.0;
		double right_b = 8.0;


		if (x<=left_b) return 0;

		else if ((x>left_b) && (x<left_t))
		     return upslope(x, left_b, left_t);

		else if ((x>right_t) && (x<right_b))
		     return downslope(x, right_t, right_b);

		else if (x>=right_b) return 0;

		else return 1; /* for plateau */
	}

	public double n_s_high(double x) 
	{ 
		double left = 7.0; 
		double right = 10.0; 
		if (x<=left) return 0; 
		else if (x>=right) return 1; 
		else return upslope (x, left, right); 

	} 

	public double f_and(double x, double y) 
	{ 
		if (x<y) return x; 
		else return y; 
	} 

	public double f_or(double x, double y) 
	{ 
		if (x<y) return y; 
		else return x; 
	} 
	
	public static void main(String[] args)  
	{ 
		{System.out.println("This is a fuzzy logic application");}; 
		
	}

	}