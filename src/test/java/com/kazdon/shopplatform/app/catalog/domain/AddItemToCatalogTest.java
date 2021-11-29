package com.kazdon.shopplatform.app.catalog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddItemToCatalogTest {

    private final InMemoryItemGateway itemGateway = new InMemoryItemGateway();

    private final InMemoryImageGateway imageGateway = new InMemoryImageGateway();

    private final AddItemToCatalog addItemToCatalog = new AddItemToCatalog(itemGateway, imageGateway);

    @BeforeEach
    void beforeEach() {
        itemGateway.clear();
        imageGateway.clear();
    }

    @Test
    void shouldAddItem() {
        // given
        var command = new AddItemCommand(
                new ItemName("nameOfItem"),
                new Price(2.50, Currency.PLN),
                new Description("Description of item"),
                new ImagesGallery("mainImageUrl", Set.of("firstOtherImageUrl", "secondOtherImageUrl")));

        // when
        UUID id = addItemToCatalog.addItem(command);

        // then
        assertNotNull(id);
        assertThat(imageGateway.findByUrl("mainImageUrl")).extracting("main", "itemId").contains(true, id);
        assertThat(imageGateway.findByUrl("firstOtherImageUrl")).extracting("main", "itemId").contains(false, id);
        assertThat(imageGateway.findByUrl("secondOtherImageUrl")).extracting("main", "itemId").contains(false, id);
    }
}
