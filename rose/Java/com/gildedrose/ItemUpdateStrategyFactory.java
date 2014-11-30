package com.gildedrose;

public class ItemUpdateStrategyFactory {

    private static final String CONJURED = "Conjured";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public static ItemUpdateStrategy build(String name) {
        ItemUpdateStrategy strategy = new NullUpdateStrategy();
        if (CONJURED.equals(name)) {
            strategy = new ConjuredUpdateStrategy();
        }

        if (SULFURAS_HAND_OF_RAGNAROS.equals(name)) {
            strategy = new SulfurasUpdateStrategy();
        }

        if (AGED_BRIE.equals(name)) {
            strategy = new AgedBrieUpdateStrategy();
        }

        if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(name)) {
            strategy = new BackstagePassesUpdateStrategy();
        }
        return strategy;
    }

}
