package com.gildedrose.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gildedrose.Item;

public class BackstagePassesUpdateStrategyTest {

    private static final int QUALITY = 80;
    private static final int SELL_IN = 1;

    private BackstagePassesUpdateStrategy strategy;

    @Before
    public void setUp() {
        strategy = new BackstagePassesUpdateStrategy();
    }

    @Test
    public void backstage_passes_quality_is_0_after_sell_in() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49);

        strategy.update(item);

        assertEquals(0, item.quality);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_when_sellin_is_greater_than_10() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 48);

        strategy.update(item);

        assertEquals(49, item.quality);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_when_sellin_is_equal_or_lower_than_5() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);

        strategy.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_when_sellin_is_equal_or_lower_than_10() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48);

        strategy.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void backstage_passes_maximum_quality_is_50() throws Exception {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", SELL_IN, 50);

        strategy.update(item);

        assertEquals(50, item.quality);
    }

    @Test
    public void backstage_passes_sell_in_goes_down_of_1_after_update() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", SELL_IN, QUALITY);

        strategy.update(item);

        assertEquals(SELL_IN - 1, item.sellIn);
    }
}
