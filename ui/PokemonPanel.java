package ui;

import parser.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

import static util.Utility.*;

public class PokemonPanel extends JPanel {
    public PokemonPanel(Pokemon pokemon, int windowWidth, int windowHeight, int imageWidth, int imageHeight, String imageDir, MouseListener mouseListener) {
        this.setName(String.valueOf(pokemon.getId()));
        this.setLayout(new GridLayout());
        this.addMouseListener(mouseListener);

        var buttonSize = new Dimension((int) (windowWidth * 0.09), (int) (windowHeight * 0.05));
        var iconImg = new ImageIcon(getImagePath(imageDir, pokemon.getId()));
        resizeIcon(iconImg, imageWidth / 4, imageHeight / 4);
        var icon = new JLabel(iconImg);
        icon.setPreferredSize(new Dimension(buttonSize.width / 3, (int) (buttonSize.height * 3.5)));
        icon.setMaximumSize(new Dimension(buttonSize.width / 3, (int) (buttonSize.height * 3.5)));
        this.add(icon);

        var id = new JLabel(" #" + idToString(pokemon.getId()), JLabel.CENTER);
        id.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.018)));
        this.add(id);

        var name = new JLabel(pokemon.getName(), JLabel.CENTER);
        name.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.018)));
        this.add(name);

        var type1 = new JLabel(pokemon.getType1().toString(), JLabel.CENTER);
        type1.setOpaque(true);
        type1.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.018)));
        type1.setForeground(new Color(0xf2eee8));
        type1.setBackground(new Color(pokemon.getType1().toColor()));
        this.add(type1);

        var type2 = new JLabel(pokemon.getType2().toString(), JLabel.CENTER);
        type2.setOpaque(true);
        type2.setFont(new Font("Fira Sans", Font.PLAIN, (int) ((windowHeight + windowWidth) * 0.018)));
        type2.setForeground(new Color(0xf2eee8));
        type2.setBackground(new Color(pokemon.getType2().toColor()));
        this.add(type2);
    }

}
