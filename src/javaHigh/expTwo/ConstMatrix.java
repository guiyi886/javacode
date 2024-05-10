package javaHigh.expTwo;

/**
 * @author guiyi
 * @Date 2024/5/10 上午10:58:05
 * @ClassName javaHigh.expTwo.ConstMatrix
 * @function -->
 */
public class ConstMatrix {
    // 定义一个常量 DenseMatrix 表示泡利矩阵
    public static final DenseMatrix PAULI_MATRIX = createPauliMatrix();

    // 创建泡利矩阵的方法
    private static DenseMatrix createPauliMatrix() {
        DenseMatrix pauliMatrix = new DenseMatrix(2, 2);
        pauliMatrix.setValue(0, 0, 0);
        pauliMatrix.setValue(0, 1, 1);
        pauliMatrix.setValue(1, 0, 1);
        pauliMatrix.setValue(1, 1, 0);
        return pauliMatrix;
    }
}
