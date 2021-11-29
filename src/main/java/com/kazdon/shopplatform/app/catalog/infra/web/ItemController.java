package com.kazdon.shopplatform.app.catalog.infra.web;

import com.kazdon.shopplatform.app.catalog.domain.AddItemCommand;
import com.kazdon.shopplatform.app.catalog.domain.UpdateItemCommand;
import com.kazdon.shopplatform.app.catalog.infra.ItemFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/item")
class ItemController {

    private final ItemFacade itemFacade;

    public ItemController(ItemFacade itemFacade) {
        this.itemFacade = itemFacade;
    }

    @PostMapping(path = "add")
    ResponseEntity<UUID> addItem(@RequestBody AddItemDTO addItemDTO) {
        AddItemCommand command = addItemDTO.toCommand();
        UUID id = itemFacade.addItemToCatalog(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PostMapping(path = "{id}")
    ResponseEntity<UUID> deleteItem(@PathVariable UUID id) {
        itemFacade.deleteItemFromCatalog(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "{id}")
    ResponseEntity<UUID> updateItem(@PathVariable UUID id, @RequestBody UpdateItemDTO updateItemDTO) {
        UpdateItemCommand command = updateItemDTO.toCommand(id);
        itemFacade.updateItem(command);
        return ResponseEntity.ok().build();
    }
}
