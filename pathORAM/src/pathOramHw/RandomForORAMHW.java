/*
 * You are NOT allowed to change this class. 
 * 
 * You MUST use it to get random number required at line 2 of the algorithm, and ONLY for that. 
 * Please do not use it for anything else, so that we can later verify your code deterministically.
 * 
 */

package pathOramHw;

import java.security.SecureRandom;

public class RandomForORAMHW implements RandForORAMInterface {
	private static boolean is_initialized = false;
	private static int bound = -1;
	SecureRandom rnd_generator;

	RandomForORAMHW(){
		
		if(is_initialized == true)
		{
			throw new RuntimeException("ONLY ONE RANDOM INSTANCE CAN BE USED AT A TIME");
		}
		
		try
		{
 			rnd_generator = SecureRandom.getInstanceStrong("SHA1PRNG);
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
			System.exit(1);
		}
		is_initialized  = true;
	}
	
	@Override
	public int getRandomLeaf(){
		if(bound == -1)
		{
			throw new RuntimeException("Bound is not set.");
		}
		//returns a random integer between 0 (INCLUSIVE) and bound (EXCLUSIVE)
		int output = rnd_generator.nextInt(bound);
		return output;
	}
	
	@Override
	public void setBound(int num_leaves)
	{
		bound = num_leaves;
	}
	
}
