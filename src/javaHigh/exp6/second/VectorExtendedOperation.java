package javaHigh.exp6.second;

public enum VectorExtendedOperation implements Operation {
    CROSS {
        @Override
        public Vector3 apply(Vector3 v1, Vector3 v2) {
            double x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
            double y = v1.getZ() * v2.getX() - v1.getX() * v2.getZ();
            double z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
            return new Vector3(x, y, z);
        }
    }
}
