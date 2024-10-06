package com.thecollinsbyte.dsa;

public class Matrix<T extends Number> {
    private int rows;
    private int cols;
    private T[][] data;


    public Matrix(int rows, int cols, T[][] data) {
        this.rows = rows;
        this.cols = cols;
        this.data = data;
    }

    public void insertAtBeginning(T[] elements) {
        if(elements == null) throw new IllegalStateException("Elements array cannot be null");

        if (rows == 0 && cols == 0) {
            resizeMatrix(1, elements.length);
            System.arraycopy(elements, 0, data[0], 0, elements.length);
        } else if(elements.length != cols) {
            throw new IllegalStateException("Number of elements must match the number of columns in the matrix");
        }else {
            resizeMatrix(rows + 1, cols);
            shiftDown(0);
            System.arraycopy(elements, 0, data[0], 0, cols);
        }
    }

    public T[][] getData() {
        return data;
    }

    private void resizeMatrix(int newRows, int newCols) {
        T[][] newData = createEmptyMatrix(newRows, newCols);

        for (int i = 0; i < Math.min(rows, newRows); i++) {
            System.arraycopy(data[i], 0, newData[i], 0, Math.min(cols, newCols));
        }
        this.data = newData;
        this.rows = newRows;
        this.cols = newCols;
    }

    private void shiftDown(int fromRow) {
        for (int i = rows - 1; i > fromRow; i--) {
            data[i] = data[i - 1];
        }
        data[fromRow] = createEmptyMatrix(1, cols)[0];
    }

    private T[][] createEmptyMatrix(int rows, int cols) {
         return (T[][]) new Number[rows][cols];
    }
}