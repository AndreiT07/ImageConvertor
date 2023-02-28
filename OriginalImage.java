//Aceasta clasa contine imaginea originala
//este ultimul nivel de mostenire
package packWork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OriginalImage extends Image{
	private BufferedImage img;
	private File f;
	
	public File getF() {
		return f;
	}
	public void setF(File f) {
		this.f = f;
	}
	public BufferedImage getImg() {
		return img;
	}
	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	public OriginalImage(){
		Image.setName(name);
		setWidth(0);
		setHeight(0);
		setImg(null);
		setF(null);
	}
	public OriginalImage(String name){
		setName(name);
		//setF(new File("C:/@Facultate/"+name));
		setF(new File(name));
		try {
			setImg(ImageIO.read(f));
			setWidth(img.getWidth());
			setHeight(img.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static{
		printName();
	}
	public static void printName(){
		System.out.println("Numele imaginii este "+name);
	}
	
}
	
