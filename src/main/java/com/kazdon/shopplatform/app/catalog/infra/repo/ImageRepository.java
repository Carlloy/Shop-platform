package com.kazdon.shopplatform.app.catalog.infra.repo;

import com.kazdon.shopplatform.app.catalog.domain.ItemImage;
import com.kazdon.shopplatform.app.catalog.domain.port.ImageGateway;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
class ImageRepository implements ImageGateway {

    private final ImageSpringRepository repository;

    ImageRepository(ImageSpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Collection<ItemImage> itemImages) {
        repository.saveAll(itemImages);
    }

    @Override
    public void deleteAllByItemId(UUID itemId) {
        repository.deleteAllByItemId(itemId);
    }

    @Override
    public void update(UUID itemId, Collection<ItemImage> itemImages) {
        repository.deleteAllByItemId(itemId);
        repository.saveAll(itemImages);
    }
}
