package com.gildedrose.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.Item;

public class ConjuredUpdateStrategyTest {

    private static final int QUALITY = 80;
    private static final int SELL_IN = 1;
    private static final int LOWEST_QUALITY = 0;

    private ConjuredUpdateStrategy strategy;

    @Before
    public void setUp() {
        strategy = new ConjuredUpdateStrategy();
    }

    @Test
    public void conjured_quality_degrades_by_one_before_sell_in() {
        Item item = new Item("Conjured", SELL_IN, QUALITY);

        strategy.update(item);

        assertEquals(QUALITY - 2, item.quality);
    }

    @Test
    public void conjured_quality_degrades_by_two_after_sell_in() {
        Item item = new Item("Conjured", 0, QUALITY);

        strategy.update(item);

        assertEquals(QUALITY - 4, item.quality);
    }

    @Test
    public void conjured_quality_never_goes_below_0() {
        Item item = new Item("Conjured", 0, LOWEST_QUALITY);

        strategy.update(item);

        assertEquals(LOWEST_QUALITY, item.quality);
    }

    @Test
    public void conjured_sell_in_goes_down_of_1_after_update() {
        Item item = new Item("Conjured", SELL_IN, QUALITY);

        strategy.update(item);

        assertEquals(SELL_IN - 1, item.sellIn);
    }

}