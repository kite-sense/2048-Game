package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    @Override
    public void run() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(9805);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Waiting for clients...");
        Socket soc;
        try {
            soc = ss.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connection established");
        PrintWriter out = null;
        try {
            out = new PrintWriter(soc.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(true){
            if(ServerMain.getTime()!=0){
                out.printf("Your component has won the match with %.3f seconds.\n",ServerMain.getTime());
                break;
            }
        }
    }
}
