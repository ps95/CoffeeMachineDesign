package com.coffeedesign.Drink;

import com.coffeedesign.Constants.DrinkNames;
import com.coffeedesign.Constants.IngredientNames;

import java.util.HashMap;
import java.util.Map;

public class ElaichiTea extends DrinkInterface {

    private String name;
    private Map<String, Integer> requirements;

    public ElaichiTea() {
        requirements = setRequirements();
        name = DrinkNames.ELAICHI_TEA;
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
        requirementMap.put(IngredientNames.HOT_MILK, 10);
        requirementMap.put(IngredientNames.TEA_SYRUP, 10);
        requirementMap.put(IngredientNames.ELAICHI_SYRUP, 5);
        requirementMap.put(IngredientNames.SUGAR_SYRUP, 10);
        return requirementMap;
    }
}
