package javaHigh.expTwo;

import java.util.Arrays;

/**
 * @author guiyi
 * @Date 2024/5/10 上午9:03:05
 * @ClassName javaHigh.expTwo.DenseMatrix
 * @function -->
 */
public class DenseMatrix {
    private final double[][] matrix;
    private final int rows;
    private final int cols;

    // 构造函数
    public DenseMatrix(int rows, int cols) {
        this.matrix = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    // 设定矩阵指定位置上元素的值
    public void setValue(int row, int col, double value) {
        matrix[row][col] = value;
    }

    // 获取矩阵指定位置上元素的值
    public double getValue(int row, int col) {
        return matrix[row][col];
    }

    // 返回矩阵的行数
    public int rows() {
        return rows;
    }

    // 返回矩阵的列数
    public int cols() {
        return cols;
    }

    // 重写toString()方法，输出矩阵
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                builder.append(matrix[i][j]).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    // 重写equals()方法，比较两个矩阵是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DenseMatrix other = (DenseMatrix) obj;
        if (rows != other.rows || cols != other.cols) return false;
        for (int i = 0; i < rows; i++) {
            if (!Arrays.equals(matrix[i], other.matrix[i])) return false;
        }
        return true;
    }

    // 重写hashCode()方法
    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(matrix);
        result = 31 * result + rows;
        result = 31 * result + cols;
        return result;
    }
}
