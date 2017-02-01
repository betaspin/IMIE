package fr.imie.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiThreadTest {
	static Client client;
	static String response;
	static Boolean flag = true;
	static List<Client> clients = new ArrayList<>();
	static Integer i = 0;
	
	public static void main(String[] args) throws IOException {
		
		MultiThreadedServer server = new MultiThreadedServer(9000);
		
		new Thread(server).start();


		Scanner sc = new Scanner(System.in);
		
		while(flag){
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println("1 - Nouveau client");
			System.out.println("2 - Liste clients");
			System.out.println("3 - Fermer serveur");
			response = sc.nextLine();
			
			switch(response){
				case "1":
					client = new Client(i++);
					clients.add(client);
					break;
				case "2":
					for(Client client : clients){
						System.out.format("client %s\n", client.getNom());
					}
					break;
				case "3":
					server.stop();
					flag = false;
					break;
				default:
					break;
			}
		}
		
		sc.close();
	}
}
