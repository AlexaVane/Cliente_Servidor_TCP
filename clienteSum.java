package ec.edu.epn.redes.cs.tcp;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

public class clienteSum {
	

	public static void main(String[] args) throws IOException{
		Socket clientSocket = new Socket("localhost",9000);
		try
        {            
            //Flujo de datos hacia el servidor
			DataInputStream salidaServidor = new DataInputStream(clientSocket.getInputStream());
			PrintWriter alServidor  = new PrintWriter(clientSocket.getOutputStream(),true);
			String linea;
            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
            	linea =JOptionPane.showInputDialog(null,"ingrese el valor del numero "+(i+1)) ;
            	alServidor.println(linea);                
            } 
            
    		JOptionPane.showMessageDialog(null, salidaServidor.readInt());
    		clientSocket.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    
		
		System.exit(0);

	}

}
