package com.kazdon.shopplatform.app.catalog.infra.repo;

import com.kazdon.shopplatform.app.catalog.domain.Item;
import com.kazdon.shopplatform.app.catalog.domain.port.ItemGateway;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
class ItemRepository implements ItemGateway {

    private final ItemSpringRepository repository;

    ItemRepository(ItemSpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Item item) {
        repository.save(item);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Item> findById(UUID id) {
        return repository.findById(id);
    }
}
