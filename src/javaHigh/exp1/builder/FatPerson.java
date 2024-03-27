package javaHigh.exp1.builder;

/**
 * @author guiyi
 * @Date 2024/3/13 16:26:51
 * @ClassName javaHigh.exp2.HighPerson
 * @function -->
 */
public class FatPerson extends Person {
    private final int weight;

    private FatPerson(Builder builder) {
        super(builder);
        weight = builder.weight;
    }

    public static class Builder extends Person.Builder<Builder> {
        private final int weight;

        public Builder(String name, int weight) {
            super(name);
            this.weight = weight;
        }

        @Override
        public FatPerson.Builder self() {
            return this;
        }

        @Override
        public FatPerson build() {
            return new FatPerson(this);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight=" + weight;
    }
}
