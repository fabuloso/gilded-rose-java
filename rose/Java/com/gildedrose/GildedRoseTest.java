package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    private static final int QUALITY = 80;
    private static final int LOWEST_QUALITY = 0;

	@Test
    public void conjured_item_quality_degrades_by_one_before_sell_in() {
        Item[] items = new Item[] { new Item("Conjured", 1, QUALITY) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(QUALITY - 2, app.items[0].quality);
    }
    
    @Test
    public void conjured_item_quality_degrades_by_two_after_sell_in() {
        Item[] items = new Item[] { new Item("Conjured", 0, 80) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(QUALITY - 4, app.items[0].quality);
    }
    
    @Test
    public void conjured_item_quality_never_goes_below_0() {
        Item[] items = new Item[] { new Item("Conjured", 0, LOWEST_QUALITY) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals(LOWEST_QUALITY, app.items[0].quality);
    }

}
