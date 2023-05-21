package ui.Town;

import parser.Town.Town;
import ui.Abstract.TypePanel;
import ui.PokedexFrame;

import java.awt.*;
import java.util.List;

public class TownPanel extends TypePanel<Town> {
    public TownPanel(int windowWidth, int windowHeight, List<Town> townList, String imageDir, PokedexFrame pokedexFrame) {
        super(windowWidth, windowHeight, townList, imageDir, pokedexFrame);
        // Create Main Display Panel
        if (!townList.isEmpty())
            displayPanel = new TownDisplayPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, townList.get(0), this);
        else
            displayPanel = new TownDisplayPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, this);
        // Create the List View Panel
        var pokemonListPanel = new TownListPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, townList, this, this);

        // Combine Them with Cards Panel
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(displayPanel);
        this.add(pokemonListPanel);
    }
}
