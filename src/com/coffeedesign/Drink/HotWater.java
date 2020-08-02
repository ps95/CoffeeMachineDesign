package com.coffeedesign.Drink;

import com.coffeedesign.Constants.DrinkNames;
import com.coffeedesign.Constants.IngredientNames;

import java.util.HashMap;
import java.util.Map;

public class HotWater extends DrinkInterface {
    private String name;
    private Map<String, Integer> requirements;

    public HotWater() {
        requirements = setRequirements();
        name = DrinkNames.HOT_WATER;
    }
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Integer> getRequirements() {
        return requirements;
    }

    @Override
    Map<String, Integer> setRequirements() {
        Map<String, Integer> requirementMap = new HashMap<>();
        requirementMap.put(IngredientNames.HOT_WATER, 50);
        return requirementMap;
    }
}
