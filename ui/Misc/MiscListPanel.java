package ui.Misc;

import parser.Misc.Misc;
import ui.Abstract.ItemListPanel;
import ui.Abstract.ListItemPanel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class MiscListPanel extends ItemListPanel<Misc> {
    public MiscListPanel(int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, List<Misc> list, ActionListener actionListener, MouseListener mouseListener) {
        super(windowWidth, windowHeight, imageWidth, imageHeight, imageDir, list, actionListener, mouseListener);
    }

    @Override
    public JPanel createListItem(Misc misc, int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, MouseListener mouseListener) {
        return new ListItemPanel<>(misc, windowWidth/2, windowHeight, imageWidth*2, imageHeight*2, (windowHeight+windowWidth)/100, imageDir, mouseListener);
    }
}
