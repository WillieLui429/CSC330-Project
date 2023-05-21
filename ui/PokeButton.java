package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PokeButton extends JButton {
    public PokeButton(String text, int position, int fontSize, Dimension size, boolean focused, int mnemonic, String actionCommand, ActionListener actionListener) {
        super(text);
        this.setFont(new Font("Fira Sans", Font.PLAIN, fontSize));
        this.setHorizontalTextPosition(position);
        this.setFocusPainted(focused);
        this.setMnemonic(mnemonic);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
        this.addActionListener(actionListener);
        this.setActionCommand(actionCommand);
    }

    public PokeButton(String text, int position, int fontSize, boolean focused, int mnemonic, String actionCommand, ActionListener actionListener) {
        super(text);
        this.setFont(new Font("Fira Sans", Font.PLAIN, fontSize));
        this.setHorizontalTextPosition(position);
        this.setFocusPainted(focused);
        this.setMnemonic(mnemonic);
        this.addActionListener(actionListener);
        this.setActionCommand(actionCommand);
    }

    public PokeButton(String text, int position, int fontSize, String actionCommand, ActionListener actionListener) {
        super(text);
        this.setFont(new Font("Fira Sans", Font.PLAIN, fontSize));
        this.setHorizontalTextPosition(position);
        this.addActionListener(actionListener);
        this.setActionCommand(actionCommand);
    }

    public void setSize(Dimension size) {
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
    }
}
