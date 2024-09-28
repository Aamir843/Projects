package org.example.services;

import org.example.enums.VehicleType;
import org.example.exceptions.NoParkingSpotFoundException;
import org.example.models.*;
import org.example.strategy.SpotAssignmentStrategy;

import java.time.Instant;

public class TicketService {

    private final VehicleService vehicleService;

    private final GateService gateService;

    private final SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(VehicleService vehicleService, GateService gateService, SpotAssignmentStrategy spotAssignmentStrategy) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }


    public Ticket generateTicket(String vehicleNumber, long gateId, VehicleType vehicleType) throws NoParkingSpotFoundException {
        Gate gate = gateService.getGateUsingId(gateId);
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if(vehicle==null){
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }
        Ticket ticket = new Ticket();
        ticket.setEntryTime(Instant.now());
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setVehicle(vehicle);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if(parkingSpot == null){
            //No ParkingSpot is available.
            //Throw an Exception.
            throw new NoParkingSpotFoundException("No ParkingSpot found.");
        }

        ticket.setParkingSpot(parkingSpot);

        return ticket;
    }
}
