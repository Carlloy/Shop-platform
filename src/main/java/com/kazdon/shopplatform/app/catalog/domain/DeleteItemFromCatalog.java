package com.kazdon.shopplatform.app.catalog.domain;

import com.kazdon.shopplatform.app.catalog.domain.port.ImageGateway;
import com.kazdon.shopplatform.app.catalog.domain.port.ItemGateway;

import java.util.UUID;

public class DeleteItemFromCatalog {

    private final ItemGateway itemGateway;
    private final ImageGateway imageGateway;

    public DeleteItemFromCatalog(ItemGateway itemGateway, ImageGateway imageGateway) {
        this.itemGateway = itemGateway;
        this.imageGateway = imageGateway;
    }

    public void delete(UUID id) {
        imageGateway.deleteAllByItemId(id);
        itemGateway.delete(id);
    }
}
