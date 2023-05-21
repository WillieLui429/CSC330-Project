package ui.Town;

import parser.Town.Town;
import ui.Abstract.ItemListPanel;
import ui.Abstract.ListItemPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class TownListPanel extends ItemListPanel<Town> {
    public TownListPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, List<Town> list, ActionListener actionListener, MouseListener mouseListener) {
        super(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, list, actionListener, mouseListener);
    }

    @Override
    public JPanel createListItem(Town town, int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, MouseListener mouseListener) {
        var listItem = new ListItemPanel<>(town, windowWidth, windowHeight, imageWidth, imageHeight, imageDir, mouseListener);
        var population = new PopulationLabel(town.getPopulation() + " Population", windowWidth, windowHeight, listItem.getButtonSize());
        listItem.add(population);
        return listItem;
    }
}
