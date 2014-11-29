package com.gildedrose;

class GildedRose {
    private static final String CONJURED = "Conjured";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private static final int STANDARD_MAXIMUM_QUALITY = 50;
    private static final int STANDARD_SELL_IN_DECREASE = 1;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (CONJURED.equals(item.name)) {
                if (item.quality > 0) {
                    item.quality = item.quality - 2 * STANDARD_SELL_IN_DECREASE;
                    if (item.sellIn <= 0) {
                        item.quality = item.quality - 2 * STANDARD_SELL_IN_DECREASE;
                    }
                    item.sellIn -= STANDARD_SELL_IN_DECREASE;
                }
                continue;
            }

            if (SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
                continue;
            }

            if (AGED_BRIE.equals(item.name)) {
                if (item.quality < STANDARD_MAXIMUM_QUALITY) {
                    item.quality = item.quality + 1;
                    if (item.sellIn <= 0) {
                        item.quality = item.quality + 1;
                    }
                    item.sellIn -= STANDARD_SELL_IN_DECREASE;
                }
                continue;
            }

            if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(item.name)) {
                if (item.sellIn < 0) {
                    item.quality = item.quality - item.quality;
                } else {
                    if (item.quality < STANDARD_MAXIMUM_QUALITY) {
                        item.quality = item.quality + 1;
                        if (item.sellIn < 11) {
                            if (item.quality < STANDARD_MAXIMUM_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < STANDARD_MAXIMUM_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
                continue;
            }
        }
    }
}
