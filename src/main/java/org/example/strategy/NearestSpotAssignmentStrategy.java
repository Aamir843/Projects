package org.example.strategy;

import org.example.enums.ParkingSpotStatus;
import org.example.enums.VehicleType;
import org.example.models.Gate;
import org.example.models.ParkingFloor;
import org.example.models.ParkingLot;
import org.example.models.ParkingSpot;
import org.example.repositories.ParkingLotRepository;
import org.example.services.ParkingLotService;
import org.example.services.ParkingSpotService;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy {


    private final ParkingLotService parkingLotService;


    public NearestSpotAssignmentStrategy(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }


    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotService.getParkingLotForGate(gate);

        for(ParkingFloor floor: parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: floor.getParkingSpots()){
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpot.getSupportedVehicleTypes().contains(vehicleType))
                    return parkingSpot;
            }
        }
        return null;
    }
}
