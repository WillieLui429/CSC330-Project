package ui.Pokemon;

import parser.Pokemon.Pokemon;
import ui.Abstract.ItemListPanel;
import ui.Abstract.ListItemPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class PokemonListPanel extends ItemListPanel<Pokemon> {
    public PokemonListPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, List<Pokemon> list, ActionListener actionListener, MouseListener mouseListener) {
        super(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, list, actionListener, mouseListener);
    }

    @Override
    public JPanel createListItem(Pokemon pokemon, int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, MouseListener mouseListener) {
        var listItem = new ListItemPanel<>(pokemon, windowWidth, windowHeight, imageWidth, imageHeight, imageDir, mouseListener);
        var type1 = new PokemonTypeLabel(windowWidth, windowHeight, listItem.getButtonSize(), pokemon.getType1().toString(), pokemon.getType1().toColor());
        listItem.add(type1);
        var type2 = new PokemonTypeLabel(windowWidth, windowHeight, listItem.getButtonSize(), pokemon.getType2().toString(), pokemon.getType2().toColor());
        listItem.add(type2);
        return listItem;
    }
}
