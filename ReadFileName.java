//Clasa pentru citire nume fisier
package packWork;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileName implements ReadInterface {//implementeaza o interfata
	private String fileName;
	private BufferedImage img;
	
	public  String getFileName() {
		return fileName;
	}
	
	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void Read(String scop){
		BufferedReader stdin = new BufferedReader(
		new InputStreamReader(System.in));
		System.out.print("Introduceti calea fisierului "+scop+":");
		
		try {
			fileName = stdin.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
}
