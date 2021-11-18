package echo_server.server;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Server started...");
            while (true) {
                try (Socket socket = server.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
                ) {
                    System.out.println("Client " + socket.getInetAddress() + " connected");
                    String request = reader.readLine();
                    String response = String.format("Your message is %s", request);
                    System.out.println(response);
                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
