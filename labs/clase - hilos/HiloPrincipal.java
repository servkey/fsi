public class HiloPrincipal{
	public static void main(String args[]){
		Recurso r = new Recurso(10);
		Productor p1 = new Productor(r);
		Productor p2 = new Productor(r);
		Consumidor c1 = new Consumidor(r);

		p1.start();
		p2.start();
		c1.start();

		/*
		
		
		Thread cpu1 = new Thread(p1);
		cpu1.start();
		
		Thread cpu2 = new Thread(p2);
		cpu2.start();

		Thread cpu3 = new Thread(c1);
		cpu3.start();*/
	}
}