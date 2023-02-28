package packWork;

public class Buffer {
	private int number = -1;
	private boolean available = false;
	public synchronized int get() {
	while (!available) {
	try {
		wait();
		// Asteapta producatorul sa puna o valoare
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	available = false;
	notifyAll ();
	return number;
	}
	public synchronized void put (int number) {
		while (available) {
			try {
				wait();
	// Asteapta consumatorul sa preia valoarea
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
		this.number = number;
		available = true;
		notifyAll ();
	}

	
	
}
