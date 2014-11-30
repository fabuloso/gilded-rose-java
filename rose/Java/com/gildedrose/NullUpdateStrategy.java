package com.gildedrose;

public class NullUpdateStrategy extends ItemUpdateStrategy {

    @Override
    public void update(Item item) {
    }

    @Override
    protected void decreaseSellIn(Item item) {
    }

    @Override
    protected void updateQuality(Item item) {
    }

}
