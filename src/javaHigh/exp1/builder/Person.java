package javaHigh.exp1.builder;

/**
 * @author guiyi
 * @Date 2024/3/13 16:18:02
 * @ClassName javaHigh.exp2.Person
 * @function -->
 */
public class Person {
    private final String name;
    private final int age;
    private final String location;
    private final String job;
    private final String gender;

    Person(Builder<?> builder) {
        name = builder.name;
        age = builder.age;
        location = builder.location;
        job = builder.job;
        gender = builder.gender;
    }

    abstract static class Builder<T extends Builder<T>> {
        private final String name;
        private int age;
        private String location;
        private String job;
        private String gender;

        public Builder(String name) {
            this.name = name;
        }

        public T age(int age) {
            this.age = age;
            // return (T) this;
            return self();
        }

        // 返回T类型是为了链式编程
        public T location(String location) {
            this.location = location;
            return self();
        }

        public T job(String job) {
            this.job = job;
            return self();
        }

        public T gender(String gender) {
            this.gender = gender;
            return self();
        }

        protected abstract T self();

        abstract Person build();
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", age=" + age + ", location='" + location + '\'' + "," +
                " job='" + job + '\'' + ", gender='" + gender + '\'';
    }
}
