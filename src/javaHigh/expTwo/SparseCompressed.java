package javaHigh.expTwo;

import java.util.ArrayList;

/**
 * @author guiyi
 * @Date 2024/5/10 下午8:17:00
 * @ClassName javaHigh.expTwo.SparseCompressed
 * @function -->
 */
public class SparseCompressed implements Sparse {
    private final ArrayList<Triplet> triplets = new ArrayList<>();
    private boolean compressed = false;

    @Override
    public void addElement(int i, int j, double a) {
        triplets.add(new Triplet(i, j, a));
    }

    @Override
    public int nonZeroCount() {
        return triplets.size();
    }

    @Override
    public boolean isCompressed() {
        return compressed;
    }

    public void compress() {
        System.out.println("矩阵已压缩。");
        compressed = true;
    }
}
