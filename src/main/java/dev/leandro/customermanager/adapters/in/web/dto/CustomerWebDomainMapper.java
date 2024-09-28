package dev.leandro.customermanager.adapters.in.web.dto;

import dev.leandro.customermanager.application.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerWebDomainMapper {
    @Mapping(source = "id.value", target = "id")
    CustomerResponse toResponse(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "document", target = "document.code")
    @Mapping(source = "documentType", target = "document.type")
    Customer toDomainModel(CustomerRequest customerRequest);
}
