package javaHigh.exp6.second;

public class Test {
    public static void main(String[] args) {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);

        System.out.println("向量1: " + v1);
        System.out.println("向量2: " + v2);

        // 测试加法和减法
        Vector3 addResult = VectorBasicOperation.ADD.apply(v1, v2);
        Vector3 subResult = VectorBasicOperation.SUB.apply(v1, v2);

        System.out.println("加法结果: " + addResult);
        System.out.println("减法结果: " + subResult);

        // 测试叉乘
        Vector3 crossResult = VectorExtendedOperation.CROSS.apply(v1, v2);

        System.out.println("叉乘结果: " + crossResult);
    }
}

