package com.api.rappi_u.infrastructure.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {

    @NotNull(message = "idUser is required")
    private Long idUser;

    @NotNull(message = "idLocation is required")
    private Long idLocation;

    private String observation;

    @NotEmpty(message = "products is required")
    private List<ProductOrderDto> products;

    @NotNull(message = "total is required")
    @DecimalMin(value = "1.0", message = "Min value is 1.0")
    private BigDecimal total;
}
