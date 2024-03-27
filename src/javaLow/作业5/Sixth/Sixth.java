package javaLow.作业5.Sixth;

public class Sixth {
    public static void main(String[] args) {
        // 使用上转型对象变量调用各个方法
        javaLow.作业5.Sixth.Bird eagle = new javaLow.作业5.Sixth.Eagle();
        System.out.println("==== Eagle ====");
        eagle.flying();
        eagle.nesting();
        eagle.eating();
        eagle.singing();

        javaLow.作业5.Sixth.Bird dove = new javaLow.作业5.Sixth.Dove();
        System.out.println("\n==== Dove ====");
        dove.flying();
        dove.nesting();
        dove.eating();
        dove.singing();

        javaLow.作业5.Sixth.Bird sparrow = new javaLow.作业5.Sixth.Sparrow();
        System.out.println("\n==== Sparrow ====");
        sparrow.flying();
        sparrow.nesting();
        sparrow.eating();
        sparrow.singing();
    }
}
