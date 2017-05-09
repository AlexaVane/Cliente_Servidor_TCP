package ec.edu.epn.redes.cs.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class servidorSum {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = new ServerSocket(9000);
		System.out.println("Server listening on port "+9000);
		Socket socket = serverSocket.accept();
		DataOutputStream salidaCliente = new DataOutputStream(socket.getOutputStream());
		BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String mensajeServidor;
		int a=0, i=0;

		for(i=0; i<2; i++){
			mensajeServidor=entrada.readLine();
			a+=Integer.parseInt(mensajeServidor);
		}
		salidaCliente.writeInt(a);
		System.out.println("Fin de la conexión");

		//Se finaliza la conexión con el cliente

		socket.close();
		serverSocket.close();


	}
}
