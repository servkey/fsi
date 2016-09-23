public class Recurso{
	private int x;

	public final int CAPACIDAD_MAX = 20;

	public Recurso(int x){
		this.x = x;
	}

	public synchronized void meter(){		
		try{
			while (x == CAPACIDAD_MAX){
				System.out.println("El recurso está saturado: " + x);
				wait();
			}
			x++;
			notify();
			System.out.println("Incrementando recurso en 1, total = " + x);
		}catch(Exception e){
		}
	}

	public synchronized void sacar(){
		try{
			while (x == 0){
				System.out.println("El recurso está vacio: " + x);			
				wait();
			}
			x--;
			notify();
			System.out.println("Decrementando recurso en 1, total = " + x);			
		}catch(Exception e){

		}
	}
}