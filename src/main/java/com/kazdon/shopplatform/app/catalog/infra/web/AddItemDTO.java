package com.kazdon.shopplatform.app.catalog.infra.web;

import com.kazdon.shopplatform.app.catalog.domain.AddItemCommand;
import com.kazdon.shopplatform.app.catalog.domain.Currency;
import com.kazdon.shopplatform.app.catalog.domain.Description;
import com.kazdon.shopplatform.app.catalog.domain.ImagesGallery;
import com.kazdon.shopplatform.app.catalog.domain.ItemName;
import com.kazdon.shopplatform.app.catalog.domain.Price;

import java.util.Set;

record AddItemDTO(String name, Double price, String currencyCode, String description, String mainImage,
                  Set<String> otherImages) {

    AddItemCommand toCommand() {
        return new AddItemCommand(
                new ItemName(name),
                new Price(price, Currency.valueOf(currencyCode)),
                new Description(description),
                new ImagesGallery(mainImage, otherImages)
        );
    }
}
