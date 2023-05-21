package ui.Pokemon;

import parser.Pokemon.PokemonType;
import ui.PokeLabel;

import javax.swing.*;
import java.awt.*;

public class PokemonTypeLabel extends PokeLabel {
    public PokemonTypeLabel(int windowWidth, int windowHeight, Dimension buttonSize, String text, int backgroundColor) {
        super(text, JLabel.CENTER, (int) ((windowHeight + windowWidth) * 0.020));
        this.setMinimumSize(buttonSize);
        this.setPreferredSize(buttonSize);
        this.setMaximumSize(buttonSize);
        this.setOpaque(true);
        this.setForeground(new Color(0xf2eee8));
        this.setBackground(new Color(backgroundColor));
    }

    public void setPokeType(PokemonType pokemonType) {
        this.setText(pokemonType.toString());
        this.setBackground(new Color(pokemonType.toColor()));
    }
}
