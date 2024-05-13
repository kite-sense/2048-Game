package controller;

import model.GridNumber;
import util.AdvancedFileUtil;
import view.GamePanel;

import javax.swing.*;
import java.util.List;


/**
 * This class is used for interactive with JButton in GameFrame.
 */
public class GameController {
    public static AdvancedFileUtil advancedFileUtil = new AdvancedFileUtil();
    private GamePanel view;
    private GridNumber model;


    public GameController(GamePanel view, GridNumber model) {
        this.view = view;
        this.model = model;

    }

    public void restartGame() {
        System.out.println("Do restart game here");
        model.firstInitialNumbers();
        view.updateGridsNumber();
        view.clearStep();
    }

    public void saveGame(String path) {
        List<String> lines = model.convertToList();
        lines.add(Integer.toString(view.getSteps()));
        advancedFileUtil.writeFileFromList(path, lines);
    }

    public int loadGame(String path) {
        List<String> lines = advancedFileUtil.convertFileToList(path);
        int step = model.convertToChessboard(lines);
        return step;
    }

    //todo: add other methods such as loadGame, saveGame...

}
