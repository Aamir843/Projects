package org.example.strategy;

import org.example.models.Gate;
import org.example.models.ParkingSpot;
import org.example.enums.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
