package com.kazdon.shopplatform.app.catalog.domain;

import com.kazdon.shopplatform.app.catalog.domain.port.ImageGateway;
import com.kazdon.shopplatform.app.catalog.domain.port.ItemGateway;

import java.util.UUID;

public class AddItemToCatalog {

    private final ItemGateway itemGateway;
    private final ImageGateway imageGateway;

    public AddItemToCatalog(ItemGateway itemGateway, ImageGateway imageGateway) {
        this.itemGateway = itemGateway;
        this.imageGateway = imageGateway;
    }

    public UUID addItem(AddItemCommand command) {
        Item item = new Item(UUID.randomUUID(), command.name(), command.price(), command.description());
        item.setGallery(command.imagesGallery());
        itemGateway.save(item);
        imageGateway.save(item.getGallery());
        return item.getId();
    }
}
