package javaHigh.expOne.exp1;

/**
 * @author guiyi
 * @Date 2024/4/16 22:00:17
 * @ClassName javaHigh.expOne.exp1.FashionWatch
 * @function -->
 */
public class FashionWatch extends SmartWatch {
    private String mMaterial;

    public FashionWatch(Builder builder) {
        super(builder);
        this.mMaterial = builder.mMaterial;
    }

    public static class Builder extends SmartWatch.Builder<Builder> {
        private String mMaterial;

        public Builder material(String mMaterial) {
            this.mMaterial = mMaterial;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public FashionWatch build() {
            return new FashionWatch(this);
        }
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return super.toString() +
                "{mMaterial=" + mMaterial +
                '}';
    }

    @Override
    public FashionWatch clone() {
        try {
            FashionWatch cloned = (FashionWatch) super.clone();
            cloned.mMaterial = this.mMaterial;
            return cloned;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
