package com.kazdon.shopplatform.app.catalog.domain;

import com.kazdon.shopplatform.app.catalog.domain.port.ImageGateway;
import com.kazdon.shopplatform.app.db.InMemoryDb;

import java.util.Collection;
import java.util.UUID;

class InMemoryImageGateway implements ImageGateway {

    private final InMemoryDb<String, ItemImage> db = new InMemoryDb<>();

    @Override
    public void save(Collection<ItemImage> itemImages) {
        itemImages.forEach(image -> db.save(ItemImage::getUrl, image));
    }

    @Override
    public void deleteAllByItemId(UUID itemId) {
        db.deleteByFieldValue(ItemImage::getItemId, itemId);
    }

    @Override
    public void update(UUID itemId, Collection<ItemImage> itemImages) {
        deleteAllByItemId(itemId);
        save(itemImages);
    }

    ItemImage findByUrl(String url) {
        return db.get(url);
    }

    void clear() {
        db.clear();
    }
}
