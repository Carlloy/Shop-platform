package com.kazdon.shopplatform.app.catalog.infra.web;

import com.kazdon.shopplatform.app.catalog.domain.Currency;
import com.kazdon.shopplatform.app.catalog.domain.Description;
import com.kazdon.shopplatform.app.catalog.domain.ImagesGallery;
import com.kazdon.shopplatform.app.catalog.domain.ItemName;
import com.kazdon.shopplatform.app.catalog.domain.Price;
import com.kazdon.shopplatform.app.catalog.domain.UpdateItemCommand;

import java.util.Set;
import java.util.UUID;

record UpdateItemDTO(String name, Double price, String currencyCode, String description,
                     String mainImage, Set<String> otherImages) {

    UpdateItemCommand toCommand(UUID id) {
        return new UpdateItemCommand(
                id,
                new ItemName(name),
                new Price(price, Currency.valueOf(currencyCode)),
                new Description(description),
                new ImagesGallery(mainImage, otherImages)
        );
    }
}
