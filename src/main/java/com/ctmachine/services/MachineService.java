package com.ctmachine.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ctmachine.models.Machine;
import com.ctmachine.models.Production;

public class MachineService {
	private List<Machine> machines = new ArrayList<>();
	private List<Production> productions = new ArrayList<>();

	// Create machine
	public Machine createMachine(Machine machine){
		machines.add(machine);
		return machine;
	}

	// Search machine by ID
	public Optional<Machine> searchById(UUID id){
		return machines.stream().filter(m -> m.getId().equals(id)).findFirst();
	}

	// Create consumption
	public Production saveConsumption(Production production){
		boolean hasMachine = machines.stream().anyMatch(m -> m.getId().equals(production.getMachineId()));

		if (!hasMachine){
			throw new IllegalArgumentException("Error: Machine not found!");
		}

		productions.add(production);
		return production;
	}

	// List machines
	public List<Machine> listMachines(){
		return machines;
	}

	// List productions
	public List<Production> listProductions(){
		return productions;
	}
}
