class Consumidor extends Thread {
    private Tuberia tuberia;

    public Consumidor( Tuberia t ) {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
        }

    public void run() {
        char c;

        // Consume 10 letras de la tubería
        for( int i=0; i < 10; i++ )
            {
            c = tuberia.recoger();
            // Imprime las letras retiradas
            System.out.println( "Recogido el caracter "+c );
            // Espera un poco antes de coger más letras
            try {
                sleep( (int)(Math.random() * 2000 ) );
            } catch( InterruptedException e ) {
                ;
                }
            }
        }
    }