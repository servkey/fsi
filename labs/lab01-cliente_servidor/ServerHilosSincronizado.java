import java.net.*;
import java.io.*;
import java.lang.management.*;


class HiloCliente extends Thread
{
	private Socket socketCliente;
	private String resultado;
	private boolean finalizado;

	public boolean isFinalizado(){
		return finalizado;
	}

	public String getResultado(){
		return resultado;
	}
	

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
			    resultado = entrada;
			    finalizado = true;
	        	    return;
			} 
			socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	
	}
}


public class ServerHilosSincronizado{

public static void main(String args[]) throws InterruptedException{
		try {
			//Solo existiran tres clientes, cada hilo atenderá a un cliente
			HiloCliente hilosClientes[] = new HiloCliente[3];

			int puerto = 9096;

			ServerSocket s = new ServerSocket(puerto);
			System.out.println("Servidor iniciado en el puerto " + puerto + "...");	
			int i = 0;
			while(true){
				System.out.println("*****Escuchando conexión.....***"); 
				Socket s1 = s.accept(); 
				
				System.out.println("*****Aceptando conexión de: " + s1.getInetAddress().getHostAddress() + "******"); 
				HiloCliente hc = new HiloCliente(s1.getInetAddress().getHostAddress(), s1);    
				hc.start();
				hilosClientes[i++] = hc;			
				if (i > hilosClientes.length - 1){
					System.out.println("Saliendo....");
					break;
				}
			}

			//Esperar a que termine la ejecución de los hilos clientes (tres)
			for(int j = 0; j < hilosClientes.length; j++){	
				hilosClientes[j].join();
			}
			
			for(int j = 0; j < hilosClientes.length; j++){	
				System.out.println("Hilo: [" + hilosClientes[j].getName() + "] = " + hilosClientes[j].getResultado());			
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}


}