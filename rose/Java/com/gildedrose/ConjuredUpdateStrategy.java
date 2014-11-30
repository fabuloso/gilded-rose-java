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

    @Override
    protected void updateQuality(Item item) {
        int decreaseFactor = decreaseFactor(item.sellIn);
        item.quality -= decreaseFactor * SELL_IN_DECREASE;
    }

    private int decreaseFactor(int sellIn) {
        int decreaseFactor = 2;
        if (sellIn <= 0) {
            decreaseFactor += 2;
        }
        return decreaseFactor;
    }

    @Override
    protected void decreaseSellIn(Item item) {
        item.sellIn -= SELL_IN_DECREASE;
    }
}