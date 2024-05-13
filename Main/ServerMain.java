package Main;

import Main.ServerThread;

import java.io.IOException;

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
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1000; k++) {
                    a=a+i;
                }
            }
        }
        long current2 = System.currentTimeMillis();
        time = (current2 - current1) ;
//        time = (current2 - current1) / 1000.0d;
    }

    public static double getTime() {
        return time;
    }
}
