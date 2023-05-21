package ui.Abstract;

import parser.Abstract.Item;
import ui.PokeLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

import static util.Utility.*;

public class ListItemPanel<T extends Item> extends JPanel {
    private final Dimension buttonSize;

    public ListItemPanel(T item, int windowWidth, int windowHeight, int imageWidth, int imageHeight, int fontSize, String imageDir, MouseListener mouseListener) {
        this.setName(String.valueOf(item.getId()));
        this.setLayout(new GridLayout());
        this.addMouseListener(mouseListener);

        buttonSize = new Dimension((int) (windowWidth * 0.1), (int) (windowHeight * 0.05));
        var iconImg = new ImageIcon(getImagePath(imageDir, item.getId()));
        resizeIcon(iconImg, imageWidth / 4, imageHeight / 4);

        var icon = new JLabel(iconImg);
        icon.setPreferredSize(new Dimension(buttonSize.width / 5, (int) (buttonSize.height * 3.5)));
        icon.setMaximumSize(new Dimension(buttonSize.width / 5, (int) (buttonSize.height * 3.5)));
        icon.setMinimumSize(new Dimension(buttonSize.width / 5, (int) (buttonSize.height * 3.5)));
        this.add(icon);

        var id = new PokeLabel(" #" + idToString(item.getId()), JLabel.CENTER, fontSize);
        this.add(id);

        var name = new PokeLabel(item.getName(), JLabel.CENTER, fontSize);
        this.add(name);
    }

    public ListItemPanel(T item, int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, MouseListener mouseListener) {
        this.setName(String.valueOf(item.getId()));
        this.setLayout(new GridLayout());
        this.addMouseListener(mouseListener);

        buttonSize = new Dimension((int) (windowWidth * 0.1), (int) (windowHeight * 0.05));
        var iconImg = new ImageIcon(getImagePath(imageDir, item.getId()));
        resizeIcon(iconImg, imageWidth / 4, imageHeight / 4);

        var icon = new JLabel(iconImg);
        icon.setPreferredSize(new Dimension(buttonSize.width / 5, (int) (buttonSize.height * 3.5)));
        icon.setMaximumSize(new Dimension(buttonSize.width / 5, (int) (buttonSize.height * 3.5)));
        icon.setMinimumSize(new Dimension(buttonSize.width / 5, (int) (buttonSize.height * 3.5)));
        this.add(icon);

        var id = new PokeLabel(" #" + idToString(item.getId()), JLabel.CENTER, (int) ((windowHeight + windowWidth) * 0.018));
        this.add(id);

        var name = new PokeLabel(item.getName(), JLabel.CENTER, (int) ((windowHeight + windowWidth) * 0.018));
        this.add(name);
    }

    public Dimension getButtonSize() {
        return buttonSize;
    }
}
