package com.coffeedesign.Stock;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockKeeper {

    public Map<String, Ingredient> getIngredientMap() {
        return ingredientMap;
    }

    private Map<String, Ingredient> ingredientMap;

    public StockKeeper() {
        ingredientMap = new HashMap<>();
        loadIngredientMap();
    }

    private void loadIngredientMap() {
        List<Ingredient> ingredients = getIngredients();
        for(Ingredient ingredient: ingredients) {
            ingredientMap.put(ingredient.getName(), ingredient);
        }
        Gson gson = new Gson();
        System.out.println("Ingredient map at beginning = " +gson.toJson(ingredientMap));
    }

    @VisibleForTesting
    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new GingerSyrup());
        ingredients.add(new HotMilk());
        ingredients.add(new HotWater());
        ingredients.add(new SugarSyrup());
        ingredients.add(new TeaSyrup());
        return ingredients;
    }

    public void reduceStock(final String name, final int quantity) {
        if(ingredientMap.containsKey(name)) {
            Ingredient ingredient = ingredientMap.get(name);
            ingredient.setQuantity(ingredient.getQuantity() - quantity);
            ingredientMap.put(name, ingredient);
        }

    }
    @VisibleForTesting
    public boolean checkIfExist(final String name, final int quantity) {
        return ingredientMap.containsKey(name) && ingredientMap.get(name).getQuantity()>=0;
    }

    public void printStock() {
        Gson gson = new Gson();
        System.out.println("Ingredient map = " +gson.toJson(ingredientMap));
    }
}
