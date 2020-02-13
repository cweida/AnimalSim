package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		// TODO  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		int[] cen = new int[5];
		
		census(cen);
		
		if(cen[RABBIT] > cen[GRASS]*3)
		{
			Living newE = new Empty(pNew, this.row,this.column);
			return newE;
		}
		
		else if(cen[RABBIT] >=3)
		{
			Living newR = new Rabbit(pNew, this.row,this.column, 0);
			return newR;
		}
		
		else
		{
			this.plain = pNew;
			return this;
		}
		
		
		
	}
}
