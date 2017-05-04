package com.gildedrose;

import javafx.scene.CacheHint;

class GildedRose {

    Item[] items;

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;

    }

    public void updateQuality() {
        for (Item item : items) {
            String name = item.name;
            if (!name.equals(SULFURAS)) {
                int quality = item.quality;
                int sellIn = item.sellIn;
                
                if (!name.equals(AGED_BRIE) && !name.equals(BACKSTAGE_PASS)) {
                    if (quality > 0) {
                        quality--;
                    }
                } else {
                    if (quality < 50) {
                        quality++;
                        if (name.equals(BACKSTAGE_PASS) && ((sellIn < 11) && (quality < 50))) {
                            quality++;
                            if ((sellIn < 6) && (quality < 50)) {
                                quality++;
                            }
                        }
                    }
                }
                sellIn--;
                if (sellIn < 0) {
                    if (!name.equals(AGED_BRIE)) {
                        if (!name.equals(BACKSTAGE_PASS)) {
                            if (quality > 0) {
                                quality--;
                            }
                        } else {
                            quality = 0;
                        }
                    } else if (quality < 50) {
                        quality++;
                    }
                }
                item.quality = quality;
                item.sellIn = sellIn;
            }
        }
    }
}
