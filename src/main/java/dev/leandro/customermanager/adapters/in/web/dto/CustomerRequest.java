package dev.leandro.customermanager.adapters.in.web.dto;

import dev.leandro.customermanager.application.domain.model.Document;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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