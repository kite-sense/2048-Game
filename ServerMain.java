import view.GameFrame;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for clients...");
        ServerSocket ss=new ServerSocket(9805);
        Socket soc =ss.accept();
        System.out.println("Connection established");
        long current1 = System.currentTimeMillis();
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame(700, 500);
            gameFrame.setVisible(true);
        });
        long current2 = System.currentTimeMillis();
        double time = (current2-current1)/1000.0d;
        PrintWriter out= new PrintWriter(soc.getOutputStream(),true);
        out.printf("Your component has won the match with %.3f\n",time);
    }
}
