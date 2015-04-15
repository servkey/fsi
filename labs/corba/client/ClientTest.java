//Cliente CORBA 
//Luis Gerardo Montané Jiménez


import HolaApp.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.awt.event.*;

public class ClientTest extends JFrame
{
  static Hola holaImpl;
  private JTextField  txtIP = new JTextField(10);
  private JTextField  txtOp1 = new JTextField(10);
  private JTextField  txtOp2 = new JTextField(10);
  private JTextField  txtResultado = new JTextField(10);
  private JButton btn = new JButton("Sumar");

  public ClientTest(){	
	super();
	setTitle("Prueba de un cliente CORBA");
	setSize(800,100);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	JPanel pnl = new JPanel();
	add(pnl);

	pnl.add(new JLabel("IP"));
	txtIP.setText("127.0.0.1");
	pnl.add(txtIP);

	pnl.add(new JLabel("Núm1"));
	pnl.add(txtOp1);
	pnl.add(new JLabel("Núm2"));
	pnl.add(txtOp2);
	pnl.add(new JLabel("Resultado"));
	pnl.add(txtResultado);	

	btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			invocarComponente();
			int op1 = Integer.parseInt(txtOp1.getText());
			int op2 = Integer.parseInt(txtOp2.getText());
			txtResultado.setText(String.valueOf(holaImpl.sumar(op1,op2)));
		}
	});
	pnl.add(btn);
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
  }

  public void invocarComponente(){
      try{
        // crear e inicializar el ORB
	ClientTest.args[3] = txtIP.getText();
	ORB orb = ORB.init(ClientTest.args, null);

        // obtener la raiz del nombre del contexto
        org.omg.CORBA.Object objRef = 
	orb.resolve_initial_references("NameService");
        // Usar NamingContextExt para instanciar NamingContext. Esto es parte de la interoperabilidad del servicio de nombres.
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		
        // resolver la referencia del objeto con el nombre
        String name = "Hola";
        holaImpl = HolaHelper.narrow(ncRef.resolve_str(name));
	System.out.println(holaImpl.saludar());
      }catch (Exception e) {
         System.out.println("ERROR : " + e) ;
	 e.printStackTrace(System.out);
      }
  }

  static String args[];
  public static void main(String args[])
    {
	ClientTest.args = args;
	ClientTest c =  new ClientTest();

	c.setVisible(true);	
	//System.out.println(holaImpl.saludar());
        //System.out.println("Suma 3+4 = " + holaImpl.sumar(3,4));
        
    }

}

