package com.ctmachine.api.models;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Production {
    private UUID machineId;
    private double consumption;
    private String workingTime;
    private int totalProduction;
}
