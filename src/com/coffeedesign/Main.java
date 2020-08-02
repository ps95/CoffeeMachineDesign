package com.coffeedesign;

import com.coffeedesign.Maker.CoffeeMaker;
import com.coffeedesign.Stock.StockKeeper;

public class Main {

    public static void main(String[] args) {
        // This is the entry point of the application which uses harcoded values as given in input. For custom values, refer tst section.
        CoffeeMaker coffeeMaker = new CoffeeMaker(new StockKeeper());
        coffeeMaker.make();
    }
}
