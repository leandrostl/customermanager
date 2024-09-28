package dev.leandro.customermanager.adapters.in.web;

import dev.leandro.customermanager.adapters.in.web.dto.CustomerRequest;
import dev.leandro.customermanager.adapters.in.web.dto.CustomerResponse;
import dev.leandro.customermanager.adapters.in.web.dto.CustomerWebDomainMapper;
import dev.leandro.customermanager.application.domain.model.Customer;
import dev.leandro.customermanager.application.domain.model.Document;
import dev.leandro.customermanager.application.port.in.CreateCustomerUseCase;
import dev.leandro.customermanager.application.port.in.GetCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomersApiController implements CustomersApi {

    private final GetCustomerUseCase getCustomerUseCase;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerWebDomainMapper mapper;

    @GetMapping(produces = "application/json")
    public ResponseEntity<CustomerResponse> findCustomer(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "document", required = false) String document) {
        final var query = new GetCustomerUseCase.GetCustomerQuery(new Customer.CustomerId(id),
                Document.of(document).orElse(null));
        final var customer = getCustomerUseCase.getCustomer(query);
        return customer
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CustomerResponse> createCustomer(UriComponentsBuilder uriComponentsBuilder,
                                                           @RequestBody CustomerRequest customerRequest) {
        final var customer = mapper.toDomainModel(customerRequest);
        final var created = createCustomerUseCase.createCustomer(customer);
        final var path = uriComponentsBuilder
                .path("/customers")
                .queryParam("id", created.id().value())
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(path).build();
    }

}
