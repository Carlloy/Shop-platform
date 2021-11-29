package com.kazdon.shopplatform.app.catalog.domain;

import java.util.UUID;

public record UpdateItemCommand(UUID id, ItemName name, Price price, Description description,
                                ImagesGallery imagesGallery) {
}
