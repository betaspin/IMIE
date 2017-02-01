/**
 * 
 */
package fr.imie.main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author imiedev
 *
 */
public class InetAdressGetLocalHostMain {

	public static void main(String[] args) throws UnknownHostException {

		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Iniquer l'url d'un site internet:");
		String url = sc.nextLine();
		
		InetAddress localIP = InetAddress.getByName(url);
		System. out.format("Adresse IP : %s, Nom du serveur : %s, ", localIP.getHostAddress());
		System. out.println(localIP.getHostName());
		System. out.println(localIP.getCanonicalHostName ());
		System. out.println(localIP.getAddress());
	}

}
