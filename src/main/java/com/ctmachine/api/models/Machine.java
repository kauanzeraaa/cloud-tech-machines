package com.ctmachine.api.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    private UUID id;

    private String name;
    private String type;
    private String sector;

    private StatusEnum status = StatusEnum.Parada;
}
