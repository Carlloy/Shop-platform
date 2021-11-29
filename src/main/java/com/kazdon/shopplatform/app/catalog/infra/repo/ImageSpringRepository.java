package com.kazdon.shopplatform.app.catalog.infra.repo;

import com.kazdon.shopplatform.app.catalog.domain.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

interface ImageSpringRepository extends JpaRepository<ItemImage, String> {

    Optional<ItemImage> findById(Long id);

    Collection<ItemImage> findAllByItemId(UUID itemId);

    void deleteAllByItemId(UUID itemId);
}
