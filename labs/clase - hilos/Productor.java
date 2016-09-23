public class Productor extends Thread{
	private Recurso recurso;

	public Productor(Recurso recurso){
		this.recurso = recurso;
	}
	public void run(){
		while(true){
			recurso.meter();
			try{
				Thread.sleep(700);
			}catch(Exception e){
				System.out.println("Ocurrió un error: " + e);
			}
		}	
	}
}

