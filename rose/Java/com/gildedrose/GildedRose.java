package com.gildedrose;

import com.gildedrose.strategy.ItemUpdateStrategy;
import com.gildedrose.strategy.ItemUpdateStrategyFactory;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateStrategy strategy = createStrategy(item.name);
            strategy.update(item);
        }
    }

    private ItemUpdateStrategy createStrategy(String name) {
        return ItemUpdateStrategyFactory.build(name);
    }
}
