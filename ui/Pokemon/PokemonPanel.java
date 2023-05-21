package ui.Pokemon;

import parser.Pokemon.Pokemon;
import ui.Abstract.TypePanel;
import ui.PokedexFrame;

import java.awt.*;
import java.util.List;

public class PokemonPanel extends TypePanel<Pokemon> {
    public PokemonPanel(int windowWidth, int windowHeight, List<Pokemon> pokemonList, String imageDir, PokedexFrame pokedexFrame) {
        super(windowWidth, windowHeight, pokemonList, imageDir, pokedexFrame);
        // Create Main Display Panel
        if (!pokemonList.isEmpty())
            displayPanel = new PokemonDisplayPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, pokemonList.get(0), this);
        else
            displayPanel = new PokemonDisplayPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, this);

        // Create the List View Panel
        var pokemonListPanel = new PokemonListPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, pokemonList, this, this);

        // Combine Them with Cards Panel
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(displayPanel);
        this.add(pokemonListPanel);
    }
}
