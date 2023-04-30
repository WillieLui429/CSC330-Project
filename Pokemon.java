public class Pokemon {
    int id;
    String name;
    PokemonType type1;
    PokemonType type2;

    Pokemon(int id, String name, PokemonType type1, PokemonType type2) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                '}';
    }
}
