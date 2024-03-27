package javaLow.作业5.Seven;

public class Vector implements javaLow.作业5.Seven.Computable {

    @Override
    public int[] add(int[] v1, int[] v2) {
        int[] result = new int[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] + v2[i];
        }
        return result;
    }

    @Override
    public int[] minus(int[] v1, int[] v2) {
        int[] result = new int[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] - v2[i];
        }
        return result;
    }

    @Override
    public int[] elementwiseProduct(int[] v1, int[] v2) {
        int[] result = new int[v1.length];
        for (int i = 0; i < v1.length; i++) {
            result[i] = v1[i] * v2[i];
        }
        return result;
    }
}

