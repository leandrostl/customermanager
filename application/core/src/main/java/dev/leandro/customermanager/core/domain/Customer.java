package dev.leandro.customermanager.core.domain;

import jakarta.validation.constraints.NotBlank;

public record Customer(
        CustomerId id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank Document document) {
    public record CustomerId(Long value) {
    }
}
