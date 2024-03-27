package javaHigh.exp1.builder;

/**
 * @author guiyi
 * @Date 2024/3/13 16:33:42
 * @ClassName javaHigh.exp2.PersonTest
 * @function -->
 */
public class PersonTest {
    public static void main(String[] args) {
        Person highPerson = new HighPerson.Builder("Alice", 180)
                .age(18)
                .location("Beijing")
                .job("Teacher")
                .gender("女")
                .build();

        Person fatPerson = new FatPerson.Builder("Bob", 200)
                .age(15)
                .location("Shenzhen")
                .job("Student")
                .gender("男")
                .build();

        System.out.println(highPerson);
        System.out.println(fatPerson);
    }
}
