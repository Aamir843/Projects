package org.example.strategy;

import org.example.enums.ParkingSpotStatus;
import org.example.enums.VehicleType;
import org.example.models.*;
import org.example.services.ParkingLotService;
import org.example.services.ParkingSpotService;

import java.util.List;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    private final ParkingLotService parkingLotService;

    private final ParkingSpotService parkingSpotService;

    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService) {
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotService.getParkingLotForGate(gate);

        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpotsByLot(parkingLot);

        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) &&
            parkingSpot.getSupportedVehicleTypes().contains(vehicleType)){
                return parkingSpot;

            }
        }
        return null;
    }
}
