/**
 * 
 */
package fr.imie.main;

import fr.imie.business.Fourchette;
import fr.imie.business.Philosophe;

/**
 * @author imiedev
 *
 */
public class PhilosophesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fourchette f1 = new Fourchette("F1", true);
		Fourchette f2 = new Fourchette("F2", true);
		Fourchette f3 = new Fourchette("F3", true);
		Fourchette f4 = new Fourchette("F4", true);
		Fourchette f5 = new Fourchette("F5", true);
		Philosophe p1 = new Philosophe("P1", f1, f5, 5000, 1000);
		Philosophe p2 = new Philosophe("P2", f1, f2, 5000, 1000);
		Philosophe p3 = new Philosophe("P3", f2, f3, 5000, 1000);
		Philosophe p4 = new Philosophe("P4", f3, f4, 5000, 1000);
		Philosophe p5 = new Philosophe("P5", f4, f5, 5000, 1000);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}

}
