package com.api.rappi_u.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SelectOrderDto {


    @NotNull(message = "idOrder is requiered")
    private Long idOrder;

    @NotNull(message = "idDelivery is requiered")
    private Long idDelivery;

}
