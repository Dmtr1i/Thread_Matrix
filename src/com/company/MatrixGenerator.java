package com.company;

import java.lang.Math;

public class MatrixGenerator implements Runnable {

    public int[][] ownMatrix;
    public int ownSize, ownRange, ownSign;

    MatrixGenerator() {
        ownMatrix = null;
        ownSize = 0;
        ownRange = 0;
        ownSign = 0;
    }

    public void setParameters(int size, int range, int sign) {
        ownSize = size;
        ownRange = range;
        ownSign = sign;
    }

    public int[][] getMatrix() { return ownMatrix; }

    private void generator(int size, int range, int sign) {
        int [][] matrix = new int[size][size];
        if (sign == 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = (int)(Math.random() * range);
                }
            }
        } else if (sign == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = (int)(Math.random() * range - range / 2);
                }
            }
        }
        ownMatrix = matrix;
    }

    public void print() {
        for (int i = 0; i < ownMatrix.length; i++) {
            for (int j = 0; j < ownMatrix.length; j++) {
                System.out.print(ownMatrix[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    @Override
    public void run() {
        generator(ownSize, ownRange, ownSign);
        //print();
    }
}
