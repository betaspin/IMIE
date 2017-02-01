/**
 * 
 */
package fr.imie.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author imiedev
 *
 */
public class Worker extends Thread{
	
	private Socket socket = null;
	private BufferedReader reader = null;
	private PrintWriter printer = null;
	private String s;
	
	public Worker(Socket socket) throws IOException{
		this.socket = socket;
	}
	
	public void run() {
        try {
        	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			s = reader.readLine();
			System.out.println(s);
			
			printer = new PrintWriter(socket.getOutputStream(), true);
			printer.println("Connexion établie !!!");
			printer.flush();
			
			reader.close();
			printer.close();
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}
