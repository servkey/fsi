//Implementación del componente 
//Luis Gerardo Montané Jiménez

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import HolaApp.*;

public class HolaImpl extends HolaPOA {
  private static int x = 0;
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }
 
  public String saludar() {    
    return "\nHola :) -> " + (x++) + "\n";
  }
    
  public int sumar(int x, int y) {
    return x + y;
  }
}