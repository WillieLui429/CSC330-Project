package ui.Abstract;

import ui.PokeIcon;
import ui.PokeIconButton;
import ui.PokeLabel;
import ui.SearchBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public abstract class DisplayPanel<T> extends JPanel {
    protected final PokeLabel name;
    protected final PokeIcon icon;
    protected final int imageWidth;
    protected final int imageHeight;
    protected final String imageDir;
    protected final Dimension buttonSize;

    public DisplayPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, ActionListener actionListener) {
        this.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageDir = imageDir;
        // Add Search Bar
        var searchMain = new SearchBar(windowWidth, windowHeight, "To List", "submitSearchMain", actionListener);
        constraints.gridwidth = 3;
        this.add(searchMain, constraints);
        // Add Icon
        icon = new PokeIcon();
        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.PAGE_START;
        this.add(icon, constraints);

        // Add Name
        name = new PokeLabel("Everything Must Be Loaded", JLabel.CENTER, (int) ((windowHeight + windowWidth) * 0.026));
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(name, constraints);

        // Add Navigation Arrows
        buttonSize = new Dimension((int) (windowWidth * 0.2), (int) (windowHeight * 0.10));
        int arrowSize = (int) ((windowHeight + windowWidth) * 0.03);
        var leftPokemon = new PokeIconButton((int) (arrowSize * 0.875), arrowSize, "icons/ui/arrow-left-solid.png", buttonSize,
                "left", actionListener, KeyEvent.VK_LEFT);
        constraints.ipadx = 65;
        constraints.ipady = 25;
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(leftPokemon, constraints);

        var rightPokemon = new PokeIconButton((int) (arrowSize * 0.875), arrowSize, "icons/ui/arrow-right-solid.png", buttonSize, "right", actionListener, KeyEvent.VK_RIGHT);
        constraints.gridx = 2;
        this.add(rightPokemon, constraints);
    }

    public abstract void update(T item);
}
