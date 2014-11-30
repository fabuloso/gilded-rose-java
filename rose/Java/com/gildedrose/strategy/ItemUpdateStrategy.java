package com.gildedrose.strategy;

import com.gildedrose.Item;

public abstract class ItemUpdateStrategy {

    public abstract void update(Item item);

    protected abstract void decreaseSellIn(Item item);

    protected abstract void updateQuality(Item item);
}
