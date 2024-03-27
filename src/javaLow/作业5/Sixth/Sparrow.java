package javaLow.作业5.Sixth;


public class Sparrow extends javaLow.作业5.Sixth.Bird {
    // 实现飞行
    @Override
    public void flying() {
        System.out.println("Sparrow is flying around the garden.");
    }

    // 实现筑巢
    @Override
    public void nesting() {
        System.out.println("Sparrow is making a nest in the shrubbery.");
    }

    // 实现进食
    @Override
    public void eating() {
        System.out.println("Sparrow is eating crumbs from the feeder.");
    }

    // 实现歌唱
    @Override
    public void singing() {
        System.out.println("Sparrow is tweeting melodiously.");
    }
}

