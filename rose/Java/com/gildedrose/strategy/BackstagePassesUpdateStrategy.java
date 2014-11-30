package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassesUpdateStrategy extends ItemUpdateStrategy {

    private static final int QUALITY_INCREASE = 1;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int SELL_IN_DECREASE = 1;

    @Override
    public void update(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        if (item.quality < MAXIMUM_QUALITY) {
            updateQuality(item);
        }
        decreaseSellIn(item);
    }

    @Override
    protected void updateQuality(Item item) {
        int increaseFactor = increaseFactor(item);
        item.quality += increaseFactor * QUALITY_INCREASE;
    }

    private int increaseFactor(Item item) {
        int increaseFactor = 1;
        if (item.sellIn < 11) {
            if (item.quality < MAXIMUM_QUALITY) {
                increaseFactor += 1;
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < MAXIMUM_QUALITY) {
                increaseFactor += 1;
            }
        }
        return increaseFactor;
    }

    @Override
    protected void decreaseSellIn(Item item) {
        item.sellIn -= SELL_IN_DECREASE;
    }
}
