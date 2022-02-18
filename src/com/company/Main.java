package com.company;

//import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        MatrixGenerator matrixA = new MatrixGenerator();
        matrixA.setParameters(10, 100, 0);
        MatrixGenerator matrixB = new MatrixGenerator();
        matrixB.setParameters(10, 100, 0);
        Thread a = new Thread(matrixA);
        Thread b = new Thread(matrixB);
        a.start();
        b.start();
        //try{ a.join(); } catch(InterruptedException e) { System.out.println("Error in join thread a"); }
        //try{ b.join(); } catch(InterruptedException e) { System.out.println("Error in join thread b"); }
    }
}
