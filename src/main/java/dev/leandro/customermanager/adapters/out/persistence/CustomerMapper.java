package dev.leandro.customermanager.adapters.out.persistence;

import dev.leandro.customermanager.application.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "document", target = "document.code")
    @Mapping(source = "documentType", target = "document.type")
    Customer toDomainModel(CustomerJpaEntity entity);
}
