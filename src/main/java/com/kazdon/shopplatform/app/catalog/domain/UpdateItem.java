package com.kazdon.shopplatform.app.catalog.domain;

import com.kazdon.shopplatform.app.catalog.domain.port.ImageGateway;
import com.kazdon.shopplatform.app.catalog.domain.port.ItemGateway;

public class UpdateItem {

    private final ItemGateway itemGateway;
    private final ImageGateway imageGateway;

    public UpdateItem(ItemGateway itemGateway, ImageGateway imageGateway) {
        this.itemGateway = itemGateway;
        this.imageGateway = imageGateway;
    }

    public void updateItem(UpdateItemCommand command) {
        Item item = itemGateway.findById(command.id()).orElseThrow();
        item
                .setName(command.name())
                .setPrice(command.price())
                .setDescription(command.description())
                .setGallery(command.imagesGallery());
        itemGateway.save(item);
        imageGateway.update(item.getId(), item.getGallery());
    }
}
