package util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    static Map<Integer, Color> colorMap = new HashMap<>();

    //todo: complete the method to add other color
    public static void InitialColorMap() {
//        colorMap.put(1, Color.RED);
        colorMap.put(2, Color.LIGHT_GRAY);
        colorMap.put(4, Color.GRAY);
        colorMap.put(8, Color.PINK);
        colorMap.put(16, Color.ORANGE);
        colorMap.put(32, Color.YELLOW);
        colorMap.put(64, Color.MAGENTA);
        colorMap.put(128, Color.RED);
        colorMap.put(256, Color.GREEN);
        colorMap.put(512, Color.CYAN);
        colorMap.put(1024, Color.BLUE);
        colorMap.put(2048, Color.DARK_GRAY);
    }

    public static Color getColor(int i) {
        return colorMap.getOrDefault(i, Color.black);
    }
}
