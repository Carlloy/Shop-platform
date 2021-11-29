package com.kazdon.shopplatform.app.catalog.domain;

public record AddItemCommand(ItemName name, Price price, Description description, ImagesGallery imagesGallery) {
}
