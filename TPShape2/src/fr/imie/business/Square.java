/**
 * 
 */
package fr.imie.business;

/**
 * @author imiedev
 *
 */
public class Square extends Rectangle {

	public Square(Float...args) {
		super(args[0], args[0]);
	}
	
	public static String[] getConstructorParameter(){
		String[] out = {"côté"};
		return out;
	}

}
