import parser.Abstract.Parser;
import parser.Misc.MiscParser;
import parser.Pokemon.PokemonParser;
import parser.Town.TownParser;
import ui.PokedexFrame;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Pokedex {
    public static void main(String[] args) {
        // Inputs in my configuration are "csv/pokemon.csv csv/town.csv csv/misc.csv icons/pokemon icons/towns icons/misc"
        if (args.length < 6) {
            System.out.println("Please Enter a CSV file and an Image folder for the Pokemon and the Towns\n" +
                    "Format: pokedex pokemon.csv town.csv misc.csv pokemon_images/ town_images/ misc_images/\n");
            return;
        }
        try (var pokemonFile = new FileReader(args[0]); var townFile = new FileReader(args[1]); var miscFile = new FileReader(args[2])) {
            // Converted into lists for convenience, preferably all of this would be moved to a menu
            var parsedLists =
                    Stream.of(new PokemonParser(pokemonFile), new TownParser(townFile), new MiscParser(miscFile)).map(Parser::parse).toList();
            int windowWidth = 1680;
            int windowHeight = 960;
            var f = new PokedexFrame(windowWidth, windowHeight, parsedLists, Arrays.stream(args).skip(3).toList());
            f.setVisible(true);
        } catch (IOException e) {
            System.out.println("Please check your file and folder inputs!");
        }
    }
}
