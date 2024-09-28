package org.example.services;

import org.example.models.Gate;
import org.example.models.ParkingLot;
import org.example.repositories.ParkingLotRepository;

public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot getParkingLotForGate(Gate gate){
        return parkingLotRepository.getParkingLotByGate(gate);
    }
}
