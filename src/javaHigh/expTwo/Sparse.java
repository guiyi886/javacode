package javaHigh.expTwo;

/**
 * @author guiyi
 * @Date 2024/5/10 下午7:52:46
 * @ClassName javaHigh.expTwo.Sparse
 * @function -->
 */
// 定义接口 Sparse
interface Sparse {
    void addElement(int i, int j, double a); // 添加新的三元组

    int nonZeroCount(); // 查询非零元素（三元组的个数）

    boolean isCompressed(); // 查询矩阵是否被压缩存储
}
