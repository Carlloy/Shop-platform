package com.kazdon.shopplatform.app.catalog.domain.port;

import com.kazdon.shopplatform.app.catalog.domain.Item;

import java.util.Optional;
import java.util.UUID;

public interface ItemGateway {

    void save(Item item);

    void delete(UUID id);

    Optional<Item> findById(UUID id);
}
