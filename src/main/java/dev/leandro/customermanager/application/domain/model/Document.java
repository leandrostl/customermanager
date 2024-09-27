package dev.leandro.customermanager.application.domain.model;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Optional;

public record Document(@NotBlank String code, @NotNull DocumentType type) {
    public static Optional<Document> of(String code) {
        return Optional.ofNullable(code)
                .flatMap(DocumentType::fromDocumentFormat)
                .map(type -> new Document(code, type));
    }
    @RequiredArgsConstructor
    public enum DocumentType {CPF(11), CNPJ(14);
        final int size;
        public static Optional<DocumentType> fromDocumentFormat(String document) {
            if(StringUtils.isBlank(document))
                return Optional.empty();
            final var docWithoutMask = document.replaceAll("\\D", "").length();
            return Arrays.stream(values()).filter(type -> type.size == docWithoutMask).findFirst();
        }
    }
}
