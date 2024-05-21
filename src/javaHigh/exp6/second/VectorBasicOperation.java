package javaHigh.exp6.second;

public enum VectorBasicOperation implements Operation {
    ADD {
        @Override
        public Vector3 apply(Vector3 v1, Vector3 v2) {
            return new Vector3(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());
        }
    },
    SUB {
        @Override
        public Vector3 apply(Vector3 v1, Vector3 v2) {
            return new Vector3(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
        }
    };
}
