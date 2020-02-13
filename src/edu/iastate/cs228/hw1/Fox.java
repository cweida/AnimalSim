package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		if (this.age == Living.FOX_MAX_AGE)
		{
			Living newE = new Empty(pNew, this.row,this.column);
			return newE;
		}
		
		int[] cen = new int[5];
		
		census(cen);
		
		if (cen[BADGER] > cen[FOX])
		{
			Living newB = new Badger(pNew, this.row, this.column, 0);
			return newB;
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
