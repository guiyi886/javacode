package javaHigh.expTwo;

/**
 * @author guiyi
 * @Date 2024/5/10 下午11:14:17
 * @ClassName javaHigh.expTwo.HilbertMatrix2
 * @function -->
 */
// HilbertMatrix2 类通过复合 DenseMatrix 类来实现
public class HilbertMatrix2 {
    private DenseMatrix matrix; // 使用 DenseMatrix 来表示希尔伯特矩阵

    // 构造函数，传入矩阵的阶数
    public HilbertMatrix2(int n) {
        matrix = createHilbertMatrix(n); // 创建希尔伯特矩阵
    }

    // 创建希尔伯特矩阵的方法
    private DenseMatrix createHilbertMatrix(int n) {
        DenseMatrix hilbertMatrix = new DenseMatrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hilbertMatrix.setValue(i, j, 1.0 / (i + j + 1)); // 根据希尔伯特矩阵的定义设置元素值
            }
        }
        return hilbertMatrix;
    }

    // 获取矩阵指定位置上元素的值
    public double getValue(int row, int col) {
        return matrix.getValue(row, col);
    }

    // 返回矩阵的行数
    public int rows() {
        return matrix.rows();
    }

    // 返回矩阵的列数
    public int cols() {
        return matrix.cols();
    }

    // cholesky() 方法表示对该方阵进行cholesky分解
    public void cholesky() {
        System.out.println("对希尔伯特矩阵进行cholesky分解。");
    }
}

