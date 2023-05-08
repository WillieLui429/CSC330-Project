import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.awt.GridBagConstraints.PAGE_START;

public class Pokedex {
    public static void main(String[] args) {
        try (var file = new FileReader("PokemonGen1.csv")) {
            var parser = new PokemonParser(file);
            var f = new PokedexFrame(parser.parse());
            f.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// TODO: List View 'JList', Rely on Cards
// TODO: Extra Information 'JButton', Rely on Cards
class PokedexFrame extends JFrame implements ActionListener {
    private final int imageWidth = 450;
    private final int imageHeight = 450;
    private final List<Pokemon> pokemonList;
    private final JButton leftPokemon;
    private final JButton rightPokemon;
    private final JLabel name;
    private final JLabel icon;
    private final JLabel type1;
    private final JLabel type2;
    private final JTextArea description;
    private final JTextField search;
    private final JButton submitSearch;
    private int currentPokemon = 0;

    public PokedexFrame(List<Pokemon> pokemonList) {
        setTitle("Pokedex");
        setBounds(0, 0, 1100, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pokemonList = pokemonList;

        var panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        // Add Search Bar
        var searchSize = new Dimension(400, 50);
        var searchPanel = new JPanel();
        search = new JTextField("");
        search.setToolTipText("Search ID or Name");
        search.setMinimumSize(searchSize);
        search.setPreferredSize(searchSize);
        search.setMaximumSize(searchSize);
        search.setFont(new Font("Fira Sans", Font.PLAIN, 30));
        searchPanel.add(search);

        submitSearch = new JButton("Search");
        submitSearch.setFont(new Font("Fira Sans", Font.PLAIN, 30));
        submitSearch.setFocusPainted(false);
        submitSearch.setMnemonic(KeyEvent.VK_ENTER);
        submitSearch.addActionListener(this);
        searchPanel.add(submitSearch);

        constraints.gridwidth = 3;
        panel.add(searchPanel, constraints);
        // Add Icon
        var iconImg = new ImageIcon("icons/pokemon/1.png", "bulbasaur");
        resizeIcon(iconImg, imageWidth, imageHeight);
        icon = new JLabel(iconImg);

        constraints.gridheight = 2;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(icon, constraints);

        // Add Name
        name = new JLabel("Bulbasaur #001", JLabel.CENTER);
        name.setFont(new Font("Fira Sans", Font.PLAIN, 50));

        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(name, constraints);

        // Add Navigation Arrows
        var arrowSize = 40;
        var arrowIcon = new ImageIcon("icons/ui/arrow-left-solid.png");
        resizeIcon(arrowIcon, (int) (arrowSize * 0.875), arrowSize);
        leftPokemon = new JButton(arrowIcon);
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
        rightPokemon.setFocusPainted(false);
        rightPokemon.setMnemonic(KeyEvent.VK_RIGHT);
        rightPokemon.addActionListener(this);

        constraints.gridx = 2;
        panel.add(rightPokemon, constraints);

        // Add Pokemon Types
        var buttonSize = new Dimension(100, 35);
        type1 = new JLabel("GRASS", JLabel.CENTER);
        type1.setMinimumSize(buttonSize);
        type1.setPreferredSize(buttonSize);
        type1.setMaximumSize(buttonSize);
        type1.setOpaque(true);
        type1.setFont(new Font("Fira Sans", Font.PLAIN, 30));
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
        type2.setFont(new Font("Fira Sans", Font.PLAIN, 30));
        type2.setForeground(new Color(0xf2eee8));
        type2.setBackground(new Color(0x8e4d7e));

        constraints.gridx = 2;
        panel.add(type2, constraints);

        // Add Description
        description = new JTextArea("There is a plant seed on its back right from the day this POKéMON is born. The seed slowly grows larger.");
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEnabled(false);
        description.setPreferredSize(new Dimension((int) ((int) buttonSize.width*2.5), buttonSize.height*6));
        description.setMaximumSize(new Dimension((int) ((int) buttonSize.width*2.5), buttonSize.height*6));
        description.setDisabledTextColor(new Color(0x333333));
        description.setBackground(new Color(0xeeeeee));
        description.setFont(new Font("Fira Sans", Font.ITALIC, 36));
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(description, constraints);

        getContentPane().add(panel);
    }

    private void resizeIcon(ImageIcon imgIcon, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(imgIcon.getImage(), 0, 0, w, h, null);
        g2.dispose();
        imgIcon.setImage(resizedImg);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        var source = actionEvent.getSource();
        if (source == leftPokemon) {
            if (currentPokemon <= 0) currentPokemon = pokemonList.size();
            updatePokemon(pokemonList.get(--currentPokemon));
        } else if (source == rightPokemon) {
            if (currentPokemon >= pokemonList.size() - 1) currentPokemon = -1;
            updatePokemon(pokemonList.get(++currentPokemon));
        } else if (source == submitSearch) {
            search(search.getText());
        }
    }

    private void updatePokemon(Pokemon pokemon) {
        name.setText(pokemon.name + " #" + ((pokemon.id < 10) ? "00" + pokemon.id : (pokemon.id < 100) ? "0" + pokemon.id : pokemon.id));
        var iconImg = new ImageIcon("icons/pokemon/" + pokemon.id + ".png");
        resizeIcon(iconImg, imageWidth, imageHeight);
        icon.setIcon(iconImg);
        type1.setText(pokemon.type1.toString());
        type1.setBackground(new Color(pokemon.type1.toColor()));
        type2.setText(pokemon.type2.toString());
        type2.setBackground(new Color(pokemon.type2.toColor()));
        description.setText(pokemon.description);
    }

    private void search(String query) {
        if (query.isEmpty()) return;
        if (query.chars().allMatch(Character::isDigit)) {
            int i = Integer.parseInt(query);
            if (i > 0 && i < pokemonList.size()) {
                currentPokemon = i - 1;
                updatePokemon(pokemonList.get(currentPokemon));
            }
        } else {
            for (var pokemon : pokemonList) {
                if (pokemon.name.equals(query)) {
                    currentPokemon = pokemon.id - 1;
                    updatePokemon(pokemon);
                    return;
                }
            }
        }
    }
}
