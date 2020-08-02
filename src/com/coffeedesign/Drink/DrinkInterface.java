package com.coffeedesign.Drink;

import java.util.Map;

public abstract class DrinkInterface {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Map<String, Integer> getRequirements() {
        return requirements;
    }

    public void setRequirements(Map<String, Integer> requirements) {
        this.requirements = requirements;
    }

    abstract Map<String, Integer> setRequirements();

    // requirements will be hardcoded as of now according to https://www.npoint.io/docs/e8cd5a9bbd1331de326a.
    private Map<String, Integer> requirements;
}
