package util;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {
    static Map<Integer, Color> colorMap = new HashMap<>();
    Color c2 =new Color(192,194,180);
    Color c4 =new Color(179,175,155);
    Color c8 =new Color(227,176,45);
    Color c16 =new Color(227,127,45);
    Color c32 =new Color(227,100,45);
    Color c64 =new Color(227,45,45);
    Color c128 =new Color(227,203,45);
    Color c256 =new Color(218,227,45);
    Color c512 =new Color(185,227,45);
    Color c1024 =new Color(145,227,45);
    Color c2048 =new Color(76,227,45);
    //todo: complete the method to add other color
    public static void InitialColorMap() {
//        colorMap.put(1, Color.RED);
        colorMap.put(2, new Color(192,194,180));
        colorMap.put(4, new Color(179,175,155));
        colorMap.put(8, new Color(227,176,45));
        colorMap.put(16, new Color(227,127,45));
        colorMap.put(32, new Color(227,100,45));
        colorMap.put(64, new Color(227,45,45));
        colorMap.put(128, new Color(227,203,45));
        colorMap.put(256, new Color(218,227,45));
        colorMap.put(512, new Color(185,227,45));
        colorMap.put(1024, new Color(145,227,45));
        colorMap.put(2048, new Color(76,227,45));
    }

    public static Color getColor(int i) {
        return colorMap.getOrDefault(i, Color.black);
    }
}
