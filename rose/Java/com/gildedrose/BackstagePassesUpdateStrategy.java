package com.gildedrose;

public class BackstagePassesUpdateStrategy {

    private static final int QUALITY_INCREASE = 1;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int SELL_IN_DECREASE = 1;

    public void update(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            if (item.quality < MAXIMUM_QUALITY) {
                item.quality += QUALITY_INCREASE;
                if (item.sellIn < 11) {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality += QUALITY_INCREASE;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < MAXIMUM_QUALITY) {
                        item.quality += QUALITY_INCREASE;
                    }
                }
            }
        }
        item.sellIn -= SELL_IN_DECREASE;
    }

}
