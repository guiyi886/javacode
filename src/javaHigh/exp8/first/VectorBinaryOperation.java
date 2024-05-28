package javaHigh.exp8.first;

@FunctionalInterface
public interface VectorBinaryOperation {
    Vector3 apply(Vector3 v1, Vector3 v2);
}
