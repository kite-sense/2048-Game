package model;

import java.util.Arrays;
import java.util.Random;

public class GridNumber {
    private final int X_COUNT;
    private final int Y_COUNT;

    private int[][] numbers;

    private int mergeNum;

    static Random random = new Random();

    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.firstInitialNumbers();
        this.mergeNum = 0;
    }

    public void firstInitialNumbers() {
        int ran1;
        int ran2;
        int ran1Row;
        int ran1Col;
        int ran2Row;
        int ran2Col;
        ran1 = random.nextInt(X_COUNT * Y_COUNT);
        ran2 = random.nextInt(X_COUNT * Y_COUNT);
        while (true) {
            if (ran1 != ran2) {
                break;
            }
            ran2 = random.nextInt(X_COUNT * Y_COUNT);
        }
        ran1Row = ran1 / Y_COUNT;
        ran1Col = ran1 % Y_COUNT;
        ran2Row = ran2 / Y_COUNT;
        ran2Col = ran2 % Y_COUNT;
        numbers[ran1Row][ran1Col] = 2;
        numbers[ran2Row][ran2Col] = 4;
    }


    //todo: finish the method of four direction moving.
    public void moveRight() {
        numToRight(numbers);
        //叠加操作
        for (int i = 0; i < numbers.length; i++) {
            for (int j = Y_COUNT - 2; j >= 0; j -= 2) {
                if (numbers[i][j] == 0) {
                    break;
                }
                if (j > 0) {
                    if (numbers[i][j + 1] == numbers[i][j] && numbers[i][j] != 0) {
                        numbers[i][j + 1] *= 2;
                        numbers[i][j] = 0;
                        mergeNum++;
                    }
                    if (numbers[i][j - 1] == numbers[i][j] && numbers[i][j] != 0) {
                        numbers[i][j] *= 2;
                        numbers[i][j - 1] = 0;
                        mergeNum++;
                    }
                }
                if (j == 0) {
                    if (numbers[i][j + 1] == numbers[i][j] && numbers[i][j] != 0) {
                        numbers[i][j + 1] *= 2;
                        numbers[i][j] = 0;
                        mergeNum++;
                    }
                }
            }
        }
        numToRight(numbers);
        generate2or4();
        System.out.printf("Merge Numbers: %d\n", mergeNum);
    }

    private static void numToRight(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers[0].length - 2; j >= 0; j--) {
                for (int k = 0; k < numbers[0].length - 1 - j; k++) {
                    if (numbers[i][j + k + 1] == 0) {
                        numbers[i][j + k + 1] = numbers[i][j + k];
                        numbers[i][j + k] = 0;
                    }
                }
            }
        }
    }

    public void moveLeft() {
        int[][] middleMat1 = new int[X_COUNT][Y_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                middleMat1[i][j] = numbers[X_COUNT - 1 - i][Y_COUNT - 1 - j];
            }
        }
        numbers = middleMat1;
        moveRight();
        int[][] middleMat2 = new int[X_COUNT][Y_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                middleMat2[i][j] = numbers[X_COUNT - 1 - i][Y_COUNT - 1 - j];
            }
        }
        numbers = middleMat2;
    }


    public void moveUp() {
        int[][] middleMat1 = new int[Y_COUNT][X_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                middleMat1[i][j] = numbers[Y_COUNT - 1 - j][i];
            }
        }
        numbers = middleMat1;
        moveRight();
        int[][] middleMat2 = new int[X_COUNT][Y_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                middleMat2[i][j] = numbers[j][Y_COUNT - 1 - i];
            }
        }
        numbers = middleMat2;
    }


    public void moveDown() {
        int[][] middleMat1 = new int[Y_COUNT][X_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                middleMat1[i][j] = numbers[j][X_COUNT - 1 - i];
            }
        }
        numbers = middleMat1;
        moveRight();
        int[][] middleMat2 = new int[X_COUNT][Y_COUNT];
        for (int i = 0; i < X_COUNT; i++) {
            for (int j = 0; j < Y_COUNT; j++) {
                middleMat2[i][j] = numbers[X_COUNT - 1 - j][i];
            }
        }
        numbers = middleMat2;
    }


    public void generate2or4() {
        int ran;
        int ran2;
        int gridNum = 1;
        int zeroNum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == 0) {
                    zeroNum++;
                }
            }
        }
        ran = random.nextInt(zeroNum) + 1;
        ran2 = random.nextInt(5);
        outer:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == 0) {
                    if (gridNum == ran) {
                        if (ran2 == 0) {
                            numbers[i][j] = 4;
                        } else {
                            numbers[i][j] = 2;
                        }
                        break outer;
                    } else {
                        gridNum++;
                    }
                }
            }
        }
    }

    public int getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void printNumber() {
        for (int[] line : numbers) {
            System.out.println(Arrays.toString(line));
        }
    }
}
