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
		
		System.out.println("Quel type de forme voulez vous créeer?");
		System.out.println("1 - Carré");
		System.out.println("2 - Rectangle");
		System.out.println("3 - Cercle");
		System.out.println("4 - Polygone régulier");
		System.out.println("5 - Triangle");
		
		Scanner sc = new Scanner(System.in);
		String response = sc.nextLine();
		Integer choice = Integer.parseInt(response);
		String[] parametersLabel = null;
		Float[] params;
		IShape myShape= null;
		switch (choice) {
		case 1:
			parametersLabel= Square.getConstructorParameter();
			params   = typeParams(sc, parametersLabel);
			myShape = new Square(params);
			break;
		case 2:
			parametersLabel= Rectangle.getConstructorParameter();
			params = typeParams(sc, parametersLabel);
			myShape = new Rectangle(params);
			break;
		case 3:
			parametersLabel= Circle.getConstructorParameter();
			params = typeParams(sc, parametersLabel);
			myShape = new Circle(params);
			break;
		case 4:
			parametersLabel= Polygon.getConstructorParameter();
			params = typeParams(sc, parametersLabel);
			myShape = new Polygon(params);
			break;
		case 5:
			parametersLabel= Triangle.getConstructorParameter();
			params = typeParams(sc, parametersLabel);
			myShape = new Triangle(params);
			break;

		default:
			break;
		}
		
		printAreaOf(myShape);
		printPerimeterOf(myShape);
		
	}

	private Float[] typeParams(Scanner sc, String[] parametersLabel) {
		String response;
		Float[] params = new Float[parametersLabel.length];
		Integer paramNum = 0;
		for (String parameter : parametersLabel) {
			System.out.format("saisir la valeur du paramètre %S\n",parameter);
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
	
	private void displayAreaSum(){
		Float sum=0f;
		for (IShape shape : shapes) {
			sum+=shape.area();
		}
		System.out.format("La somme des aires est de %S\n",sum);

	}
	
}
