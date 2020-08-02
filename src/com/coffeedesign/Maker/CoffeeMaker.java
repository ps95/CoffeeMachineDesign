package com.coffeedesign.Maker;

import com.coffeedesign.Drink.Coffee;
import com.coffeedesign.Drink.DrinkInterface;
import com.coffeedesign.Drink.ElaichiTea;
import com.coffeedesign.Drink.GingerTea;
import com.coffeedesign.Drink.HotMilk;
import com.coffeedesign.Drink.HotWater;
import com.coffeedesign.Stock.StockKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoffeeMaker {
    private StockKeeper stockKeeper;
    private List<DrinkInterface> beverages;
    private static String successMessage = "%s is prepared";
    private static String failureMessage = "%s cannot be prepared becaused item %s is not available";


    // Keep this as push model for now as there is only one observer. We can use a traditional observer pattern if observers>=2
    public CoffeeMaker(final StockKeeper stockKeeper) {
        this.stockKeeper = stockKeeper;
        beverages = new ArrayList<>();
        loadBeverages();
    }

    public List<String> make() {
        /**although there are parallel outlets, stock should have a lock to make it truly parallel. So keeping it serial.
         * Since it's unclear in the doc to infinitely keep producing drinks if stock is available, keeping this as one loop.If we still want parallel, will have to make StockKeeper class singleton.
         */
        List<String> preparedBeverages = new ArrayList<>();
        for(DrinkInterface drink: beverages) {
            if(makeBeverage(drink)) {
                preparedBeverages.add(drink.getName());
            }
        }
        stockKeeper.printStock();
        return preparedBeverages;
    }

    private boolean makeBeverage(final DrinkInterface drink) {
        for(Map.Entry<String, Integer> ingredient: drink.getRequirements().entrySet()) {
            if(!stockKeeper.checkIfExist(ingredient.getKey(), ingredient.getValue())) {
                System.out.println(String.format(failureMessage, drink.getName(), ingredient.getKey()));
                return false;
            }
        }
        for(Map.Entry<String, Integer> ingredient: drink.getRequirements().entrySet()) {
            stockKeeper.reduceStock(ingredient.getKey(), ingredient.getValue());
        }
        System.out.println(String.format(successMessage, drink.getName()));
        return true;
    }

    private void loadBeverages() {
        beverages.add(new Coffee());
        beverages.add(new ElaichiTea());
        beverages.add(new GingerTea());
        beverages.add(new HotWater());
        beverages.add(new HotMilk());
    }

}
