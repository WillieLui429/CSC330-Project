package ui;

import parser.Abstract.Item;
import parser.Misc.Misc;
import parser.Pokemon.Pokemon;
import parser.Town.Town;
import ui.Misc.MiscPanel;
import ui.Pokemon.PokemonPanel;
import ui.Town.TownPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PokedexFrame extends JFrame implements ActionListener {
    private final CardLayout cardLayout;
    private final JPanel cards;
    private final PokemonPanel pokemonPanel;
    private final TownPanel townPanel;
    private final MiscPanel miscPanel;

    public PokedexFrame(int windowWidth, int windowHeight, List<? extends List<? extends Item>> itemLists, List<String> imageDirs) {
        this.setTitle("Pokedex");
        this.setBounds(0, 0, windowWidth, windowHeight);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        var name = new PokeLabel("Pokedex", PokeLabel.CENTER, (windowWidth + windowHeight) / 10);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        class AlignedPokeButton extends PokeButton {
            public AlignedPokeButton(String text, String actionCommand, ActionListener actionListener) {
                super(text, PokeButton.CENTER, (windowWidth + windowHeight) / 25, actionCommand, actionListener);
                var buttonSize = new Dimension((int) (windowWidth * 0.45), (int) (windowHeight * 0.15));
                this.setAlignmentX(Component.CENTER_ALIGNMENT);
                this.setMaximumSize(buttonSize);
                this.setMinimumSize(buttonSize);
                this.setPreferredSize(buttonSize);
            }
        }

        var pokemonButton = new AlignedPokeButton("Pokemon", "toPokemon", this);
        panel.add(pokemonButton);
        panel.add(Box.createRigidArea(new Dimension(0,20)));

        var townButton = new AlignedPokeButton("Towns", "toTown", this);
        panel.add(townButton);
        panel.add(Box.createRigidArea(new Dimension(0,20)));

        var miscButton = new AlignedPokeButton("Miscellaneous", "toMisc", this);
        panel.add(miscButton);

        pokemonPanel = new PokemonPanel(windowWidth, windowHeight, (List<Pokemon>) itemLists.get(0), imageDirs.get(0), this);
        townPanel = new TownPanel(windowWidth, windowHeight, (List<Town>) itemLists.get(1), imageDirs.get(1), this);
        miscPanel = new MiscPanel(windowWidth, windowHeight, (List<Misc>) itemLists.get(2), imageDirs.get(2), this);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.add(panel);
        cards.add(pokemonPanel);
        cards.add(townPanel);
        cards.add(miscPanel);

        getContentPane().add(cards);
    }

    public void toMainMenu() {
        cardLayout.first(cards);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()) {
            case "toPokemon" -> {
                cardLayout.first(cards);
                cardLayout.next(cards);
            }
            case "toTown" -> {
                cardLayout.first(cards);
                cardLayout.next(cards);
                cardLayout.next(cards);
            }
            case "toMisc" -> cardLayout.last(cards);
            default -> {
            }
        }
    }
}
