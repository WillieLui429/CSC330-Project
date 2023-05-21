package parser.Pokemon;

public enum PokemonType {
    BUG,
    DARK,
    DRAGON,
    ELECTRIC,
    FAIRY,
    FIGHTING,
    FIRE,
    FLIGHT,
    GHOST,
    GRASS,
    GROUND,
    ICE,
    NONE,
    NORMAL,
    POISON,
    PSYCHIC,
    ROCK,
    STEEL,
    WATER;

    public int toColor() {
        return switch (this) {
            case BUG -> 0x909c26;
            case DARK -> 0x654b3d;
            case DRAGON -> 0x26178b;
            case ELECTRIC -> 0x88690b;
            case FAIRY -> 0x6e1a6c;
            case FIGHTING -> 0x9b4c3e;
            case FIRE -> 0xba250a;
            case FLIGHT -> 0x08187b;
            case GHOST -> 0x403f82;
            case GRASS -> 0x619333;
            case GROUND -> 0x725e1f;
            case ICE -> 0x0b6591;
            case NONE -> 0x323234;
            case NORMAL -> 0x555a5c;
            case POISON -> 0x8e4d7e;
            case PSYCHIC -> 0x9b0a43;
            case ROCK -> 0x665c32;
            case STEEL -> 0x4b5052;
            case WATER -> 0x0b5dae;
        };
    }
}
