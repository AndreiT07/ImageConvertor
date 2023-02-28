//Aceasta este clasa Consumer pentru imagine
//dar si Clasa Produce pentru pipe deoarece trimite informatia prin pipe catre WriteResult
package packWork;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ConsumerThread extends Thread{
	private Buffer buffer;
	private int height;
	private int width;
	private DataOutputStream out;
	

	private BufferedImage img2 = null;
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public ConsumerThread(){
		
	}
	public ConsumerThread(String name, int w, int h, Buffer b, BufferedImage image,DataOutputStream out){
		super(name);
		setHeight(h);
		setWidth(w);
		buffer = b;
		this.out = out;
		
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		BufferedImage img2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int p;
		
		
		for (int y = 0; y < getHeight(); y++) {
		for (int x = 0; x < getWidth(); x++) {
			p = buffer.get();//se ia pixelul din buffer
			Color color = new Color(p, true);//pentru a stoca valoarea rgb a fiecarui pixel
            int red = color.getRed();// valoarea red a pixelului
            int green = color.getGreen();//valoarea green
            int blue = color.getBlue();//valoarea blue
            int value = (int) (red* 0.2126 + 0.7152 * green + 0.0722 * blue); //calculare valoare noua pentru r,g,b
            if((y == (height-1)/4) && (x == (width-1)/4)){//primeste primul sfert de informatie de la Producer
				System.out.println(super.getName()+" a trimis primul sfert catre WriteResult ");//si il trimitre catre WriteResult
			}
			else if((y == (height-1)/2) && (x == (width-1)/2)){
				System.out.println(super.getName()+ " a trimis al doilea sfert catre WriteResult");
			}
			else if((y == (height-1)*3/4) && (x == (width-1)*3/4)){
				System.out.println(super.getName()+" a trimis al treilea sfert catre WriteResult");
			}
			else if((y == height-1) && (x == width-1)){
				System.out.println(super.getName()+" a trimis al patrulea sfert catre WriteResult");
			}
            try {
            	out.writeInt(value);//trimite noua valoare a pixelului catre WriteResult prin pipe
            	} catch (IOException e) {
            	e.printStackTrace ();
            	}
    }
	}
	long end = System.currentTimeMillis();
	long timeElapsed = end - start;//calculare timp executie
	System.out.println(super.getName()+" a durat "+timeElapsed+" milisecunde");
			
		}
}
