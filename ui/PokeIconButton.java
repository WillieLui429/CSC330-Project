package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import static util.Utility.makeIcon;

public class PokeIconButton extends JButton {
    public PokeIconButton(int imageWidth, int imageHeight, String imageDir, Dimension buttonSize, String actionCommand, ActionListener actionListener, int mnemonic) {
        super(makeIcon(imageWidth, imageHeight, imageDir));
        this.setMinimumSize(buttonSize);
        this.setPreferredSize(buttonSize);
        this.setMaximumSize(buttonSize);
        this.setFocusPainted(false);
        this.setMnemonic(mnemonic); // KeyEvent.VK_RIGHT for right, etc.
        this.addActionListener(actionListener);
        this.setActionCommand(actionCommand);
    }
}
