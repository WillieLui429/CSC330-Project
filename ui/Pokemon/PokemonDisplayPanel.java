package ui.Pokemon;

import parser.Pokemon.Pokemon;
import ui.Abstract.DisplayPanel;
import ui.PokeDescription;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.PAGE_START;
import static util.Utility.*;

public class PokemonDisplayPanel extends DisplayPanel<Pokemon> {
    private final PokemonTypeLabel type1;
    private final PokemonTypeLabel type2;
    private final JTextArea description;

    public PokemonDisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, Pokemon pokemon, ActionListener actionListener) {
        this(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, actionListener);
        update(pokemon);
    }

    public PokemonDisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, ActionListener actionListener) {
        super(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, actionListener);
        // Add parser.Pokemon Types
        type1 = new PokemonTypeLabel(windowWidth, windowHeight, buttonSize, "NONE", 0x000000);
        this.add(type1, new GridBagConstraints(1, 2,
                1, 1,
                1, 1,
                PAGE_START, 0,
                new Insets(10, 10, 0, 0), buttonSize.width, buttonSize.height));

        type2 = new PokemonTypeLabel(windowWidth, windowHeight, buttonSize, "NONE", 0x000000);
        this.add(type2, new GridBagConstraints(2, 2,
                1, 1,
                1, 1,
                PAGE_START, 0,
                new Insets(10, 10, 0, 0), buttonSize.width, buttonSize.height));

        // Add Description
        description = new PokeDescription("None", windowWidth, windowHeight, buttonSize);
        this.add(description, new GridBagConstraints(1, 3,
                3, 1,
                1, 1,
                PAGE_START, 0,
                new Insets(0, 5, 0, 0), buttonSize.width, buttonSize.height));
    }

    @Override
    public void update(Pokemon pokemon) {
        name.setText(pokemon.getName() + " #" + idToString(pokemon.getId()));
        icon.setIcon(makeIcon(imageWidth, imageHeight, getImagePath(imageDir, pokemon.getId())));
        type1.setPokeType(pokemon.getType1());
        type2.setPokeType(pokemon.getType2());
        description.setText(pokemon.getDescription());
    }
}
