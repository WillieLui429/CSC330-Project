package ui.Misc;

import parser.Misc.Misc;
import ui.Abstract.TypePanel;
import ui.PokedexFrame;

import java.awt.*;
import java.util.List;

public class MiscPanel extends TypePanel<Misc> {
    public MiscPanel(int windowWidth, int windowHeight, List<Misc> miscList, String imageDir, PokedexFrame pokedexFrame) {
        super(windowWidth, windowHeight, miscList, imageDir, pokedexFrame);
        // Create Main Display Panel
        if (!miscList.isEmpty())
            displayPanel = new MiscDisplayPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, miscList.get(0), this);
        else
            displayPanel = new MiscDisplayPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, this);
        // Create the List View Panel
        var miscListPanel = new MiscListPanel(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, miscList, this, this);

        // Combine Them with Cards Panel
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(displayPanel);
        this.add(miscListPanel);
    }
}
