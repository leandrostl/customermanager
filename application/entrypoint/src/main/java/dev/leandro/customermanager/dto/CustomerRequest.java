package dev.leandro.customermanager.dto;

import dev.leandro.customermanager.core.domain.Document;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Validated
public record CustomerRequest(
        @NotBlank @Schema(requiredMode = REQUIRED, description = "Customer's first name.", example = "John")
        String firstName,
        @NotBlank @Schema(requiredMode = REQUIRED, description = "Customer's last name.", example = "Lennon")
        String lastName,
        @NotBlank @Schema(requiredMode = REQUIRED, description = "Customer's main document.")
        String document,
        @NotNull @Schema(requiredMode = REQUIRED, description = "Customer's document type.")
        Document.DocumentType documentType) {
}