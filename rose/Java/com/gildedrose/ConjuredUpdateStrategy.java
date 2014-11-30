package com.gildedrose;

public class ConjuredUpdateStrategy {

    private static final int SELL_IN_DECREASE = 1;

    public void update(Item item) {
        if (item.quality > 0) {
            item.quality -= 2 * SELL_IN_DECREASE;
            if (item.sellIn <= 0) {
                item.quality -= 2 * SELL_IN_DECREASE;
            }
            item.sellIn -= SELL_IN_DECREASE;
        }
    }
}