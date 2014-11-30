package com.gildedrose.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.Item;

public class AgedBrieUpdateStrategyTest {

    private static final int SELL_IN = 1;

    private AgedBrieUpdateStrategy strategy;

    @Before
    public void setUp() {
        strategy = new AgedBrieUpdateStrategy();
    }

    @Test
    public void aged_brie_quality_icreases_by_one_before_sell_in() throws Exception {
        Item item = new Item("Aged Brie", SELL_IN, 49);

        strategy.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void aged_brie_quality_icreases_by_two_after_sell_in() throws Exception {
        Item item = new Item("Aged Brie", 0, 48);

        strategy.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void aged_brie_maximum_quality_is_50() throws Exception {
        Item item = new Item("Aged Brie", SELL_IN, 50);

        strategy.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void aged_brie_sell_in_goes_down_of_1_after_update() throws Exception {
        Item item = new Item("Aged Brie", SELL_IN, 49);

        strategy.update(item);

        assertEquals(SELL_IN - 1, item.sellIn);
    }

}
