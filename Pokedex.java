import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static java.awt.GridBagConstraints.PAGE_START;
import java.util.Scanner;
public class Pokedex {
    public static void main(String[] args) {
        try (var file = new FileReader("PokemonGen1.csv")) {
            var parser = new PokemonParser(file);
            var f = new PokedexFrame(parser.parse());
            f.setVisible(true);
            Scanner keyboard = new Scanner(System.in);
            String query = keyboard.nextLine();
            var search = new SearchBar(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// TODO: Add Search By ID and Name
// TODO: Add Extra Description
class PokedexFrame extends JFrame implements ActionListener {
    private final int imageWidth = 450;
    private final int imageHeight = 450;
    private final List<Pokemon> pokemonList;
    //private JTextField search;
    //private JButton submitSearch;
    private final JButton leftPokemon;
    private final JButton rightPokemon;
    private final JLabel name;
    private final JLabel icon;
    //private JTextArea description;
    private final JLabel type1;
    private final JLabel type2;
    private int currentPokemon = 0;

    public PokedexFrame(List<Pokemon> pokemonList) {
        setTitle("Pokedex");
        setBounds(0, 0, 1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pokemonList = pokemonList;

        var panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        // Add Icon
        var iconImg = new ImageIcon("icons/pokemon/1.png", "bulbasaur");
        resizeIcon(iconImg, imageWidth, imageHeight);
        icon = new JLabel(iconImg);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(icon, constraints);

        // Add Name
        name = new JLabel("Bulbasaur #001", JLabel.CENTER);
        name.setFont(new Font("Fira Sans", Font.PLAIN, 50));

        constraints.gridx = 0;
        constraints.gridy = 0;
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
        constraints.gridy = 0;
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
        var buttonSize = new int[]{85, 25};
        type1 = new JLabel("GRASS", JLabel.CENTER);
        type1.setMinimumSize(new Dimension(buttonSize[0], buttonSize[1]));
        type1.setPreferredSize(new Dimension(buttonSize[0], buttonSize[1]));
        type1.setMaximumSize(new Dimension(buttonSize[0], buttonSize[1]));
        type1.setOpaque(true);
        type1.setFont(new Font("Fira Sans", Font.PLAIN, 30));
        type1.setForeground(new Color(0xf2eee8));
        type1.setBackground(new Color(0x619333));

        constraints.ipadx = buttonSize[0];
        constraints.ipady = buttonSize[1];
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = PAGE_START;
        constraints.insets = new Insets(20, 10, 0, 0);
        panel.add(type1, constraints);

        type2 = new JLabel("POISON", JLabel.CENTER);
        type2.setMinimumSize(new Dimension(buttonSize[0], buttonSize[1]));
        type2.setPreferredSize(new Dimension(buttonSize[0], buttonSize[1]));
        type2.setMaximumSize(new Dimension(buttonSize[0], buttonSize[1]));
        type2.setOpaque(true);
        type2.setFont(new Font("Fira Sans", Font.PLAIN, 30));
        type2.setForeground(new Color(0xf2eee8));
        type2.setBackground(new Color(0x8e4d7e));

        constraints.gridx = 2;
        panel.add(type2, constraints);

        JTextField textField = new JTextField();
        textField.setSize(8000, 100);
        constraints.gridx =60;
        constraints.gridy =25;
        panel.add(textField,constraints);


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
        if (actionEvent.getSource() == leftPokemon) {
            if (currentPokemon == 0) currentPokemon = pokemonList.size();
            updatePokemon(pokemonList.get(--currentPokemon));
        }
        if (actionEvent.getSource() == rightPokemon) {
            if (currentPokemon == pokemonList.size() - 1) currentPokemon = -1;
            updatePokemon(pokemonList.get(++currentPokemon));
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
    }
    
}
