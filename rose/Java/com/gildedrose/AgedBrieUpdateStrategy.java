package com.gildedrose;

public class AgedBrieUpdateStrategy extends ItemUpdateStrategy {

    private static final int QUALITY_INCREASE = 1;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int SELL_IN_DECREASE = 1;

    @Override
    public void update(Item item) {
        if (item.quality < MAXIMUM_QUALITY) {
            updateQuality(item);
        }
        decreaseSellIn(item);
    }

    @Override
    protected void updateQuality(Item item) {
        int increaseFactor = 1;
        if (item.sellIn <= 0) {
            increaseFactor += 1;
        }
        item.quality += increaseFactor * QUALITY_INCREASE;
    }

    @Override
    protected void decreaseSellIn(Item item) {
        item.sellIn -= SELL_IN_DECREASE;
    }
}
