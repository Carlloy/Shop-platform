package com.kazdon.shopplatform.app.catalog.domain.port;

import com.kazdon.shopplatform.app.catalog.domain.ItemImage;

import java.util.Collection;
import java.util.UUID;

public interface ImageGateway {

    void save(Collection<ItemImage> itemImages);

    void deleteAllByItemId(UUID itemId);

    void update(UUID itemId, Collection<ItemImage> itemImages);
}
