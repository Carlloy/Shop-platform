package com.kazdon.shopplatform.app.catalog.infra.repo;

import com.kazdon.shopplatform.app.catalog.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ItemSpringRepository extends JpaRepository<Item, UUID> {

    Item findItemById(UUID id);
}
