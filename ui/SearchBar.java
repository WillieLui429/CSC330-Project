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

        searchSize = new Dimension(searchSize.width / 2, searchSize.height);
        JButton changeCard = new JButton(changeCardName);
        changeCard.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.02)));
        changeCard.setMinimumSize(searchSize);
        changeCard.setPreferredSize(searchSize);
        changeCard.setMaximumSize(searchSize);
        changeCard.setFocusPainted(false);
        changeCard.setMnemonic(KeyEvent.VK_BACK_SPACE);
        changeCard.addActionListener(actionListener);
        changeCard.setActionCommand("switchCard");

        JButton submitSearch = new JButton("Search");
        submitSearch.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.02)));
        submitSearch.setMinimumSize(searchSize);
        submitSearch.setPreferredSize(searchSize);
        submitSearch.setMaximumSize(searchSize);
        submitSearch.setFocusPainted(false);
        submitSearch.setMnemonic(KeyEvent.VK_ENTER);
        submitSearch.addActionListener(actionListener);
        submitSearch.setActionCommand(submitSearchCommand);

        this.add(changeCard);
        this.add(searchField);
        this.add(submitSearch);
    }

    public JTextField getSearchField() {
        return searchField;
    }
}
