package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.IPawn;

public class MagicBall extends Elements implements IPawn
{
	private Point Positon;
	private map map;
	private int direction;
	private Image imageMagicBall[];
	private int numberImage = 0;

	public MagicBall(String nameFile,map Map) throws IOException 
	{
		super(nameFile);
		this.map = Map;
		this.imageMagicBall = new Image[5];
		int y = 0;
		for (int i = 1; i <= 5;i++)
		{
			this.imageMagicBall[y] = ImageIO.read(new File("Ressources/images/fireball_" + i + ".png"));
			y++;
		}
	}

	public void magicBallMouvement()
	{
		switch(this.direction)
		{
			case 0:
				this.rightMouvementMagicBall();
				break;
			case 1:
				this.leftMouvementMagicBall();
				break;
			case 2:
				this.forwardMouvementMagicBall();
				break;
			case 3:
				this.backwardMouvementMagicBall();
				break;
		}
	}
	
	public void animationBallMouvement()
	{
		if (numberImage == 5)
		{
			numberImage = 0;
		}
		this.setImage(imageMagicBall[numberImage]);
		numberImage++;
	}
	
	public final void rightMouvementMagicBall()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
		else
			this.setDirection(1);
		
	}
	public final void leftMouvementMagicBall()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewX = NewX - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
		else
			this.setDirection(0);
	}
	public final void forwardMouvementMagicBall()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY - 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
		else
			this.setDirection(3);
	}
	public final void backwardMouvementMagicBall()
	{
		int NewX = this.getX();
		int NewY = this.getY();
		NewY = NewY + 1;
		if (this.map.mapRead[NewX][NewY] != 'B' && this.map.mapRead[NewX][NewY] != 'H' && this.map.mapRead[NewX][NewY] != 'V' && this.map.mapRead[NewX][NewY] != 'C' && this.map.mapRead[NewX][NewY] != 'G' && this.map.mapRead[NewX][NewY] != 'P' && this.map.mapRead[NewX][NewY] != 'O')
		{
			this.setPosition(NewX, NewY);
		}
		else
			this.setDirection(2);
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

	public int getDirection() 
	{
		return direction;
	}

	public void setDirection(int direction) 
	{
		this.direction = direction;
	}

}
