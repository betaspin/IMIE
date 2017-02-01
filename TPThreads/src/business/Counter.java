/**
 * 
 */
package business;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author imiedev
 *
 */
public class Counter extends Thread {
	private String nom;
	private Integer max;
	static Integer position = 0;
	
	public Counter(String nom, Integer max){
		this.nom = nom;
		this.max = max;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
	
	public void run(){
		Integer i = 1;
		while(i <= this.max){
			System.out.format("Thread %s : %s\n", this.getNom(), i);
			i++;
			synchronized(this){
				Integer pause = ThreadLocalRandom.current().nextInt(0, 2000 + 1);
				try {
					wait(pause);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		position++;
		System.out.format("Thread %s : Terminé en position %s\n", this.getNom(), position);		
	}
}
