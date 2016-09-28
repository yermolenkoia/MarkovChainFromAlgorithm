package model;

public class MatrixMultiple {
    private int [][] firstMatrix;
    private int [][] secondMatrix;
    public MatrixMultiple(int [][] firstMatrix, int [][] secondMatrix){
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
    }

    public int[][] getMultipleMatrix(){
        int [][] resultMatrix = new int [firstMatrix.length][firstMatrix[0].length];
        for (int i = 0; i < firstMatrix.length; i++){
            for (int j = 0; j < firstMatrix[i].length; j++){
                resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    public int[][] getFirstMatrix() {
        return firstMatrix;
    }

    public void setFirstMatrix(int[][] firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public int[][] getSecondMatrix() {
        return secondMatrix;
    }

    public void setSecondMatrix(int[][] secondMatrix) {
        this.secondMatrix = secondMatrix;
    }
}
