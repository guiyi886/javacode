package javaHigh.exp8.first;

public class Test {
    public static void main(String[] args) {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);

        VectorBinaryOperation add = (a, b) -> new Vector3(
                a.getX() + b.getX(),
                a.getY() + b.getY(),
                a.getZ() + b.getZ()
        );

        VectorBinaryOperation subtract = (a, b) -> new Vector3(
                a.getX() - b.getX(),
                a.getY() - b.getY(),
                a.getZ() - b.getZ()
        );

        ScalarOperation dotProduct = (a, b) ->
                a.getX() * b.getX() + a.getY() * b.getY() + a.getZ() * b.getZ();

        VectorBinaryOperation crossProduct = (a, b) -> new Vector3(
                a.getY() * b.getZ() - a.getZ() * b.getY(),
                a.getZ() * b.getX() - a.getX() * b.getZ(),
                a.getX() * b.getY() - a.getY() * b.getX()
        );

        Vector3 vAdd = add.apply(v1, v2);
        System.out.println("加法: " + vAdd);

        Vector3 vSubtract = subtract.apply(v1, v2);
        System.out.println("减法: " + vSubtract);

        double vDotProduct = dotProduct.apply(v1, v2);
        System.out.println("点积: " + vDotProduct);

        Vector3 vCrossProduct = crossProduct.apply(v1, v2);
        System.out.println("叉积: " + vCrossProduct);
    }
}
