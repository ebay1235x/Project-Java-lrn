package model;

import java.awt.Point;
import java.util.Random;

import showboard.IPawn;

public class Monster extends Elements implements IPawn
{
	private Point Positon;
	private int startX;
	private int startY;
	private map map;

	public Monster(String nameFile, map Map) 
	{
		super(nameFile);
		this.map = Map;
		this.RandomStartPosition();
		this.setPosition(getStartX(), getStartY());
	}
		
	public final void RandomStartPosition()
	{
		int valuesX = 0;
		int valuesY = 0;
		while (map.mapRead[valuesX][valuesY] != 'N')
		{
			Random rX = new Random();
			Random rY = new Random();
			valuesX = 0 + rX.nextInt(19 - 0);
			valuesY = 0 + rY.nextInt(11 - 0);
		}
		this.startX = valuesX;
		this.startY = valuesY;
	}
	
	public final void RamdomMovingMonster()
	{
		Random Mouvement = new Random();
		int mouvementDirection = 0 + Mouvement.nextInt(9 - 0);
		switch(mouvementDirection)
		{
			case 1:
				this.rightMouvementMonster();
				break;
			case 2:
				this.leftMouvementMonster();
				break;
			case 3:
				this.forwardMouvementMonster();
				break;
			case 4:
				this.backwardMouvementMonster();
				break;
			case 5:
				this.diagonalLeftForwardMouvementMonster();
				break;
			case 6:
				this.diagonalRightForwardMouvementMonster();
				break;
			case 7:
				this.diagonalLeftBackwardMouvementMonster();
				break;
			case 8:
				this.diagonalRightBackwardMouvementMonster();
				break;
		}
		
	}
	
	public final void monstersTrackingLorann()
	{
		if (this.getX() < this.map.getLorann().getX())
			this.rightMouvementMonster();
		else if(this.getX() > this.map.getLorann().getX())
			this.leftMouvementMonster();
		else if(this.getY() < this.map.getLorann().getY())
			this.backwardMouvementMonster();
		else if(this.getY() > this.map.getLorann().getY())
			this.forwardMouvementMonster();
	}
	
	public final void monsterTrackingLorannSmarter()
	{
		if (this.getX() < this.map.getLorann().getX())
		{
			this.rightMouvementMonster();
		}
		if(this.getX() > this.map.getLorann().getX())
		{
			this.leftMouvementMonster();
		}
		if(this.getY() < this.map.getLorann().getY())
		{
			this.backwardMouvementMonster();
		}
		if(this.getY() > this.map.getLorann().getY())
		{
			this.forwardMouvementMonster();
		}
	}

	public final void rightMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void leftMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void forwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void backwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void diagonalRightForwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void diagonalLeftForwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void diagonalRightBackwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}
	public final void diagonalLeftBackwardMouvementMonster()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
	}

	
	@Override
	public int getX() 
	{
		return this.getPosition().x;
	}

	@Override
	public int getY() 
	{
		return this.getPosition().y;
	}

	@Override
	public Point getPosition() 
	{
		return this.Positon;
	}
	
	public final void setPosition(Point position)
	{
		this.Positon = position;
	}
	
	public final void setPosition(final int x, final int y)
	{
		this.Positon = new Point(x,y);
	}
	
	public int getStartX() 
	{
		return startX;
	}

	public int getStartY() 
	{
		return startY;
	}
	
}
