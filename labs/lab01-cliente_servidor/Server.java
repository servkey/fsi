import java.net.*;
import java.io.*;
import java.lang.management.*;


class HiloCliente extends Thread
{
	private Socket socketCliente;
	
	public HiloCliente(String name, Socket socketCliente){
		super(name);
		this.socketCliente = socketCliente;
	}
	
	public void run()
	{
		String comandoSalir = "Exit";
		String entrada = "";

		try{
  			System.out.println("Atendiendo al cliente...:" + getName() +  "IP: " + socketCliente.getInetAddress().getHostAddress());
			PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

			while ((entrada = in.readLine()) != null) {					
			    System.out.println("Cliente: [" + socketCliente.getInetAddress().getHostAddress() + "]");
			    System.out.println(entrada);
		    	    String pathDesktop = System.getProperty("user.home") + "\\Desktop\\";
			    out.println("Hola desde el servidor!! -> " + pathDesktop);
			    out.println("");
			    if (entrada.trim().equals(comandoSalir))
		        	return;
			} 
			socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	
	}
}


public class Server{

public static void main(String args[]){
		try {

			int puerto = 9096;

			ServerSocket s = new ServerSocket(puerto);
			System.out.println("Servidor iniciado en el puerto " + puerto + "...");
			while(true){
				System.out.println("*****Escuchando conexión.....***"); 
				Socket s1 = s.accept(); 
				System.out.println("*****Aceptando conexión de: " + s1.getInetAddress().getHostAddress() + "******"); 
				HiloCliente hc = new HiloCliente("test", s1);    
				hc.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


}