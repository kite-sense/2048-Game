package Client;

import view.GameFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        var clientThread = new ClientThread();
        clientThread.start();
//        SwingUtilities.invokeLater(() -> {
//            GameFrame gameFrame = new GameFrame(700, 500);
//            gameFrame.setVisible(true);
//        });
    }
}
