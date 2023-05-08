public class Pokemon {
    int id;
    String name;
    PokemonType type1;
    PokemonType type2;
    String description;

    Pokemon(int id, String name, PokemonType type1, PokemonType type2, String description) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", description='" + description + '\'' +
                '}';
    }
}
