import parser.PokemonParser;
import ui.PokedexFrame;

import java.io.FileReader;
import java.io.IOException;

public class Pokedex {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please Enter a CSV file and an Image folder for the application");
            return;
        }
        try (var file = new FileReader(args[0])) {
            var parser = new PokemonParser(file);
            var f = new PokedexFrame(parser.parse(), args[1]);
            f.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Please check your file and folder inputs!");
        }
    }
}
