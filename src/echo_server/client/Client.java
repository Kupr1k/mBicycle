package echo_server.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8000);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            Thread.sleep(1000);
            writer.write("I'm client");
            writer.newLine();
            writer.flush();
            String response = reader.readLine();
            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
