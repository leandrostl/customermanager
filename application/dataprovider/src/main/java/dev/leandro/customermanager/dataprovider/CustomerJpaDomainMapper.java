package dev.leandro.customermanager.dataprovider;

import dev.leandro.customermanager.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CustomerJpaDomainMapper {

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "document", target = "document.code")
    @Mapping(source = "documentType", target = "document.type")
    Customer toDomainModel(CustomerJpaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "document.code", target = "document")
    @Mapping(source = "document.type", target = "documentType")
    CustomerJpaEntity toJpaEntity(Customer entity);
}
