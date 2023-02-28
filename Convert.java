package packTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import packWork.Buffer;
import packWork.ChooseFile;
import packWork.ConsumerThread;
import packWork.OriginalImage;
import packWork.ProducerThread;
import packWork.ReadFileName;
import packWork.WriteResult;

public class Convert{

	public static void main(String[] args) {
		ChooseFile choose = new ChooseFile();
		choose.setVisible(true);
		//ReadFileName readIn = new ReadFileName();
		ReadFileName readOut = new ReadFileName();
		//readIn.Read("de intrare"); //citeste numele fisierului de intrare
		readOut.Read("de iesire"); //citeste numele fisierului de iesire
	//OriginalImage img_orig = new OriginalImage(readIn.getFileName());//instantiez clasa pentru imaginea originala
		//String a = choose.getNume();
	OriginalImage img_orig = new OriginalImage(choose.getNume());
		Buffer b = new Buffer();
		ProducerThread prod = new ProducerThread("ProducerImage",img_orig.getImg(),b,img_orig.getImg().getHeight(),img_orig.getImg().getWidth());
		//ConsumerThread consum = new ConsumerThread("consumer",img_orig.getWidth(),img_orig.getHeight(),b,img_orig.getImg());
		prod.start();
		//consum.start();	
		try {
			PipedOutputStream pipeOut = new PipedOutputStream();
			PipedInputStream pipeIn = new PipedInputStream(pipeOut);
			DataOutputStream out = new DataOutputStream(pipeOut);
			DataInputStream in = new DataInputStream(pipeIn);
			ConsumerThread c1 = new ConsumerThread("ConsumerImage",img_orig.getWidth(),img_orig.getHeight(),b,img_orig.getImg(),out);
			WriteResult wr = new WriteResult(in,img_orig.getImg().getHeight(),img_orig.getImg().getWidth(),readOut.getFileName(),"WriteResult");
			c1.start();
			wr.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
    }
	
	
	}


