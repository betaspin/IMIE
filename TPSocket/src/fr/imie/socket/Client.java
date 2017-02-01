/**
 * 
 */
package fr.imie.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author imiedev
 *
 */
public class Client {
	private String nom;
	
	/**
	 * @param i 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client(Integer i) throws IOException {
		
		this.nom = "client".concat(String.valueOf(i));
		
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter printer = null;
		String s;

		
		try {
			socket = new Socket("127.0.0.1", 9000);

			printer = new PrintWriter(socket.getOutputStream(), true);
			printer.println("Connexion établie ?");
			printer.flush();
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			s = reader.readLine();
			System.out.println(s);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			reader.close();
			printer.close();			
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
