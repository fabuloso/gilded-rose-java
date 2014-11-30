package com.gildedrose;

public class ConjuredUpdateStrategy extends ItemUpdateStrategy {

    private static final int SELL_IN_DECREASE = 1;

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            updateQuality(item);
        }
        decreaseSellIn(item);
    }

    private void updateQuality(Item item) {
        int decreaseFactor = 2;
        if (item.sellIn <= 0) {
            decreaseFactor += 2;
        }
        item.quality -= decreaseFactor * SELL_IN_DECREASE;
    }

    @Override
    protected void decreaseSellIn(Item item) {
        item.sellIn -= SELL_IN_DECREASE;
    }
}