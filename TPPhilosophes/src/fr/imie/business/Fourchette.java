/**
 * 
 */
package fr.imie.business;

/**
 * @author imiedev
 *
 */
public class Fourchette {
	
	private String name;
	private Boolean free;

	public Fourchette(String name, Boolean free) {
		super();
		this.free = free;
		this.name = name;
	}
	
	public synchronized void prendreFourchette(){
		while(!this.free){
			try {
				wait(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.free = false;
	}
	
	public synchronized void deposerFourchette(){
		this.free = true;
		notifyAll();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFree() {
		return free;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}	
}
