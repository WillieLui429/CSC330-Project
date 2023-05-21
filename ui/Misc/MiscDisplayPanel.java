package ui.Misc;

import parser.Misc.Misc;
import ui.Abstract.DisplayPanel;
import ui.PokeDescription;

import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.PAGE_START;
import static util.Utility.*;

public class MiscDisplayPanel extends DisplayPanel<Misc> {
    private final PokeDescription description;

    public MiscDisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, Misc misc, ActionListener actionListener) {
        this(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, actionListener);
        update(misc);
    }

    public MiscDisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, ActionListener actionListener) {
        super(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, actionListener);
        name.setFontSize((windowWidth + windowHeight)/75);
        // Add Description
        description = new PokeDescription("None", windowWidth, windowHeight, buttonSize);
        this.add(description, new GridBagConstraints(1, 2,
                3, 2,
                1, 1,
                PAGE_START, 0,
                new Insets(10, 5, 0, 10), buttonSize.width*2, buttonSize.height));
    }

    @Override
    public void update(Misc misc) {
        name.setText(misc.getName() + " #" + idToString(misc.getId()));
        icon.setIcon(makeIcon(imageWidth, imageHeight, getImagePath(imageDir, misc.getId())));
        description.setText(misc.getDescription());
    }
}
