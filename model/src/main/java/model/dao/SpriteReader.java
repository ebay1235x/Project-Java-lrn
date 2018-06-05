package model.dao;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * <h1>The SpriteReader class.</h1>
 * 
Rayan
Rayan
 *
 */
public class SpriteReader {
	public static final int SIZE = 0;
	private ArrayList<Image> sprites;
	private String path;

	/**
	 * 
	 * @param path
	 *            The path for the folder which contain the sprites
	 * @throws IOException
	 */
	public SpriteReader(String path) throws IOException {
		this.path = path;
		this.sprites = new ArrayList<Image>();
		this.generateImagesList();

	}

	/**
	 * Get images list from file system Add Images in ArrayList
	 * 
	 * @throws IOException
	 *             IO exception
	 */
	private void generateImagesList() throws IOException {
		File folder = new File(getClass().getClassLoader().getResource(path).getFile()).getAbsoluteFile();
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			sprites.add(ImageIO.read(listOfFiles[i].getAbsoluteFile()));
		}
	}

	/**
	 * 
	 * @return sprites The list of all the sprite for the component
	 */
	public ArrayList<Image> getSprites() {
		return sprites;
	}

}