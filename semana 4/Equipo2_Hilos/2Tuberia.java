class Tuberia {
    private char buffer[] = new char[6];
    private int siguiente = 0;
    // Flags para saber el estado del buffer
    private boolean estaLlena = false;
    private boolean estaVacia = true;

    // Método para retirar letras del buffer
    public synchronized char recoger() {
        // No se puede consumir si el buffer está vacío
        while( estaVacia == true )
            {
            try {
                wait(); // Se sale cuando estaVacia cambia a false
            } catch( InterruptedException e ) {
                ;
                }
            }
        // Decrementa la cuenta, ya que va a consumir una letra
        siguiente--;
        // Comprueba si se retiró la última letra
        if( siguiente == 0 )
            estaVacia = true;
        // El buffer no puede estar lleno, porque acabamos de consumir
        estaLlena = false;
        notify();

        // Devuelve la letra al thread consumidor
        return( buffer[siguiente] );
        }

    // Método para añadir letras al buffer
    public synchronized void lanzar( char c ) {
        // Espera hasta que haya sitio para otra letra
        while( estaLlena == true )
            {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch( InterruptedException e ) {
                ;
                }
            }
        // Añade una letra en el primer lugar disponible
        buffer[siguiente] = c;
        // Cambia al siguiente lugar disponible
        siguiente++;
        // Comprueba si el buffer está lleno
        if( siguiente == 6 )
            estaLlena = true;
        estaVacia = false;
        notify();
        }
    }