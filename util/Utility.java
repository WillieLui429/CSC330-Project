package util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public final class Utility {
    public static ImageIcon makeIcon(int imageWidth, int imageHeight, String imageDir) {
        var icon = new ImageIcon(imageDir);
        resizeIcon(icon, imageWidth, imageHeight);
        return icon;
    }

    public static void resizeIcon(ImageIcon imgIcon, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imgIcon.getImage(), 0, 0, w, h, null);
        g2.dispose();
        imgIcon.setImage(resizedImg);
    }

    public static String idToString(int id) {
        return (id < 10) ? "00" + id : (id < 100) ? "0" + id : String.valueOf(id);
    }

    public static String getImagePath(String dir, int id) {
        return (dir.endsWith("/") ? dir : dir + "/") + id + ".png";
    }
}
