package com.kazdon.shopplatform.app.catalog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
public class Item {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double priceValue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency priceCode;

    @Column(nullable = false)
    private String description;

    @Transient
    private final Collection<ItemImage> images = new ArrayList<>();

    public Item() {
    }

    public Item(UUID id, ItemName name, Price price, Description description) {
        this.id = id;
        this.name = name.value();
        this.priceValue = price.value();
        this.priceCode = price.currencyCode();
        this.description = description.text();
    }

    void setGallery(ImagesGallery gallery) {
        images.clear();
        images.add(ItemImage.createMain(id, gallery.mainImage()));
        List<ItemImage> images = gallery.otherImages().stream()
                .map(image -> ItemImage.createOther(id, image))
                .toList();
        this.images.addAll(images);
    }

    Collection<ItemImage> getGallery() {
        return new ArrayList<>(images);
    }

    UUID getId() {
        return id;
    }

    Item setName(ItemName name) {
        this.name = name.value();
        return this;
    }

    Item setPrice(Price price) {
        this.priceValue = price.value();
        this.priceCode = price.currencyCode();
        return this;
    }

    Item setDescription(Description description) {
        this.description = description.text();
        return this;
    }
}
