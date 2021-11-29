package com.kazdon.shopplatform.app.catalog.domain;

import com.kazdon.shopplatform.app.catalog.domain.port.ItemGateway;
import com.kazdon.shopplatform.app.db.InMemoryDb;

import java.util.Optional;
import java.util.UUID;

class InMemoryItemGateway implements ItemGateway {

    private final InMemoryDb<UUID, Item> db = new InMemoryDb<>();

    @Override
    public void save(Item item) {
        db.save(Item::getId, item);
    }

    @Override
    public void delete(UUID id) {
        db.delete(id);
    }

    @Override
    public Optional<Item> findById(UUID id) {
        return db.getOptional(id);
    }

    Item findByUuId(UUID id) {
        return db.get(id);
    }

    void clear() {
        db.clear();
    }
}
