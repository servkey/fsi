import java.io.*;
import java.net.*;

public class Cliente{
    public static void main(String[] args) {
      String servidor = "172.72.51.53";
      int puerto = 9096;
      try{
        Socket socket= new Socket (servidor,puerto);
        BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
	if (0==0)
		return;
	String c = "Saludos desde el cliente";
        out.println(c);
	String line = "";
	while  ((line = in.readLine()) != null){
		System.out.println(line);
		break;
	}
	socket.close();
      } catch (IOException e)
      {
       		System.out.println("Error en conexión!!!");
      }
      
    }
}