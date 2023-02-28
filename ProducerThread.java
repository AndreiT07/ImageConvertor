//Aceasta este clasa Producer pentru imagine
//in care se aloca un nou thread pentru citirea
//din fisierul sursa
package packWork;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ProducerThread extends Thread{
	private BufferedImage img;
	private Buffer buffer;
	private int width;
	private int height;
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	public ProducerThread(){
		super("");
	}
	public ProducerThread(String name, BufferedImage image){
		super(name);
		setImg(image);
	}
	
	public ProducerThread(String name, BufferedImage image, Buffer b,int h, int w){
		super(name);
		setImg(image);
		buffer = b;
		setHeight(h);
		setWidth(w);
	}
	
	//thread-ul intra in Not Runnable dupa
	//citirea a fiecarui sfert de informatie
	public void run(){
		long start = System.currentTimeMillis();
		OriginalImage.printName();
		for (int y = 0; y < img.getHeight(); y++) {
		for (int x = 0; x <  img.getWidth(); x++) {
			if((y == (height-1)/4) && (x == (width-1)/4)){
				System.out.println(super.getName()+" a parcurs primul sfert");//la parcurgerea fiecarui sfert
				try {															//output la consola si sleep(1000)
																				
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((y == (height-1)/2) && (x == (width-1)/2)){
				System.out.println(super.getName()+ " a parcurs al doilea sfert");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((y == (height-1)*3/4) && (x == (width-1)*3/4)){
				System.out.println(super.getName()+" a parcurs al treilea sfert");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((y == height-1) && (x == width-1)){
				System.out.println(super.getName()+" a parcurs al patrulea sfert");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			buffer.put(img.getRGB(x, y));//se pune valorea pixelului in buffer pentru
											//a fi prelucrat de consumer
			
		}
		}
		long end = System.currentTimeMillis();
		long timeElapsed = end - start;
		System.out.println(super.getName()+" a durat "+timeElapsed+" milisecunde"); //calculare timp executie
	}
}
