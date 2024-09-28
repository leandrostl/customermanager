package dev.leandro.customermanager.adapters.out.persistence;

import dev.leandro.customermanager.application.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CustomerJpaDomainMapper {

    CustomerJpaDomainMapper INSTANCE = Mappers.getMapper(CustomerJpaDomainMapper.class);

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "document", target = "document.code")
    @Mapping(source = "documentType", target = "document.type")
    Customer toDomainModel(CustomerJpaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "document.code", target = "document")
    @Mapping(source = "document.type", target = "documentType")
    CustomerJpaEntity toJpaEntity(Customer entity);
}
