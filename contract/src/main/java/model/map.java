package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class map 
{
	//Sprites
	private final Elements Bone = new Elements("ImagesRayanEngine/bone.png");
		
	private final Elements H_Bone = new Elements("ImagesRayanEngine/horizontal_bone.png");
		
	private final Elements V_Bone = new Elements("ImagesRayanEngine/vertical_bone.png");

	private final Elements Nothing = new Elements("ImagesRayanEngine/void.png");
		
	private Elements closeGate = new Elements("ImagesRayanEngine/gate_closed.png");
	
	private Elements purse = new Elements("ImagesRayanEngine/purse.png");
	
	private Elements crystallBall = new Elements("ImagesRayanEngine/crystal_ball.png");
	
	private Elements OpenGate = new Elements("ImagesRayanEngine/gate_open.png");
	
	private Lorann lorann;
	

	
	//Reading the file
	File f = new File("Ressources/Maps/MAP5.txt");
    FileReader fileReader;
    public char choice;
    public char mapRead[][] = new char[width][height];
    private final static int height = 12;
	private final static int width = 20;
	
	//characteristic of the map
	private int numberOfCrystallBall = 0;
	private int scoreLorann = 0;
	private String map;
	
	public map(String map_p) throws IOException
    {
        this.map = map_p;
        this.readmapBDD();
        this.lorann = new Lorann("ImagesRayanEngine/lorann_1.png", this);
       
        this.calculatedNumberOfCrystallBall();
    }
    
	@SuppressWarnings("unused")
	private void readMap()
	{
		try
	    {
	        fileReader = new FileReader(f);
	    }
	    catch (FileNotFoundException exception)
	    {
	        System.out.println("File not found");
	    }
	    //Lecture
	    try
	    {
	        int c = 0;
	        for (int y = 0; y < height ; y++) 
	        {
	            for (int x = 0; x < width; x++) 
	            {
	            	c = fileReader.read();
	            	choice = (char)c;
	            	switch (choice) 
	            	{
	        		case 'B' :
	        			mapRead[x][y] = 'B';
	        			break;
	        			
	        		case 'H' : 
	        			mapRead[x][y] = 'H';
	        			break;
	        			
	        		case 'V' : 
	        			mapRead[x][y] = 'V';
	        			break;
	        		
	        		case 'N' : 
	        			mapRead[x][y] = 'N';
	        			break;
	        			
	        		case 'G' :
	        			mapRead[x][y] = 'G';
	        			break;
	        			
	        		case 'P' :
	        			mapRead[x][y] = 'P';
	        			break;
	        			
	        		case 'C' :
	        			mapRead[x][y] = 'C';
	        			break;
	            	}
	            }
	        }
	    }
	    catch (IOException exception)
	    {
	        System.out.println ("Error when reading the file : " + exception.getMessage());
	    }
	}
	
	public void readmapBDD () {

        char choice;
        int i = 0;

         for (int y = 0; y < height ; y++) 
            {
                for (int x = 0; x < width; x++) 
                {

                    choice = this.map.charAt(i);

                            switch (choice) 
                            {
                            case 'B' :
                                mapRead[x][y] = 'B';
                                break;

                            case 'H' : 
                                mapRead[x][y] = 'H';
                                break;

                            case 'V' :
                                mapRead[x][y] = 'V';
                                break;

                            case 'N' :
                                mapRead[x][y] = 'N';
                                break;

                            case 'G' :
                                mapRead[x][y] = 'G';
                                break;
                            case 'P' :
                                mapRead[x][y] = 'P';
                                break;
                            case 'C' :
                                mapRead[x][y] = 'C';
                                break;
                            }
                            i++;
                }
            }
    }
	
	public void calculatedNumberOfCrystallBall()
	{
		for (int y = 0; y < height ; y++) 
        {
            for (int x = 0; x < width; x++) 
            {
            	if (mapRead[x][y] == 'C')
            	{
            		this.numberOfCrystallBall = this.numberOfCrystallBall + 1;
            	}
            }
        }
	}
	
	public void updateElementsOnMap(int x,int y)
	{
		this.mapRead[x][y] = 'N';
	}
	
	public void updateGateOnMap(int x,int y)
	{
		this.mapRead[x][y] = 'O';
	}
	
	public String getMap()
	{
        return map;
    }

    public void setMap(String map) 
    {
        this.map = map;
    }
    
	public static int getHeight() 
	{
		return height;
	}
	
	public static int getWidth() 
	{
		return width;
	}
	
	public Elements getBone() 
	{
		return Bone;
	}
	
	public Elements getH_Bone() 
	{
		return H_Bone;
	}
	
	public Elements getV_Bone() 
	{
		return V_Bone;
	}
	
	public Elements getNothing() 
	{
		return Nothing;
	}
	
	public Elements getCloseGate() 
	{
		return closeGate;
	}
		
	public void setCloseGate(Elements CloseGate_p)
	{
		this.closeGate = CloseGate_p;
	}
		
	public Elements getPurse() 
	{
		return purse;
	}

	public void setPurse(Elements purse) 
	{
		this.purse = purse;
	}
		
	public Elements getCrystallBall() 
	{
		return crystallBall;
	}

	public void setCrystallBall(Elements crystallBall) 
	{
		this.crystallBall = crystallBall;
	}
		
	public Elements getOpenGate() 
	{
		return OpenGate;
	}

	public void setOpenGate(Elements openGate) 
	{
		OpenGate = openGate;
	}
		
	public Lorann getLorann() 
	{
		return lorann;
	}
		
	public void setLorann(Lorann lorann_p)
	{
		this.lorann = lorann_p;
	}
		
	public int getNumberOfCrystallBall() 
	{
		return numberOfCrystallBall;
	}

	public void setNumberOfCrystallBall(int numberOfCrystallBall) 
	{
		this.numberOfCrystallBall = numberOfCrystallBall;
	}
		
	public int getScoreLorann() 
	{
		return scoreLorann;
	}

	public void setScoreLorann(int scoreLorann) 
	{
		this.scoreLorann = scoreLorann;
	}
	

}
