package com.ctmachine.api.models;

import java.util.UUID;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String type;
    private String sector;

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.Parada;
}
