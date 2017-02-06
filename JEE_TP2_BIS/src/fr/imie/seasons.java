/**
 * 
 */
package fr.imie;

/**
 * @author imiedev
 *
 */
public enum seasons {
	Printemps("printemps.html"),
	Eté("ete.html"),
	Automne("automne.html"),
	Hiver("hiver.html");
	
	private final String url;
	
	seasons(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
}
