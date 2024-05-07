package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientThread extends Thread{
    @Override
    public void run() {
        System.out.println("Client started.");
        Socket soc = null;
        try {
            soc = new Socket(InetAddress.getByName("127.0.0.1"), 9805);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
