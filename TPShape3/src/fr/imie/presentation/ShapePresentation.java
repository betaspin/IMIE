package fr.imie.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.imie.business.Circle;
import fr.imie.business.IShape;
import fr.imie.business.Polygon;
import fr.imie.business.Rectangle;
import fr.imie.business.Square;
import fr.imie.business.Triangle;

public class ShapePresentation {

	List<IShape> shapes = new ArrayList<>();

	public void start(){
		/*Rectangle rectangle = new Rectangle(10f, 10f);
		shapes.add(rectangle);
		this.printAreaOf(rectangle);
		this.printPerimeterOf(rectangle);

		Circle circle = new Circle(10f);
		shapes.add(circle);
		this.printAreaOf(circle);
		this.printPerimeterOf(circle);

		Square square = new Square(5f);
		shapes.add(square);
		this.printAreaOf(square);
		this.printPerimeterOf(square);
		
		Triangle triangle = null;
		try {
			triangle = new Triangle(5f, 10f, 20f);
		} catch (IllegalArgumentException e) {
			System.out.format("le triangle n'a pas pu etre créé : %S\n", e.getMessage());
		}
		if (triangle != null) {
			shapes.add(triangle);
			printAreaOf(triangle);
			printPerimeterOf(triangle);
		}

		Polygon polygon = new Polygon(10000, 10f);
		shapes.add(polygon);
		this.printAreaOf(polygon);
		this.printPerimeterOf(polygon);
		
		
		
		this.displayAreaSum();*/
		String response ="";
		
		do{
		
			System.out.println("Quel type de forme voulez vous créeer?");
			System.out.println("1 - Carré");
			System.out.println("2 - Rectangle");
			System.out.println("3 - Cercle");
			System.out.println("4 - Polygone régulier");
			System.out.println("5 - Triangle");
			System.out.println("X - Sortir");
			
			
			
			Scanner sc = new Scanner(System.in);
			response = sc.nextLine();
			if (response.equals("X")){
				break;
			}
			
			Integer choice = Integer.parseInt(response);
			String[] parametersLabel = null;
			Float[] params;
			IShape myShape= null;
			switch (choice) {
			case 1:
				parametersLabel= Square.getConstructorParameter();
				myShape = new Square();
				break;
			case 2:
				parametersLabel= Rectangle.getConstructorParameter();
				myShape = new Rectangle();
				break;
			case 3:
				parametersLabel= Circle.getConstructorParameter();
				myShape = new Circle();
				break;
			case 4:
				parametersLabel= Polygon.getConstructorParameter();
				myShape = new Polygon();
				break;
			case 5:
				parametersLabel= Triangle.getConstructorParameter();
				myShape = new Triangle();
				break;
			default:
				break;
			}
			
			params = typeParams(sc, parametersLabel);
			myShape.initialise(params);
			
			shapes.add(myShape);
			printAreaOf(myShape);
			printPerimeterOf(myShape);
		}
		while(!response.equals("X"));

		this.displayAreaSum();
		
	}

	private Float[] typeParams(Scanner sc, String[] parametersLabel) {
		String response;
		Float[] params = new Float[parametersLabel.length];
		Integer paramNum = 0;
		for (String parameter : parametersLabel) {
			System.out.format("saisir la valeur du paramètre %S\n", parameter);
			response = sc.nextLine();
			params[paramNum] = Float.parseFloat(response);
			paramNum++;
		}
		return params;
	}

	public void printAreaOf(IShape shape) {
		System.out.format("L'aire de mon %S est de %S\n", shape.getClass().getSimpleName(), shape.area());

	}

	public void printPerimeterOf(IShape shape) {
		System.out.format("Le périmètre de mon %S est de %S\n", shape.getClass().getSimpleName(), shape.perimeter());

	}

	private void displayAreaSum() {
		Float sum = 0f;
		for (IShape shape : shapes) {
			sum += shape.area();
		}
		System.out.format("La somme des aires est de %S\n", sum);

	}

}
