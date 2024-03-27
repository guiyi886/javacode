package javaLow.作业5.Sixth;

public class Dove extends javaLow.作业5.Sixth.Bird {
    // 实现飞行
    @Override
    public void flying() {
        System.out.println("Dove is flying gracefully.");
    }

    // 实现筑巢
    @Override
    public void nesting() {
        System.out.println("Dove is building a nest on the tree branch.");
    }

    // 实现进食
    @Override
    public void eating() {
        System.out.println("Dove is pecking seeds on the ground.");
    }

    // 实现歌唱
    @Override
    public void singing() {
        System.out.println("Dove is cooing softly.");
    }
}

