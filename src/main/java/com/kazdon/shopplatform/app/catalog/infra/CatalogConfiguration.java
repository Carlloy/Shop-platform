package com.kazdon.shopplatform.app.catalog.infra;

import com.kazdon.shopplatform.app.catalog.domain.AddItemToCatalog;
import com.kazdon.shopplatform.app.catalog.domain.DeleteItemFromCatalog;
import com.kazdon.shopplatform.app.catalog.domain.UpdateItem;
import com.kazdon.shopplatform.app.catalog.domain.port.ImageGateway;
import com.kazdon.shopplatform.app.catalog.domain.port.ItemGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfiguration {

    @Bean
    AddItemToCatalog addItemToCatalog(ItemGateway itemGateway, ImageGateway imageGateway) {
        return new AddItemToCatalog(itemGateway, imageGateway);
    }

    @Bean
    DeleteItemFromCatalog deleteItemFromCatalog(ItemGateway itemGateway, ImageGateway imageGateway) {
        return new DeleteItemFromCatalog(itemGateway, imageGateway);
    }

    @Bean
    UpdateItem updateItem(ItemGateway itemGateway, ImageGateway imageGateway) {
        return new UpdateItem(itemGateway, imageGateway);
    }
}
