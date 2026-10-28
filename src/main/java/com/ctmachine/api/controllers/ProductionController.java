package com.ctmachine.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctmachine.api.models.Production;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/production")
public class ProductionController {
    // Create a list to simulate a Data Base
    private List<Production> productions = new ArrayList<>();

    // Post new production registers
    @PostMapping("/register")
    public Production postProduction(@RequestBody Production production){
        productions.add(production);

        return production;
    }
    
    // GET all productions
    @GetMapping 
    public List<Production> listAllProductions(){
        return productions;
    }

    // GET production by id
    @GetMapping("/{id}") 
    public Production searchById(@PathVariable UUID id){
        for (Production production : productions){
            if (id.equals(production.getMachineId())){
                return production;
            }
        }

        return null;
    }

    // PUT - update productions
    @PutMapping("/{id}")
    public ResponseEntity<Production> updateProduction(@PathVariable UUID id, @RequestBody Production updateProduction){
        for (Production production : productions){
            if (id.equals(production.getMachineId())){
                production.setConsumption(updateProduction.getConsumption());
                production.setTotalProduction(updateProduction.getTotalProduction());
                production.setWorkingTime(updateProduction.getWorkingTime());

                return ResponseEntity.ok(production);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
