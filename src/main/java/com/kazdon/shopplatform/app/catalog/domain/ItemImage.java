package com.kazdon.shopplatform.app.catalog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "image")
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID itemId;

    @Column(nullable = false)
    private String url;

    private boolean main;

    public ItemImage() {
    }

    ItemImage(UUID itemId, String url, boolean main) {
        this.itemId = itemId;
        this.url = url;
        this.main = main;
    }

    static ItemImage createMain(UUID itemId, String url) {
        return new ItemImage(itemId, url, true);
    }

    static ItemImage createOther(UUID itemId, String url) {
        return new ItemImage(itemId, url, false);
    }

    boolean isMain() {
        return main;
    }

    String getUrl() {
        return url;
    }

    public UUID getItemId() {
        return itemId;
    }
}
