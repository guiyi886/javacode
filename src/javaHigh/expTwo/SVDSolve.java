package javaHigh.expTwo;

/**
 * @author guiyi
 * @Date 2024/5/10 下午8:37:16
 * @ClassName javaHigh.expTwo.SVDSolve
 * @function -->
 */
public interface SVDSolve<T> extends Solve<T>, Decompose<T> {
    void SVD(); // 表示矩阵的SVD分解

    T getU(); // 获取 SVD 分解出的 U 矩阵

    T getSigma(); // 获取 SVD 分解出的 Σ 矩阵

    T getV(); // 获取 SVD 分解出的 V 矩阵

    T compute(T mat); // 将矩阵的分解和方程的求解合并为一步
}
