package org.example.repositories;

import org.example.models.Gate;
import org.example.models.ParkingLot;

public interface ParkingLotRepository {

    ParkingLot getParkingLotByGate(Gate gate);
}
