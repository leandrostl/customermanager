package dev.leandro.customermanager.adapters.in.web;

import dev.leandro.customermanager.adapters.in.web.dto.CustomerRequest;
import dev.leandro.customermanager.adapters.in.web.dto.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface CustomersApi {

    @Operation(summary = "Register a new customer",
            description = "Register a new bank customer", tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer registered successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerResponse.class)))})
    ResponseEntity<CustomerResponse> createCustomer(
            @Parameter(in = ParameterIn.DEFAULT, description = "Customer information", required = true, schema = @Schema())
            @Valid CustomerRequest body);


    @Operation(summary = "Find a customer",
            description = "Find a customer according to parameters", tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer found for filter parameters",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerResponse.class))),
            @ApiResponse(responseCode = "404", description = "No customer found for filter parameters")})
    ResponseEntity<CustomerResponse> findCustomer(
            @Parameter(in = ParameterIn.QUERY, description = "Customer identification on the system", schema = @Schema())
            @Valid Long id,
            @Parameter(in = ParameterIn.QUERY, description = "Customer document code", schema = @Schema())
            @Valid String document);
}

