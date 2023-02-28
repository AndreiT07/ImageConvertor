//Aceasta este clasa Consumer pentru pipe
//si proceseaza noua imagine, dupa ce este primita toata informatia
package packWork;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WriteResult extends Thread {
	private DataInputStream in;
	private int height;
	private int width;
	private BufferedImage img2 = null;
	String fileName = null;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		fileName = fileName;
	}
	public WriteResult(DataInputStream in, int h, int w,String file,String name) {
		super(name);
		this.in = in;
		height = h;
		width = w;
		fileName = file;
	
		
	}
	public void run() {
		int [][] matrix = new int[height][width];//stocam intr-o matrice toti pixelii
		long start = System.currentTimeMillis();
		BufferedImage img2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);//creare noua imagine
		int value = 0;
		for (int y = 0; y < height; y++) {
		for (int x = 0; x < width; x++) { 
			try {
				value = in.readInt();//primire valoare pixel prin pipe
				int red = value;
		        int green = value;
		        int blue = value;
		        Color color = new Color(red, green, blue);  //crrez noua culoare rgb pentru fiecare pixel
		        matrix[y][x] = color.getRGB();
		        if((y == (height-1)/4) && (x == (width-1)/4)){//output la consola dupa ce primeste segmente
					System.out.println(super.getName()+" a primit primul sfert de la Consumer ");//
				}
				else if((y == (height-1)/2) && (x == (width-1)/2)){
					System.out.println(super.getName()+ " a primit al doilea sfert de la Consumer");
				}
				else if((y == (height-1)*3/4) && (x == (width-1)*3/4)){
					System.out.println(super.getName()+" a primit al treilea sfert de la Consumer");
				}
				else if((y == height-1) && (x == width-1)){
					System.out.println(super.getName()+" a primit al patrulea sfert de la Consumer");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}
			//dupa ce s-a primit toata informatia se incepe procesarea
			for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++){
				img2.setRGB(x, y, matrix[y][x]);
			    if((y == (height-1)/4) && (x == (width-1)/4)){//output la consola dupa ce scrie cate un segment
					System.out.println(super.getName()+" a scris primul sfert de informatie");
				}
				else if((y == (height-1)/2) && (x == (width-1)/2)){
					System.out.println(super.getName()+ " a scris al doilea sfert de informatie");
				}
				else if((y == (height-1)*3/4) && (x == (width-1)*3/4)){
					System.out.println(super.getName()+" a scris al treilea sfert de informatie");
				}
				else if((y == height-1) && (x == width-1)){
					System.out.println(super.getName()+" a scris al patrulea sfert de informatie");
				}
			}
			}
	
	try {
        
		//File f = new File("C:/@Facultate/"+fileName+".bmp");//se creeaza noul fisier, dupa nume trimis
		File f = new File(fileName+".bmp");//se creeaza noul fisier, dupa calea trimis
		ImageIO.write(img2, "bmp", f);//se scrie noua imagine
        System.out.println(super.getName()+" a scris imaginea");
    }
    catch (IOException e) {
        System.out.println(e);
    }
	long end = System.currentTimeMillis();
	long timeElapsed = end - start;
	System.out.println(super.getName()+" a durat "+timeElapsed+" milisecunde");
}

}
