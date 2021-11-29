package com.kazdon.shopplatform.app.catalog.domain;

import java.util.Objects;

public record Price(Double value, Currency currencyCode) {

    public Price {
        validateInvariants(value);
    }

    private void validateInvariants(Double value) {
        validatePriceValue(value);
    }

    private void validatePriceValue(Double value) {
        if (Objects.isNull(value) || value < 0) {
            throw new RuntimeException("Missing or negative price");
        }
    }
}


