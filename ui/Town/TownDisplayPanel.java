package ui.Town;

import parser.Town.Town;
import ui.Abstract.DisplayPanel;
import ui.PokeDescription;
import ui.PokeLabel;

import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.PAGE_START;
import static util.Utility.*;

public class TownDisplayPanel extends DisplayPanel<Town> {
    private final PokeLabel population;
    private final PokeDescription description;

    public TownDisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, Town town, ActionListener actionListener) {
        this(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, actionListener);
        update(town);
    }

    public TownDisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, ActionListener actionListener) {
        super(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, actionListener);
        // Add Population
        population = new PopulationLabel("0 Population", windowWidth, windowHeight, buttonSize);
        this.add(population, new GridBagConstraints(1, 2,
                2, 1,
                1, 1,
                PAGE_START, 0,
                new Insets(20, 10, 0, 0), buttonSize.width, buttonSize.height));
        // Add Description
        description = new PokeDescription("None", windowWidth, windowHeight, buttonSize);
        this.add(description, new GridBagConstraints(1, 3,
                3, 1,
                1, 1,
                PAGE_START, 0,
                new Insets(20, 10, 0, 0), buttonSize.width, buttonSize.height));
    }

    @Override
    public void update(Town town) {
        name.setText(town.getName() + " #" + idToString(town.getId()));
        icon.setIcon(makeIcon(imageWidth, imageHeight, getImagePath(imageDir, town.getId())));
        population.setText(town.getPopulation() + " Population");
        description.setText(town.getDescription());
    }
}
