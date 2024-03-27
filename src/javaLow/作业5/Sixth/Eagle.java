package javaLow.作业5.Sixth;


public class Eagle extends javaLow.作业5.Sixth.Bird {
    // 实现飞行
    @Override
    public void flying() {
        System.out.println("Eagle is flying high in the sky.");
    }

    // 实现筑巢
    @Override
    public void nesting() {
        System.out.println("Eagle is building a nest on the mountain top.");
    }

    // 实现进食
    @Override
    public void eating() {
        System.out.println("Eagle is eating a prey.");
    }

    // 实现歌唱
    @Override
    public void singing() {
        System.out.println("Eagle is chirping loudly.");
    }
}
