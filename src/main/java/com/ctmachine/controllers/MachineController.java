package com.ctmachine.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctmachine.models.Machine;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class MachineController {

    // Create a list to simulate a Data Base
    private List<Machine> machines = new ArrayList<>();

    // List all machines
    @GetMapping
    public List<Machine> listAllMachines(){
        return machines;
    }

    // Search by id
    @GetMapping("/{id}")
    public Machine searchById(@PathVariable UUID id){
        for (Machine machine : machines){
            if(machine.getId() == id){
                return machine;
            }
        }
        return null;
    }

    // Post machine
    @PostMapping
    public Machine postMachine(@RequestBody Machine machine){
        machines.add(machine);

        return machine;
    }

    // Put machine / update
    @PutMapping("/{id}")
    public Machine updatMachine(@PathVariable UUID id, @RequestBody Machine updatedMachine){
        for (Machine machine : machines){
            if (machine.getId() == id){
                machine.setName(updatedMachine.getName());
                machine.setType(updatedMachine.getType());
                machine.setSector(updatedMachine.getSector());
                machine.setStatus(updatedMachine.getStatus());

                return machine;
            }
        }
        return null;
    }

    // Delete machine
    @DeleteMapping("/{id}")
    public String deleteMachine(@PathVariable UUID id){
        for (Machine machine : machines){
            if (machine.getId() == id){
                machines.remove(machine);

                return "Machine successfully deleted!";
            }
        }
        return "Machine not found!";
    }
    
}
