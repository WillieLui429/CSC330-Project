package ui.Abstract;

import parser.Abstract.Item;
import ui.PokedexFrame;
import ui.SearchBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public abstract class TypePanel<T extends Item> extends JPanel implements ActionListener, MouseListener {
    protected final List<T> list;
    private final PokedexFrame pokedexFrame;
    protected CardLayout cardLayout;
    protected DisplayPanel<T> displayPanel;
    protected int currentItem = 0;
    protected int imageWidth;
    protected int imageHeight;
    protected String imageDir;

    public TypePanel(int windowWidth, int windowHeight, List<T> list, String imageDir, PokedexFrame pokedexFrame) {
        this.list = list;
        this.imageWidth = (int) (windowWidth * 0.41);
        this.imageHeight = (int) (windowHeight * 0.69);
        this.imageDir = imageDir;
        this.pokedexFrame = pokedexFrame;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        var source = actionEvent.getSource();
        switch (actionEvent.getActionCommand()) {
            case "submitSearchMain", "submitSearchList" -> {
                var search = (SearchBar) ((JButton) source).getParent();
                search(search.getSearchField().getText());
                cardLayout.first(this);
            }
            case "left" -> {
                if (currentItem <= 0) currentItem = list.size();
                displayPanel.update(list.get(--currentItem));
                cardLayout.first(this);
            }
            case "right" -> {
                if (currentItem >= list.size() - 1) currentItem = -1;
                displayPanel.update(list.get(++currentItem));
                cardLayout.first(this);
            }
            case "back" -> {
                pokedexFrame.toMainMenu();
            }
            case "switchCard" -> cardLayout.next(this);
            default -> {
            }
        }
    }

    protected void search(String query) {
        if (query.isEmpty()) return;
        if (query.chars().allMatch(Character::isDigit)) {
            int i = Integer.parseInt(query);
            if (i > 0 && i <= list.size()) {
                currentItem = i - 1;
                displayPanel.update(list.get(currentItem));
            }
        } else {
            for (var item : list) {
                if (item.getName().equalsIgnoreCase(query)) {
                    currentItem = item.getId() - 1;
                    displayPanel.update(item);
                    return;
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        var panel = (JPanel) e.getSource();
        search(panel.getName());
        cardLayout.first(this);
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
