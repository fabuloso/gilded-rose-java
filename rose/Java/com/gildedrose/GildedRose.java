package com.gildedrose;

class GildedRose {
    private static final String CONJURED = "Conjured";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (CONJURED.equals(item.name)) {
                ConjuredUpdateStrategy strategy = new ConjuredUpdateStrategy();
                strategy.update(item);
                continue;
            }

            if (SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
                SulfurasUpdateStrategy strategy = new SulfurasUpdateStrategy();
                strategy.update(item);
                continue;
            }

            if (AGED_BRIE.equals(item.name)) {
                AgedBrieUpdateStrategy strategy = new AgedBrieUpdateStrategy();
                strategy.update(item);
                continue;
            }

            if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(item.name)) {
                BackstagePassesUpdateStrategy strategy = new BackstagePassesUpdateStrategy();
                strategy.update(item);
                continue;
            }
        }
    }
}
