package ui.Abstract;

import ui.SearchBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public abstract class ItemListPanel<T> extends JPanel {
    public ItemListPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, List<T> list, ActionListener actionListener, MouseListener mouseListener) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        var searchList = new SearchBar(windowWidth, windowHeight, "To Main", "submitSearchList", actionListener);

        var listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        for (var item : list)
            listPanel.add(createListItem(item, windowWidth, windowHeight, imageWidth, imageHeight, imageDir, mouseListener));
        var scroll = new ScrollPane();
        scroll.add(listPanel);

        this.add(searchList);
        this.add(scroll);
    }

    public abstract JPanel createListItem(T item, int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, MouseListener mouseListener);
}
