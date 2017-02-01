/**
 * 
 */
package fr.imie.business;


/**
 * @author imiedev
 *
 */
public class Philosophe extends Thread {
	private String nom;
	private Fourchette f1;
	private Fourchette f2;
	private Integer t1;
	private Integer t2;
	
	public Philosophe(String nom, Fourchette f1, Fourchette f2, Integer t1, Integer t2) {
		super();
		this.nom = nom;
		this.f1 = f1;
		this.f2 = f2;
		this.t1 = t1;
		this.t2 = t2;
	}

	public void run(){
		Boolean fini = false;
		while(!fini){
			System.out.format("%s attend de pouvoir manger !!!\n", this.getNom());
			f1.prendreFourchette();
			f2.prendreFourchette();
			System.out.format("%s mange !!!\n", this.getNom());
			try {
				Thread.sleep(t1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			f1.deposerFourchette();
			f2.deposerFourchette();
			System.out.format("%s a fini de manger !!!\n", this.getNom());
			fini = true;
		}
		run();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Fourchette getF1() {
		return f1;
	}

	public void setF1(Fourchette f1) {
		this.f1 = f1;
	}

	public Fourchette getF2() {
		return f2;
	}

	public void setF2(Fourchette f2) {
		this.f2 = f2;
	}

	public Integer getT1() {
		return t1;
	}

	public void setT1(Integer t1) {
		this.t1 = t1;
	}

	public Integer getT2() {
		return t2;
	}

	public void setT2(Integer t2) {
		this.t2 = t2;
	}
	
}
