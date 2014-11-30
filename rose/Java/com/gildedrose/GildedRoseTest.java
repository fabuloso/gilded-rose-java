package com.gildedrose;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    private static final int QUALITY = 80;

    private static final int SELL_IN = 1;

    @Test
    public void aged_brie_quality_icreases_by_one_before_sell_in() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", SELL_IN, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void aged_brie_quality_icreases_by_two_after_sell_in() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void aged_brie_maximum_quality_is_50() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", SELL_IN, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void aged_brie_sell_in_goes_down_of_1_after_update() throws Exception {
        Item[] items = new Item[] { new Item("Aged Brie", SELL_IN, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SELL_IN - 1, app.items[0].sellIn);
    }

    @Test
    public void backstage_passes_quality_is_0_after_sell_in() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_when_sellin_is_greater_than_10() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(49, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_when_sellin_is_equal_or_lower_than_5() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_increases_by_one_when_sellin_is_equal_or_lower_than_10() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstage_passes_maximum_quality_is_50() throws Exception {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", SELL_IN, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstage_passes_sell_in_goes_down_of_1_after_update() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", SELL_IN, QUALITY) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(SELL_IN - 1, app.items[0].sellIn);
    }
}
