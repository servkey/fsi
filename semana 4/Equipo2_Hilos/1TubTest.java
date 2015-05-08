class TubTest extends java.applet.Applet{
    public static void main( String args[] ) {
        Tuberia t = new Tuberia();
        Productor p = new Productor( t );
        Consumidor c = new Consumidor( t );

        p.start();
        c.start();
        }
    }