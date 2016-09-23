public class Consumidor extends Thread{
	private Recurso recurso;

	public Consumidor(Recurso recurso){
		this.recurso = recurso;
	}

	public void run(){
		while(true){
			recurso.sacar();
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("Ocurrió un error: " + e);
			}
		}	
	}
}
