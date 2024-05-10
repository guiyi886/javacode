package javaHigh.expTwo;

import java.util.Arrays;

/**
 * @author guiyi
 * @Date 2024/5/10 上午9:03:05
 * @ClassName javaHigh.expTwo.DenseMatrix
 * @function -->
 */
public class DenseMatrix implements SVDSolve<DenseMatrix> {
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

    @Override
    public DenseMatrix solve(DenseMatrix mat) {
        System.out.println("求解矩阵方程结果。");
        return mat; // 简单返回原矩阵
    }

    @Override
    public DenseMatrix[] Decompose() {
        System.out.println("对矩阵进行分解。");
        return new DenseMatrix[]{this}; // 简单返回原矩阵的副本
    }

    @Override
    public void SVD() {
        System.out.println("进行 SVD 分解。");
    }

    @Override
    public DenseMatrix getU() {
        System.out.println("获取 SVD 分解出的 U 矩阵。");
        return this; // 简单返回原矩阵
    }

    @Override
    public DenseMatrix getSigma() {
        System.out.println("获取 SVD 分解出的 Σ 矩阵。");
        return this; // 简单返回原矩阵
    }

    @Override
    public DenseMatrix getV() {
        System.out.println("获取 SVD 分解出的 V 矩阵。");
        return this; // 简单返回原矩阵
    }

    @Override
    public DenseMatrix compute(DenseMatrix mat) {
        System.out.println("将矩阵的分解和方程的求解合并为一步。");
        return mat; // 简单返回原矩阵
    }
}
