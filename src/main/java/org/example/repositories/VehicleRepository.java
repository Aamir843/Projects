package org.example.repositories;

import org.example.models.Vehicle;

public interface VehicleRepository {
    Vehicle getVehicleFromVehicleNumber(String vehicleNumber);
}
