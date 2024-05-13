package Main;

import com.sun.source.tree.ImportTree;
import view.GameFrame;

import javax.swing.*;


public class MainThread extends Thread{
    @Override
    public void run() {
        String str1 = JOptionPane.showInputDialog("Enter the width or height");
        int count =Integer.parseInt(str1);
        JOptionPane.showMessageDialog(null, "start a "+count+"✖"+count+" game.");
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame(700, 500,count);
            gameFrame.setVisible(true);
        });
    }
}
