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
			DataInputStream salidaServidor = new DataInputStream(clientSocket.getInputStream());// Para poder leer con readInt()
			PrintWriter alServidor  = new PrintWriter(clientSocket.getOutputStream(),true);//  Para poder mandar el string leido al servidor
			String linea;
            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++)
            {
                //Se escribe en el servidor usando su flujo de datos
            	linea =JOptionPane.showInputDialog(null,"ingrese el valor del numero "+(i+1)) ;//obtiene los valores deseados
            	alServidor.println(linea);    //envia al servidor            
            } 
            
    		JOptionPane.showMessageDialog(null, salidaServidor.readInt());//se imprime el resultado
    		clientSocket.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    
		
		System.exit(0);

	}

}
