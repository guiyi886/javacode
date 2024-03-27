package javaLow.javaLow.作业5.Forth.Default;

public class TestIn {
    public static void main(String[] args) {
        // 创建 DefaultClass 实例
        DefaultClass defaultClass = new DefaultClass();

        // 在同一个包中，可以访问 DefaultClass 的除私有变量外的其他成员变量
//        System.out.println("defaultClass.privateMember: " + defaultClass.privateMember);
        System.out.println("defaultClass.defaultMember: " + defaultClass.defaultMember);
        System.out.println("defaultClass.protectedMember: " + defaultClass.protectedMember);
        System.out.println("defaultClass.publicMember: " + defaultClass.publicMember);

    }
}
