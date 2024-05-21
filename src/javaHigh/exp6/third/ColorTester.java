package javaHigh.exp6.third;

import java.util.EnumSet;

public class ColorTester {
    public static void main(String[] args) {
        EnumSet<Color> rg = EnumSet.of(Color.RED, Color.GREEN);
        EnumSet<Color> gr = EnumSet.of(Color.GREEN, Color.RED);
        EnumSet<Color> gb = EnumSet.of(Color.GREEN, Color.BLUE);
        EnumSet<Color> rb = EnumSet.of(Color.RED, Color.BLUE);
        EnumSet<Color> rgb = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);

        System.out.println("Red + Green = " + ColorMixer.mixColors(rg));
        System.out.println("Green + Red = " + ColorMixer.mixColors(gr));
        System.out.println("Green + Blue = " + ColorMixer.mixColors(gb));
        System.out.println("Red + Blue = " + ColorMixer.mixColors(rb));
        System.out.println("Red + Green + Blue = " + ColorMixer.mixColors(rgb));
    }
}

