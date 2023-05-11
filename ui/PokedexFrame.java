package ui;

import parser.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import static java.awt.GridBagConstraints.PAGE_START;
import static util.Utility.*;

public class PokedexFrame extends JFrame implements ActionListener, MouseListener {
    private final int windowWidth = 1680;
    private final int windowHeight = 960;
    private final int imageWidth = (int) (windowWidth * 0.41);
    private final int imageHeight = (int) (windowHeight * 0.69);
    private final List<Pokemon> pokemonList;
    private final JButton leftPokemon;
    private final JButton rightPokemon;
    private final JPanel cards;
    private final JLabel name;
    private final JLabel icon;
    private final JLabel type1;
    private final JLabel type2;
    private final JTextArea description;
    private final String imageDir;
    private final SearchBar searchMain;
    private final SearchBar searchList;
    private int currentPokemon = 0;

    public PokedexFrame(List<Pokemon> pokemonList, String imageDir) {
        setTitle("Pokedex");
        setBounds(0, 0, windowWidth, windowHeight);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pokemonList = pokemonList;
        this.imageDir = imageDir;

        var panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        // Add Search Bar
        searchMain = new SearchBar(windowWidth, windowHeight, "To List", "submitSearchMain", this);

        constraints.gridwidth = 3;
        panel.add(searchMain, constraints);
        // Add Icon
        var iconImg = new ImageIcon(getImagePath(imageDir, 1));
        resizeIcon(iconImg, imageWidth, imageHeight);
        icon = new JLabel(iconImg);

        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(icon, constraints);

        // Add Name
        name = new JLabel("Bulbasaur #001", JLabel.CENTER);
        name.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.026)));

        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(name, constraints);

        // Add Navigation Arrows
        var buttonSize = new Dimension((int) (windowWidth * 0.09), (int) (windowHeight * 0.05));
        int arrowSize = (int) ((windowHeight + windowWidth) * 0.02);
        var arrowIcon = new ImageIcon("icons/ui/arrow-left-solid.png");
        resizeIcon(arrowIcon, (int) (arrowSize * 0.875), arrowSize);
        leftPokemon = new JButton(arrowIcon);
        leftPokemon.setMinimumSize(buttonSize);
        leftPokemon.setPreferredSize(buttonSize);
        leftPokemon.setMaximumSize(buttonSize);
        leftPokemon.setFocusPainted(false);
        leftPokemon.setMnemonic(KeyEvent.VK_LEFT);
        leftPokemon.addActionListener(this);

        constraints.ipadx = 65;
        constraints.ipady = 25;
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(leftPokemon, constraints);

        arrowIcon = new ImageIcon("icons/ui/arrow-right-solid.png");
        resizeIcon(arrowIcon, (int) (arrowSize * 0.875), arrowSize);
        rightPokemon = new JButton(arrowIcon);
        rightPokemon.setMinimumSize(buttonSize);
        rightPokemon.setPreferredSize(buttonSize);
        rightPokemon.setMaximumSize(buttonSize);
        rightPokemon.setFocusPainted(false);
        rightPokemon.setMnemonic(KeyEvent.VK_RIGHT);
        rightPokemon.addActionListener(this);

        constraints.gridx = 2;
        panel.add(rightPokemon, constraints);

        // Add parser.Pokemon Types
        type1 = new JLabel("GRASS", JLabel.CENTER);
        type1.setMinimumSize(buttonSize);
        type1.setPreferredSize(buttonSize);
        type1.setMaximumSize(buttonSize);
        type1.setOpaque(true);
        type1.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.018)));
        type1.setForeground(new Color(0xf2eee8));
        type1.setBackground(new Color(0x619333));

        constraints.ipadx = buttonSize.width;
        constraints.ipady = buttonSize.height;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = PAGE_START;
        constraints.insets = new Insets(20, 10, 0, 0);
        panel.add(type1, constraints);

        type2 = new JLabel("POISON", JLabel.CENTER);
        type2.setMinimumSize(buttonSize);
        type2.setPreferredSize(buttonSize);
        type2.setMaximumSize(buttonSize);
        type2.setOpaque(true);
        type2.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.018)));
        type2.setForeground(new Color(0xf2eee8));
        type2.setBackground(new Color(0x8e4d7e));

        constraints.gridx = 2;
        panel.add(type2, constraints);

        // Add Description
        description = new JTextArea("There is a plant seed on its back right from the day this POKéMON is born. The seed slowly grows larger.");
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEnabled(false);
        description.setPreferredSize(new Dimension((int) (buttonSize.width * 2.5), buttonSize.height * 6));
        description.setMaximumSize(new Dimension((int) (buttonSize.width * 2.5), buttonSize.height * 6));
        description.setDisabledTextColor(new Color(0x333333));
        description.setBackground(new Color(0xeeeeee));
        description.setFont(new Font("Fira Sans", Font.ITALIC, (int) ((windowHeight + windowWidth) * 0.016)));
        constraints.gridwidth = 3;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(description, constraints);

        var fullListPanel = new JPanel();
        fullListPanel.setLayout(new BoxLayout(fullListPanel, BoxLayout.Y_AXIS));
        searchList = new SearchBar(windowWidth, windowHeight, "To Main", "submitSearchList", this);

        var listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        for (var pokemon : pokemonList) {
            listPanel.add(new PokemonPanel(pokemon, windowWidth, windowHeight, imageWidth, imageHeight, imageDir, this));
        }
        var scroll = new ScrollPane();
        scroll.add(listPanel);
        fullListPanel.add(searchList);
        fullListPanel.add(scroll);

        cards = new JPanel(new CardLayout());

        cards.add(panel);
        cards.add(fullListPanel);
        getContentPane().add(cards);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        var source = actionEvent.getSource();
        var lay = (CardLayout) cards.getLayout();
        if (source == leftPokemon) {
            if (currentPokemon <= 0) currentPokemon = pokemonList.size();
            updatePokemon(pokemonList.get(--currentPokemon));
            lay.first(cards);
        } else if (source == rightPokemon) {
            if (currentPokemon >= pokemonList.size() - 1) currentPokemon = -1;
            updatePokemon(pokemonList.get(++currentPokemon));
            lay.first(cards);
        } else {
            switch (actionEvent.getActionCommand()) {
                case "submitSearchMain" -> {
                    search(searchMain.getSearchField().getText());
                    lay.first(cards);
                }
                case "submitSearchList" -> {
                    search(searchList.getSearchField().getText());
                    lay.first(cards);
                }
                case "switchCard" -> lay.next(cards);
            }
        }
    }

    private void updatePokemon(Pokemon pokemon) {
        name.setText(pokemon.getName() + " #" + idToString(pokemon.getId()));
        var iconImg = new ImageIcon(getImagePath(imageDir, pokemon.getId()));
        resizeIcon(iconImg, imageWidth, imageHeight);
        icon.setIcon(iconImg);
        type1.setText(pokemon.getType1().toString());
        type1.setBackground(new Color(pokemon.getType1().toColor()));
        type2.setText(pokemon.getType2().toString());
        type2.setBackground(new Color(pokemon.getType2().toColor()));
        description.setText(pokemon.getDescription());
    }

    private void search(String query) {
        if (query.isEmpty()) return;
        if (query.chars().allMatch(Character::isDigit)) {
            int i = Integer.parseInt(query);
            if (i > 0 && i <= pokemonList.size()) {
                currentPokemon = i - 1;
                updatePokemon(pokemonList.get(currentPokemon));
            }
        } else {
            for (var pokemon : pokemonList) {
                if (pokemon.getName().equalsIgnoreCase(query)) {
                    currentPokemon = pokemon.getId() - 1;
                    updatePokemon(pokemon);
                    return;
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var name = ((JPanel) e.getSource()).getName();
        search(name);
        ((CardLayout) cards.getLayout()).first(cards);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        var panel = ((JPanel) e.getSource());
        panel.setBackground(new Color(0x727272));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        var panel = ((JPanel) e.getSource());
        panel.setBackground(new Color(0xeeeeee));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        var panel = ((JPanel) e.getSource());
        panel.setBackground(new Color(0xa2a2a2));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        var panel = ((JPanel) e.getSource());
        panel.setBackground(new Color(0xeeeeee));
    }
}
