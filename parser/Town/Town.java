package parser.Town;

import parser.Abstract.Item;

public class Town extends Item {
    private final int population;
    private final String description;

    public Town(int id, String name, int population, String description) {
        super(id, name);
        this.population = population;
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public String getDescription() {
        return description;
    }
}
