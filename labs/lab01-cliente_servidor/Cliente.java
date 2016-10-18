import java.io.*;
import java.net.*;

public class Cliente{
    public static void main(String[] args) {
	System.out.println("IP: " + args[0]);
	System.out.println("Puerto inicial: " + args[1]);
	System.out.println("Puerto final: " + args[2]);

       String servidor = args[0];
       int puerto = 9096;

	int puerto_inicial = Integer.parseInt(args[1]);
	int puerto_final = Integer.parseInt(args[2]);

      try{
	System.out.println("Antes del socket");
        Socket socket= new Socket (servidor,puerto);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

	String c = "Saludos desde el cliente en Java :)";
        out.println(c);
	String line = "";
	while  ((line = in.readLine()) != null){
		System.out.println(line);
		break;
	}

	System.out.println("Después del socket");
	socket.close();
      } catch (IOException e)
      {
       		System.out.println("Error en conexión al intentar con el puerto " + puerto  + "!!!");
      }
      
    }
}