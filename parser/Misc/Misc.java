package parser.Misc;

import parser.Abstract.Item;

public class Misc extends Item {
    private final String description;

    public Misc(int id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
