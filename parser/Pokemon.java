package parser;

public class Pokemon {
    int id;
    private String name;
    private PokemonType type1;
    private PokemonType type2;
    private String description;

    Pokemon(int id, String name, PokemonType type1, PokemonType type2, String description) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType1() {
        return type1;
    }

    public void setType1(PokemonType type1) {
        this.type1 = type1;
    }

    public PokemonType getType2() {
        return type2;
    }

    public void setType2(PokemonType type2) {
        this.type2 = type2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "parser.Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", description='" + description + '\'' +
                '}';
    }
}
