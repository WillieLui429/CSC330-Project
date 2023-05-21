package ui;

import javax.swing.*;

import static util.Utility.makeIcon;

public class PokeIcon extends JLabel {
    public PokeIcon(int imageWidth, int imageHeight, String imageDir) {
        super(makeIcon(imageWidth, imageHeight, imageDir));
    }
    public PokeIcon() {
        super();
    }
}
