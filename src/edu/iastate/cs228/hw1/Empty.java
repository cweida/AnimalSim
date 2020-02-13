package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
	}
	
	public State who()
	{
		
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		int[] cen = new int[5];
		
		census(cen);
		
		if (cen[RABBIT] > 1)
		{
			Living newR = new Rabbit(pNew, this.row, this.column, 0);
			return newR;
		}
		
		else if (cen[FOX] > 1)
		{
			Living newR = new Fox(pNew, this.row, this.column, 0);
			return newR;
		}
		
		else if (cen[BADGER] > 1)
		{
			Living newR = new Badger(pNew, this.row, this.column, 0);
			return newR;
		}
		else if (cen[GRASS] >= 1)
		{
			Living newR = new Grass(pNew, this.row, this.column);
			return newR;
		}
		
		else
		{
			this.plain = pNew;
			return this;
		}
	}
}
