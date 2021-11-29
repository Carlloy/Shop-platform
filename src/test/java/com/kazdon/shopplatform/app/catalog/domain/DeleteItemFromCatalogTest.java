package com.kazdon.shopplatform.app.catalog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class DeleteItemFromCatalogTest {

    private final InMemoryItemGateway itemGateway = new InMemoryItemGateway();
    private final InMemoryImageGateway imageGateway = new InMemoryImageGateway();
    private final DeleteItemFromCatalog deleteItemFromCatalog = new DeleteItemFromCatalog(itemGateway, imageGateway);
    private final AddItemToCatalog addItemToCatalog = new AddItemToCatalog(itemGateway, imageGateway);

    @BeforeEach
    void beforeEach() {
        itemGateway.clear();
        imageGateway.clear();
    }

    @Test
    void shouldDeleteItemFromCatalog() {
        // given
        UUID id = addItemToCatalog();

        // when
        deleteItemFromCatalog.delete(id);

        // then
        assertNull(itemGateway.findByUuId(id));
        assertThat(imageGateway.findByUrl("mainImageUrl")).isNull();
        assertThat(imageGateway.findByUrl("firstOtherImageUrl")).isNull();
        assertThat(imageGateway.findByUrl("secondOtherImageUrl")).isNull();
    }

    private UUID addItemToCatalog() {
        var command = new AddItemCommand(
                new ItemName("nameOfItem"),
                new Price(2.50, Currency.PLN),
                new Description("Description of item"),
                new ImagesGallery("mainImageUrl", Set.of("firstOtherImageUrl", "secondOtherImageUrl")));

        return addItemToCatalog.addItem(command);
    }
}
