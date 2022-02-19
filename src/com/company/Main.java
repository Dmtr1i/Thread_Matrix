package com.company;

public class Main {

    public static void main(String[] args) {
        MatrixGenerator matrixA = new MatrixGenerator();
        matrixA.setParameters(100, 10, 0);
        MatrixGenerator matrixB = new MatrixGenerator();
        matrixB.setParameters(100, 10, 0);
        Thread a = new Thread(matrixA);
        Thread b = new Thread(matrixB);
        a.start();
        b.start();
        try{ a.join(); } catch(InterruptedException e) { System.out.println("Error in join thread a"); }
        try{ b.join(); } catch(InterruptedException e) { System.out.println("Error in join thread b"); }
        matrixA.print();
        matrixB.print();
        MatrixMultiplicator multiply = new MatrixMultiplicator(matrixA.getMatrix(), matrixB.getMatrix());
        for (int i = 0; i < matrixA.getMatrix().length; i++) {
            Thread k = new Thread(multiply);
            k.start();
            try{ k.join(); } catch(InterruptedException e) { System.out.println("Error in multiplicate matrix"); }
        }
        multiply.printResult();
    }
}
