package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SearchBar extends JPanel {
    private final JTextField searchField;

    public SearchBar(int windowWidth, int windowHeight, String changeCardName, String submitSearchCommand, ActionListener actionListener) {
        var searchSize = new Dimension((int) (windowWidth * 0.36), (int) (windowHeight * 0.076));
        searchField = new JTextField("");
        searchField.setToolTipText("Search ID or Name");
        searchField.setMinimumSize(searchSize);
        searchField.setPreferredSize(searchSize);
        searchField.setMaximumSize(searchSize);
        searchField.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.02)));

        searchSize = new Dimension((int) (searchSize.width/2.5), searchSize.height);
        var homeCard = new PokeButton("To Menu", PokeButton.CENTER, (int) ((windowHeight + windowWidth) * 0.015), searchSize, false, KeyEvent.VK_BACK_SLASH, "back", actionListener);
        var changeCard = new PokeButton(changeCardName, PokeButton.CENTER, (int) ((windowHeight + windowWidth) * 0.015), searchSize, false, KeyEvent.VK_BACK_SPACE, "switchCard", actionListener);
        var submitSearch = new PokeButton("Search", PokeButton.CENTER, (int) ((windowHeight + windowWidth) * 0.015), searchSize, false, KeyEvent.VK_ENTER, submitSearchCommand, actionListener);

        this.add(homeCard);
        this.add(changeCard);
        this.add(searchField);
        this.add(submitSearch);
    }

    public JTextField getSearchField() {
        return searchField;
    }
}
