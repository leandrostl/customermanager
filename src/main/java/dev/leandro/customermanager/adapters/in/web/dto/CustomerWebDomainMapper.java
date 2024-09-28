package dev.leandro.customermanager.adapters.in.web.dto;

import dev.leandro.customermanager.application.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerWebDomainMapper {
    CustomerWebDomainMapper INSTANCE = Mappers.getMapper(CustomerWebDomainMapper.class);

    @Mapping(source = "id.value", target = "id")
    CustomerResponse toResponse(Customer customer);

    @Mapping(source = "document", target = "document.code")
    @Mapping(source = "documentType", target = "document.type")
    Customer toDomainModel(CustomerRequest customerRequest);
}
