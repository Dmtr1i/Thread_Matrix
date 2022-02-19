package com.company;

public class MatrixMultiplicator implements Runnable {

    private int[][] ownMatrix1;
    private int[][] ownMatrix2;
    private int[][] multiplicateMatrix;
    private int size;
    private int line = -1;

    MatrixMultiplicator() {
        ownMatrix1 = ownMatrix2 = multiplicateMatrix = null;
    }

    MatrixMultiplicator(int[][] matrix1, int[][] matrix2) {
        ownMatrix1 = matrix1;
        ownMatrix2 = matrix2;
        size = ownMatrix1.length;
        multiplicateMatrix = new int[size][size];
    }

    public void printResult() {
        for (int i = 0; i < multiplicateMatrix.length; i++) {
            for (int j = 0; j < multiplicateMatrix.length; j++) {
                System.out.print(multiplicateMatrix[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    @Override
    public void run() {
        synchronized (this) {
            try { Thread.sleep(1); } catch (InterruptedException ex) {}
            line++;
        }
        int temp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temp += ownMatrix1[line][j] * ownMatrix2[j][i];
            }
            multiplicateMatrix[line][i] = temp;
            temp = 0;
        }
    }
}
