package org.example.models;

import org.example.enums.ParkingSpotStatus;
import org.example.enums.VehicleType;

import java.util.List;

public class ParkingSpot extends BaseEntity {

    private int number;
    private ParkingSpotStatus parkingSpotStatus;

    List<VehicleType> supportedVehicleTypes;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }
}
