package com.kazdon.shopplatform.app.catalog.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceTest {

    @Test
    void shouldCratePrice() {
        // when
        final Price price = new Price(2.50, Currency.PLN);

        // then
        assertThat(price).extracting("value", "currencyCode").contains(2.50, Currency.PLN);
    }

    @Test
    void cannotCreateNegativePrice() {
        // when
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> new Price(-1.40, Currency.PLN)
        );

        // then
        assertTrue(thrown.getMessage().contains("Missing or negative price"));
    }

    @Test
    void cannotCreateNullPrice() {
        // when
        Exception thrown = assertThrows(
                RuntimeException.class,
                () -> new Price(null, Currency.PLN)
        );

        // then
        assertTrue(thrown.getMessage().contains("Missing or negative price"));
    }
}
