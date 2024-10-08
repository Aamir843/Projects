package org.example.repositories;

import org.example.models.Vehicle;

public interface VehicleRepository {
    Vehicle getVehicleFromVehicleNumber(String vehicleNumber);
}


/**
 * public class VehicleRepository {
 *
 *     // Implement Vehicle Repository
 *
 *     public Optional<Vehicle> findByVehicleNumber(String vehicleNumber){
 *         return Optional.empty();
 *     }
 *
 *     public Vehicle saveVehicle(Vehicle vehicle){
 *         // Vehicle that will be returned will have an id as well
 *         return null;
 *     }
 * }
 */
