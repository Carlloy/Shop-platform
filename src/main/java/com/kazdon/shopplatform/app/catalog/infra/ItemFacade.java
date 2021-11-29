package com.kazdon.shopplatform.app.catalog.infra;

import com.kazdon.shopplatform.app.catalog.domain.AddItemCommand;
import com.kazdon.shopplatform.app.catalog.domain.AddItemToCatalog;
import com.kazdon.shopplatform.app.catalog.domain.DeleteItemFromCatalog;
import com.kazdon.shopplatform.app.catalog.domain.UpdateItem;
import com.kazdon.shopplatform.app.catalog.domain.UpdateItemCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ItemFacade {

    private final AddItemToCatalog addItemToCatalog;
    private final DeleteItemFromCatalog deleteItemFromCatalog;
    private final UpdateItem updateItem;

    public ItemFacade(AddItemToCatalog addItemToCatalog, DeleteItemFromCatalog deleteItemFromCatalog, UpdateItem updateItem) {
        this.addItemToCatalog = addItemToCatalog;
        this.deleteItemFromCatalog = deleteItemFromCatalog;
        this.updateItem = updateItem;
    }

    @Transactional
    public UUID addItemToCatalog(AddItemCommand command) {
        return addItemToCatalog.addItem(command);
    }

    @Transactional
    public void deleteItemFromCatalog(UUID id) {
        deleteItemFromCatalog.delete(id);
    }

    @Transactional
    public void updateItem(UpdateItemCommand command) {
        updateItem.updateItem(command);
    }
}
