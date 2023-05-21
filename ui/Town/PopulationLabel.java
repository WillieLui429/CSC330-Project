package ui.Town;

import parser.Pokemon.PokemonType;
import ui.PokeLabel;

import javax.swing.*;
import java.awt.*;

public class PopulationLabel extends PokeLabel {
    public PopulationLabel(String text, int windowWidth, int windowHeight, Dimension buttonSize) {
        super(text, JLabel.CENTER, (int) ((windowHeight + windowWidth) * 0.018));
        buttonSize.setSize(buttonSize.width * 1.2, buttonSize.height);
        this.setMinimumSize(buttonSize);
        this.setPreferredSize(buttonSize);
        this.setMaximumSize(buttonSize);
        this.setOpaque(true);
        this.setForeground(new Color(0xf2eee8));
        this.setBackground(new Color(0x666a6e));
    }
}
