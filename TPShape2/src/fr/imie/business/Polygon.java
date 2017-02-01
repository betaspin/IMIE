/**
 * 
 */
package fr.imie.business;

/**
 * @author imiedev
 *
 */
public class Polygon implements IShape {
	
	private final Integer sideCount;
	//private final Float radius;
	private final Float side;
	private final Triangle triangle;
	
	public Polygon(Float...args) {
		super();
		this.sideCount = args[0].intValue();
		Float radius = args[1];
		this.side = new Float(2*radius*Math.sin(Math.PI/sideCount));
		this.triangle = new Triangle(side, radius, radius);
	}
	
	public static String[] getConstructorParameter(){
		String[] out = {"nb de côté","rayon"};
		return out;
	}

	@Override
	public Float area() {
		return this.sideCount*this.triangle.area();
	}

	@Override
	public Float perimeter() {
		return this.side*this.sideCount;
	}
	
	
	
	

}
