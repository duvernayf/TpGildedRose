package com.gildedrose;

import javafx.scene.CacheHint;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            String name = item.name;
            int quality = item.quality;
            int sellIn = item.sellIn;
            
            if (!name.equals("Aged Brie") && !name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if ((quality > 0) && (!name.equals("Sulfuras, Hand of Ragnaros"))) {
                    quality--;
                }
            } else {
                if (quality < 50) {
                    quality++;
                    if (name.equals("Backstage passes to a TAFKAL80ETC concert") && ((sellIn < 11) && (quality < 50))) {
                        quality++;
                        if ((sellIn < 6) && (quality < 50)) {
                            quality++;
                        }
                    }
                }
            }
            if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                sellIn--;
            }
            if (sellIn < 0) {
                if (!name.equals("Aged Brie")) {
                    if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (quality > 0 && (!name.equals("Sulfuras, Hand of Ragnaros"))) {
                            quality--;
                        }
                    } else {
                        quality = 0;
                    }
                } else if (quality < 50){
                    quality++;
                }
            }
            item.quality = quality;
            item.sellIn = sellIn;
        }
    }
}
