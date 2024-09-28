package org.example.services;

import org.example.models.Vehicle;
import org.example.enums.VehicleType;
import org.example.repositories.VehicleRepository;

public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType) {
        return null;
    }

    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleRepository.getVehicleFromVehicleNumber(vehicleNumber);
    }
}
