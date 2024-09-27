package dev.leandro.customermanager.application.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Customer(
        @NotNull CustomerId id,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank Document document) {
    public record CustomerId(Long value) {
    }
}
