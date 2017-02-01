/**
 * 
 */
package main;

import business.Counter;

/**
 * @author imiedev
 *
 */
public class MainThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter counter1 = new Counter("Th1", 20);
		Counter counter2 = new Counter("Th2", 10);
		Counter counter3 = new Counter("Th3", 5);
		counter1.start();
		counter2.start();		
		counter3.start();
	}

}
