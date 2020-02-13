package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See the project description for the survival rules for a badger. 
		
		
		
		
		if (this.age == Living.BADGER_MAX_AGE)
		{
			Living newE = new Empty(pNew, this.row,this.column);
			return newE;
		}
		
		int[] cen = new int[5];
		
		census(cen);
		
		if (cen[BADGER] == 0 && cen[FOX] >= 2)
		{
			Living newF = new Fox(pNew, this.row, this.column, 0);
			return newF;
		}
		
		else if (cen[BADGER] + cen[FOX] > cen[RABBIT])
		{
			Living newE = new Empty(pNew, this.row,this.column);
			return newE;
		}
		else
		{
			this.age += 1;
			this.plain = pNew;
			return this;
		}
	}
}
