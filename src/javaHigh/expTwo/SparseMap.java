package javaHigh.expTwo;

import java.util.ArrayList;

/**
 * @author guiyi
 * @Date 2024/5/10 下午7:58:05
 * @ClassName javaHigh.expTwo.SparseMap
 * @function -->
 */
public abstract class SparseMap implements Sparse {
    private final ArrayList<Triplet> triplets = new ArrayList<>();

    @Override
    public void addElement(int i, int j, double a) {
        triplets.add(new Triplet(i, j, a));
    }

    @Override
    public int nonZeroCount() {
        return triplets.size();
    }
}
