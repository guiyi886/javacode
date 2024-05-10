package javaHigh.expTwo;

/**
 * @author guiyi
 * @Date 2024/5/10 下午11:13:26
 * @ClassName javaHigh.expTwo.HilbertMatrix1
 * @function -->
 */
// HilbertMatrix1 类通过继承 DenseMatrix 类来实现
public class HilbertMatrix1 extends DenseMatrix {
    // 构造函数，传入矩阵的阶数
    public HilbertMatrix1(int n) {
        super(n, n); // 调用父类的构造函数来创建希尔伯特矩阵
        createHilbertMatrix(); // 创建希尔伯特矩阵
    }

    // 创建希尔伯特矩阵的方法
    private void createHilbertMatrix() {
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                setValue(i, j, 1.0 / (i + j + 1)); // 根据希尔伯特矩阵的定义设置元素值
            }
        }
    }

    // cholesky() 方法表示对该方阵进行cholesky分解
    public void cholesky() {
        System.out.println("对希尔伯特矩阵进行cholesky分解。");
    }
}
