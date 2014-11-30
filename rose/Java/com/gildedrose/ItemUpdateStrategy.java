package com.gildedrose;

public abstract class ItemUpdateStrategy {

    public abstract void update(Item item);

    protected abstract void decreaseSellIn(Item item);
}
