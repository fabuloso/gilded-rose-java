package com.gildedrose.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.Item;

public class SulfurasUpdateStrategyTest {

    private static final int QUALITY = 80;
    private static final int SELL_IN = 1;

    private Item item;
    private SulfurasUpdateStrategy strategy;

    @Before
    public void setUp() {
        item = new Item("Sulfuras, Hand of Ragnaros", SELL_IN, QUALITY);
        strategy = new SulfurasUpdateStrategy();
    }

    @Test
    public void sulfuras_quality_is_always_80() {
        strategy.update(item);

        assertEquals(QUALITY, item.quality);
    }

    @Test
    public void sulfuras_sell_in_never_decreases() {
        strategy.update(item);

        assertEquals(SELL_IN, item.sellIn);
    }

}
