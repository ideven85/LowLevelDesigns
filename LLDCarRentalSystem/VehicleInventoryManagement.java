package com.cleo.LowLevelDesign.LLDCarRentalSystem;

import com.cleo.LowLevelDesign.LLDCarRentalSystem.Product.Vehicle;

import java.util.List;

public class VehicleInventoryManagement {

    List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        //filtering
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
