import view.GameFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started.");
        Socket soc = new Socket(InetAddress.getByName("127.0.0.1"), 9805);
        BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        System.out.println(in.readLine());
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame(700, 500);
            gameFrame.setVisible(true);
        });
    }
}
