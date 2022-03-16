package com.company;
import java.lang.Math;

// class, that generate matrix in multithreading
public class MatrixGenerator implements Runnable {

    private int[][] ownMatrix;
    private int ownSize, ownRange, ownSign;

    MatrixGenerator() {
        ownMatrix = null;
        ownSize = 0;
        ownRange = 0;
        ownSign = 0;
    }

    MatrixGenerator(int size, int range, int sign) {
        ownMatrix = null;
        ownSize = size;
        ownRange = range;
        ownSign = sign;
    }

    //Method, that returns generated matrix
    public int[][] getMatrix() { return ownMatrix; }

    //Method, that generate matrix
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

    //Method, that print matrix
    public void print() {
        for (int i = 0; i < ownMatrix.length; i++) {
            for (int j = 0; j < ownMatrix.length; j++) {
                System.out.print(ownMatrix[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    @Override
    public void run() {
        generator(ownSize, ownRange, ownSign);
    }
}
