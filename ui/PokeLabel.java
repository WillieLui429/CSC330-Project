package ui;

import javax.swing.*;
import java.awt.*;

public class PokeLabel extends JLabel {
    public PokeLabel(String text, int position, int fontSize) {
        super(text, position);
        this.setFont(new Font("Fira Sans", Font.PLAIN, fontSize));
    }

    public void setFontSize(int fontSize) {
        this.setFont(new Font("Fira Sans", Font.PLAIN, fontSize));
    }
}
