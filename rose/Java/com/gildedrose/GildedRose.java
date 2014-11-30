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
        ItemUpdateStrategy strategy = new NullStrategy();
        for (Item item : items) {
            if (CONJURED.equals(item.name)) {
                strategy = new ConjuredUpdateStrategy();
            }

            if (SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
                strategy = new SulfurasUpdateStrategy();
            }

            if (AGED_BRIE.equals(item.name)) {
                strategy = new AgedBrieUpdateStrategy();
            }

            if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(item.name)) {
                strategy = new BackstagePassesUpdateStrategy();
            }
            strategy.update(item);
        }
    }
}
