public class Programa{
	public static void main(String args[]){
		System.out.println("Hola clase!!");
		MiThread h1 = new MiThread("H1");
		MiThread h2 = new MiThread("H2");
		MiThread h3 = new MiThread("H3");
		MiThread h4 = new MiThread("H4");

		h1.start();
		h2.start();
		h3.start();
		h4.start();

		new Thread(new Runnable(){
			public void run(){
				System.out.println("Hola desde Run");
			}			
		}).start();

		Thread cpu1 = new Thread(new MiThreadRunnable());
		cpu1.start();
	}
}

class MiThreadRunnable implements Runnable
{
	public void run(){
		System.out.println("Hola desde Run1");
	}
}

class MiThread extends Thread
{
	public MiThread(String name){
		super(name);
	}
	
	public void run()
	{
		for (int i = 0; i < 10; i++){
			System.out.println(getName() + ", " + i);
		}
	}
}

