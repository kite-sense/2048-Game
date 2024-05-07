package Server;

import view.GameFrame;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    private static double time = 0;

    public static void main(String[] args) throws IOException {
        var serverThread = new ServerThread();
        serverThread.start();
        long current1 = System.currentTimeMillis();
//        SwingUtilities.invokeLater(() -> {
//            GameFrame gameFrame = new GameFrame(700, 500);
//            gameFrame.setVisible(true);
//        });
        int a=0;
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 100000; j++) {
                a=a+i;
            }
        }
        long current2 = System.currentTimeMillis();
        time = (current2 - current1) / 1000.0d;
    }

    public static double getTime() {
        return time;
    }
}
