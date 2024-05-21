package javaHigh.exp6.third;

import java.util.EnumSet;

public class ColorMixer {
    public static String mixColors(EnumSet<Color> colors) {
        if (colors.equals(EnumSet.of(Color.RED, Color.GREEN))) {
            return "Yellow";
        } else if (colors.equals(EnumSet.of(Color.GREEN, Color.BLUE))) {
            return "Cyan";
        } else if (colors.equals(EnumSet.of(Color.RED, Color.BLUE))) {
            return "Magenta";
        } else if (colors.equals(EnumSet.of(Color.RED, Color.GREEN, Color.BLUE))) {
            return "White";
        } else {
            return "Unknown";
        }
    }
}

