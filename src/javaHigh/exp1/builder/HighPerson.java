package javaHigh.exp1.builder;

/**
 * @author guiyi
 * @Date 2024/3/13 16:26:51
 * @ClassName javaHigh.exp2.HighPerson
 * @function -->
 */
public class HighPerson extends Person {
    private final int height;

    private HighPerson(Builder builder) {
        super(builder);
        height = builder.height;
    }

    public static class Builder extends Person.Builder<Builder> {
        private final int height;

        public Builder(String name, int height) {
            super(name);
            this.height = height;
        }

        // 父类对象会拿到子类的对象
        @Override
        public Builder self() {
            return this;
        }

        @Override
        public HighPerson build() {
            return new HighPerson(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Height=" + height;
    }
}
