package javaHigh.expOne.exp1;

/**
 * @author guiyi
 * @Date 2024/4/16 21:59:28
 * @ClassName javaHigh.expOne.exp1.FitnessWatch
 * @function -->
 */
public class FitnessWatch extends SmartWatch implements Cloneable {
    private boolean mGPS;

    public FitnessWatch(Builder builder) {
        super(builder);
        this.mGPS = builder.mGPS;
    }

    public static class Builder extends SmartWatch.Builder<Builder> {
        private boolean mGPS;

        public Builder GPS(boolean GPS) {
            this.mGPS = GPS;
            return this;
        }

        @Override
        public Builder self() {
            return this;
        }

        @Override
        public FitnessWatch build() {
            return new FitnessWatch(this);
        }
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return super.toString() +
                "{mGPS=" + mGPS +
                '}';
    }

    @Override
    public FitnessWatch clone() {
        try {
            FitnessWatch cloned = (FitnessWatch) super.clone();
            cloned.mGPS = this.mGPS;
            return cloned;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
