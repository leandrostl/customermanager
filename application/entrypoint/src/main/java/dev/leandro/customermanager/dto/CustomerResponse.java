package dev.leandro.customermanager.dto;

import dev.leandro.customermanager.core.domain.Document;
import io.swagger.v3.oas.annotations.media.Schema;

public record CustomerResponse(@Schema(description = "Customer's first name.", example = "John") Long id,
                               @Schema(description = "Customer's first name.", example = "John") String firstName,
                               @Schema(description = "Customer's last name.", example = "Lennon") String lastName,
                               @Schema(description = "Customer's document.") Document document) {
}
