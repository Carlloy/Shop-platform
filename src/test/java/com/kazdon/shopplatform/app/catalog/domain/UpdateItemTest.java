package com.kazdon.shopplatform.app.catalog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UpdateItemTest {

    private final InMemoryItemGateway itemGateway = new InMemoryItemGateway();
    private final InMemoryImageGateway imageGateway = new InMemoryImageGateway();
    private final UpdateItem updateItem = new UpdateItem(itemGateway, imageGateway);
    private final AddItemToCatalog addItemToCatalog = new AddItemToCatalog(itemGateway, imageGateway);

    @BeforeEach
    void beforeEach() {
        itemGateway.clear();
        imageGateway.clear();
    }

    @Test
    void shouldUpdateItem() {
        // given
        UUID id = addItemToCatalog();
        assertThat(itemGateway.findByUuId(id)).usingRecursiveComparison().isNotEqualTo(mockUpdatedItem(id));

        // when
        updateItem.updateItem(mockUpdateItemCommand(id));

        // then
        assertThat(itemGateway.findByUuId(id)).usingRecursiveComparison().isEqualTo(mockUpdatedItem(id));
        assertNotNull(imageGateway.findByUrl("newMainImageUrl"));
        assertNotNull(imageGateway.findByUrl("newFirstOtherImageUrl"));
        assertNotNull(imageGateway.findByUrl("newSecondOtherImageUrl"));
    }

    private UUID addItemToCatalog() {
        var command = new AddItemCommand(
                new ItemName("nameOfItem"),
                new Price(2.50, Currency.PLN),
                new Description("Description of item"),
                new ImagesGallery("mainImageUrl", Set.of("firstOtherImageUrl", "secondOtherImageUrl")));

        return addItemToCatalog.addItem(command);
    }

    private UpdateItemCommand mockUpdateItemCommand(UUID id) {
        return new UpdateItemCommand(
                id,
                new ItemName("newName"),
                new Price(50.10, Currency.PLN),
                new Description("New description of item"),
                new ImagesGallery("newMainImageUrl", Set.of("newFirstOtherImageUrl", "newSecondOtherImageUrl")));
    }

    private Item mockUpdatedItem(UUID id) {
        UpdateItemCommand command = mockUpdateItemCommand(id);
        Item item = new Item(command.id(), command.name(), command.price(), command.description());
        item.setGallery(command.imagesGallery());
        return item;
    }
}
