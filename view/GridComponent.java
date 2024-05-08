package view;

import util.ColorMap;

import javax.swing.*;
import java.awt.*;

public class GridComponent extends JComponent {
    private int row;
    private int col;
    private int number;
    static Font font = new Font("Serif", Font.BOLD, 42);

    public GridComponent(int row, int col, int gridSize) {
        this.setSize(gridSize, gridSize);
        this.row = row;
        this.col = col;
        this.number = 0;
    }

    public GridComponent(int row, int col, int number, int gridSize) {
        this.setSize(gridSize, gridSize);
        this.row = row;
        this.col = col;
        this.number = number;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        FontMetrics metrics;
        int textWidth;
        int x;
        int y;
        switch (number){
            case 0:
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                break;
            case 2:
                g.setColor(new Color(235,232,225));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.BLACK);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 4:
                g.setColor(new Color(237,221,175));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.BLACK);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 8:
                g.setColor(new Color(227,176,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 16:
                g.setColor(new Color(227,127,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 32:
                g.setColor(new Color(227,100,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 64:
                g.setColor(new Color(227,45,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 128:
                g.setColor(new Color(227,203,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 256:
                g.setColor(new Color(218,227,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 512:
                g.setColor(new Color(185,227,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 1024:
                g.setColor(new Color(145,227,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
            case 2048:
                g.setColor(new Color(76,227,45));
                g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
                g.setColor(Color.WHITE);
                g.setFont(font);
                metrics = g.getFontMetrics(g.getFont());
                textWidth = metrics.stringWidth(String.valueOf(number));
                x = (getWidth() - textWidth) / 2;
                y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
                g.drawString(String.valueOf(number), x, y);
                break;
        }

//        if (number > 0) {
//            g.setColor(Color.white);
//            g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
//            g.setColor(ColorMap.getColor(number));
//            g.setFont(font);
//            FontMetrics metrics = g.getFontMetrics(g.getFont());
//            int textWidth = metrics.stringWidth(String.valueOf(number));
//            int x = (getWidth() - textWidth) / 2;
//            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
//            g.drawString(String.valueOf(number), x, y);
//        } else {
//            g.setColor(Color.LIGHT_GRAY);
//            g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
//        }
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
