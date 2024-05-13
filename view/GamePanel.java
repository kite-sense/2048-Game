package view;

import model.GridNumber;
import util.AdvancedFileUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GamePanel extends ListenerPanel {
    private final int COUNT;
    private GridComponent[][] grids;
    private GridNumber model;
    private JLabel stepLabel;
    private int steps;
    private final int GRID_SIZE;

    public GamePanel(int size, int COUNT) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(size, size);
        this.COUNT = COUNT;
        this.GRID_SIZE = size / COUNT;
        this.grids = new GridComponent[COUNT][COUNT];
        this.model = new GridNumber(COUNT, COUNT);
        initialGame();

    }

    public GridNumber getModel() {
        return model;
    }


    public void initialGame() {
        this.steps = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = new GridComponent(i, j, model.getNumber(i, j), this.GRID_SIZE);
                grids[i][j].setLocation(j * GRID_SIZE, i * GRID_SIZE);
                this.add(grids[i][j]);
            }
        }
        model.printNumber();//check the 4*4 numbers in game
        this.repaint();
    }

    public void updateGridsNumber() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j].setNumber(model.getNumber(i, j));
            }
        }
        repaint();
    }


    /**
     * Implement the abstract method declared in ListenerPanel.
     * Do move right.
     */
    @Override
    public void doMoveRight() {
        System.out.println("Click VK_RIGHT");
        this.afterMove();
        this.model.moveRight();
        this.updateGridsNumber();
        loseCall(this.model.getNumbers());
        winCall(this.model.getNumbers());
    }

    @Override
    public void doMoveLeft() {
        System.out.println("Click VK_LEFT");
        this.afterMove();
        this.model.moveLeft();
        this.updateGridsNumber();
        loseCall(this.model.getNumbers());
        winCall(this.model.getNumbers());
    }

    @Override
    public void doMoveUP() {
        System.out.println("Click VK_UP");
        this.afterMove();
        this.model.moveUp();
        this.updateGridsNumber();
        loseCall(this.model.getNumbers());
        winCall(this.model.getNumbers());
    }

    @Override
    public void doMoveDown() {
        System.out.println("Click VK_Down");
        this.afterMove();
        this.model.moveDown();
        this.updateGridsNumber();
        loseCall(this.model.getNumbers());
        winCall(this.model.getNumbers());
    }

    private static void winCall(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == 2048) {
                    //terminate the game and show the victory board
                    JOptionPane.showMessageDialog(null, "VICTORY");
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private static void loseCall(int[][] numbers) {
        int zeroNum = 0;
        int equalNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                if (numbers[i][j] == 0) {
                    zeroNum++;
                }
            }
        }
        if (zeroNum == 0) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j <= numbers[0].length - 2; j++) {
                    if (numbers[i][j] == numbers[i][j + 1]) {
                        equalNum++;
                    }
                }
            }
//            int[][] transpose = transpose(numbers);
//            for (int i = 0; i < transpose.length; i++) {
//                for (int j = 0; j <= transpose[0].length - 2; j++) {
//                    if (numbers[i][j] == numbers[i][j + 1]) {
//                        equalNum++;
//                    }
//                }
//            }
            for (int i = 0; i < numbers[0].length; i++) {
                for (int j = 0; j <= numbers.length - 2; j++) {
                    if (numbers[j][i] == numbers[j + 1][i]) {
                        equalNum++;
                    }
                }
            }
            if (equalNum == 0) {
                //lose the game and terminate the game
                JOptionPane.showMessageDialog(null, "FAILURE");
                Thread.currentThread().interrupt();
            }
        }
    }

    private static int[][] transpose(int[][] define) {
        int[][] arr2 = new int[define[0].length][define.length];
        for (int i = 0; i < define[0].length; i++) {
            for (int j = 0; j < define.length; j++) {
                arr2[i][j] = define[j][i];
            }
        }
        return arr2;
    }

    public void clearStep() {
        this.steps = 0;
        this.stepLabel.setText(String.format("Step: %d", this.steps));
    }

    public void loadGameStep(int step) {
        this.steps = step;
        this.stepLabel.setText(String.format("Step: %d", this.steps));
    }

    public void afterMove() {
        this.steps++;
        this.stepLabel.setText(String.format("Step: %d", this.steps));
    }

    public int getSteps() {
        return steps;
    }

    public void setStepLabel(JLabel stepLabel) {
        this.stepLabel = stepLabel;
    }
}
