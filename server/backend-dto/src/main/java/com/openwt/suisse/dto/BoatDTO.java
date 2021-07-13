package com.openwt.suisse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BoatDTO {

    private Long id;

    @NotNull(message = "{backend.constraints.boatName.NotNull.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.description.Size.message}")
    private String boatName;

    @Size(min = 2, max = 32, message = "{backend.constraints.description.Size.message}")
    private String description;
}
