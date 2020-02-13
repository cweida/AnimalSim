package edu.iastate.cs228.hw1;

/**
 *  
 * @author
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		super.plain = p;
		super.row = r;
		super.column = c;
		super.age = a;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		// TODO  
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		if(this.age == RABBIT_MAX_AGE)
		{
			Living newE = new Empty(pNew, this.row,this.column);
			return newE;
		}
		
		
		int[] cen = new int[5];
		
		census(cen);
		
		if(cen[GRASS] == 0)
		{
			Living newE = new Empty(pNew, this.row,this.column);
			return newE;
		}
		
		else if(cen[FOX] + cen[BADGER] >= cen[RABBIT] && cen[FOX] > cen[BADGER])
		{
			Living newF = new Fox(pNew, this.row,this.column, 0);
			return newF;
		}
		
		else if(cen[BADGER] > cen[FOX])
		{
			Living newB = new Badger(pNew, this.row,this.column, 0);
			return newB;
		}
		
		else
		{
			this.age ++;
			this.plain = pNew;
			return this;
		}
		
		
	}
}
