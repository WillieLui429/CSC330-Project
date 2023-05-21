package ui;

import javax.swing.*;
import java.awt.*;

public class PokeDescription extends JTextArea {
    public PokeDescription(String text, int windowWidth, int windowHeight, Dimension buttonSize) {
        super(text);
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setEnabled(false);
        this.setMinimumSize(new Dimension((int) (buttonSize.width * 1.5), buttonSize.height * 6));
        this.setPreferredSize(new Dimension((int) (buttonSize.width * 1.5), buttonSize.height * 6));
        this.setMaximumSize(new Dimension((int) (buttonSize.width * 1.5), buttonSize.height * 6));
        this.setDisabledTextColor(new Color(0x333333));
        this.setBackground(new Color(0xeeeeee));
        this.setFont(new Font("Fira Sans", Font.ITALIC, (int) ((windowHeight + windowWidth) * 0.020)));
    }
}
