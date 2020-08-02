package com.coffeedesign.Maker;

import com.coffeedesign.Constants.IngredientNames;
import com.coffeedesign.Stock.GingerSyrup;
import com.coffeedesign.Stock.HotWater;
import com.coffeedesign.Stock.Ingredient;
import com.coffeedesign.Stock.StockKeeper;
import com.coffeedesign.Stock.SugarSyrup;
import com.coffeedesign.Stock.TeaSyrup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMakerTest {

    @Mock
    private StockKeeper stockKeeper;

    @InjectMocks
    private CoffeeMaker coffeeMaker;

    @Test
    public void testNoBeveragesPossible() {
        Mockito.when(stockKeeper.checkIfExist(anyString(), anyInt())).thenReturn(false);
        List<String> beverages = coffeeMaker.make();
        Assert.assertEquals(0, beverages.size());
    }

    @Test
    public void testAllBeveragesPossible() {
        Mockito.when(stockKeeper.checkIfExist(anyString(), anyInt())).thenReturn(true);
        List<String> beverages = coffeeMaker.make();
        Assert.assertEquals(5, beverages.size());
    }
    @Test
    public void testBeveragesWithoutMilkPossible() {
        //need to mock noth cases because constructor is not getting executed on creating mock. For that also to happen, we need powermock.
        Mockito.when(stockKeeper.checkIfExist(eq(IngredientNames.HOT_MILK), anyInt())).thenReturn(false);
        Mockito.when(stockKeeper.checkIfExist(eq(IngredientNames.HOT_WATER), anyInt())).thenReturn(true);
        List<String> beverages = coffeeMaker.make();
        //Only hot water is possible
        Assert.assertEquals(1, beverages.size());
    }

    private List<Ingredient> getIngredientsWithoutMilk() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new GingerSyrup());
        ingredients.add(new HotWater());
        ingredients.add(new SugarSyrup());
        ingredients.add(new TeaSyrup());
        return ingredients;
    }

}