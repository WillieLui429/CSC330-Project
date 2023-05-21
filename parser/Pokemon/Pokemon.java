package parser.Pokemon;

import parser.Abstract.Item;

public class Pokemon extends Item {
    private final PokemonType type1;
    private final PokemonType type2;
    private final String description;

    Pokemon(int id, String name, PokemonType type1, PokemonType type2, String description) {
        super(id, name);
        this.type1 = type1;
        this.type2 = type2;
        this.description = description;
    }

    public PokemonType getType1() {
        return type1;
    }

    public PokemonType getType2() {
        return type2;
    }

    public String getDescription() {
        return description;
    }
}
