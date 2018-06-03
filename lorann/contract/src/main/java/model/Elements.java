package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import showboard.ISquare;

public class Elements implements ISquare
{
	
	public Image img_ob;
	public String nameFile;
	
	public Elements(final String nameFile)
	{
		this.setImageName(nameFile);
	}
	@Override
    public final Image getImage() 
	{
        return this.img_ob;
    }

    /* Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public final void loadImage() throws IOException 
    {
        this.setImage(ImageIO.read(new File("Ressources/images" + this.getImageName())));
    }

    /* Sets the image.
    *
     * @param image the new image
     */
    protected void setImage(final Image image) 
    {
        this.img_ob = image;
    }

    /* Gets the image name.
     *
     * @return the image name
     */
    protected String getImageName() 
    {
        return this.nameFile;
    }

    /* Sets the image name.
     *
     * @param imageName the imageName to set
     */
    protected void setImageName(final String imageName) {
        this.nameFile = imageName;
    }
}