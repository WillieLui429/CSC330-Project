package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class PokemonParser {
    private final List<String> lines;

    public PokemonParser(FileReader fileReader) {
        this.lines = new BufferedReader(fileReader).lines().toList();
    }

    public List<Pokemon> parse() {
        return lines.stream().map(this::parsePokemon).toList();
    }

    private PokemonType stringToPokemonType(String str) {
        return switch (str) {
            case "Bug" -> PokemonType.BUG;
            case "Dark" -> PokemonType.DARK;
            case "Dragon" -> PokemonType.DRAGON;
            case "Electric" -> PokemonType.ELECTRIC;
            case "Fairy" -> PokemonType.FAIRY;
            case "Fight" -> PokemonType.FIGHTING;
            case "Fire" -> PokemonType.FIRE;
            case "Flying" -> PokemonType.FLIGHT;
            case "Ghost" -> PokemonType.GHOST;
            case "Grass" -> PokemonType.GRASS;
            case "Ground" -> PokemonType.GROUND;
            case "Ice" -> PokemonType.ICE;
            case "Normal" -> PokemonType.NORMAL;
            case "Poison" -> PokemonType.POISON;
            case "Psychic" -> PokemonType.PSYCHIC;
            case "Rock" -> PokemonType.ROCK;
            case "Steel" -> PokemonType.STEEL;
            case "Water" -> PokemonType.WATER;
            // case "None" -> parser.PokemonType.NONE;
            default -> PokemonType.NONE;
        };
    }

    private Pokemon parsePokemon(String str) {
        var arr = str.split(",");
        return new Pokemon(Integer.parseInt(arr[0]), arr[1], stringToPokemonType(arr[2]), stringToPokemonType(arr[3]), str.split("\"")[1]);
    }
}
