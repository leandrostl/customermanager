package dev.leandro.customermanager.core.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public record Document(@NotBlank String code, @NotNull DocumentType type) {
    public static Optional<Document> of(String code) {
        return DocumentType.fromDocumentFormat(code).map(type -> new Document(code, type));
    }

    @RequiredArgsConstructor
    public enum DocumentType {CPF(11), CNPJ(14);
        final int size;
        public static Optional<DocumentType> fromDocumentFormat(String document) {
            return Optional.ofNullable(document)
                    .filter(StringUtils::isNotBlank)
                    .map(doc -> doc.replaceAll("\\D", ""))
                    .map(String::length)
                    .map(length -> Arrays.stream(values()).filter(type -> type.size == length))
                    .flatMap(Stream::findFirst);
        }
    }
}
