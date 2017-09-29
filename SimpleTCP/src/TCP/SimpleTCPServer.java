package TCP;

import java.io.*;
import java.net.*;

class SimpleTCPServer {
	public static void main(String argv[]) {
		// Declara o socket do servidor
		ServerSocket listenSocket;
		// Declara objetos necess�rios �s regras de neg�cio da aplica��o
		String msgRequisicao;
		String msgResposta;
		try {
			// Instancia o socket que vai escutar na porta 6789
			listenSocket = new ServerSocket(6789);
			System.out.println("Esperando conex�es");
			// Faz um loop para lidar com as requisi��es
			while (true) {
				// Instancia socket que lida com as requisi��es de UM cliente
				Socket connectionSocket = listenSocket.accept();
				// Instancia objeto que l� buffer de entrada
				DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
				// Instancia objeto que escreve no buffer de sa�da
				DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				// L� msg enviada pelo cliente
				msgRequisicao = inFromClient.readUTF();
				// Transforma a msg recebida
				msgResposta = msgRequisicao.toUpperCase() + '\n';
				// Escreve msg de resposta para o cliente
				outToClient.writeUTF(msgResposta);
				// Fecha o socket
				connectionSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}