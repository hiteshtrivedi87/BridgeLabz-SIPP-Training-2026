interface Refuelable {
    void refuel();
}

class Vehicle {
    private int maxSpeed;
    private String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public int getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}

class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println(getModel() + " is currently charging its battery core.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is replenishing its fuel tank at the gas station.");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle(250, "Tesla Model S");
        PetrolVehicle mustang = new PetrolVehicle(290, "Ford Mustang GT");

        System.out.println("Vehicle 1: " + tesla.getModel() + " | Max Speed: " + tesla.getMaxSpeed() + " km/h");
        tesla.charge();

        System.out.println("\nVehicle 2: " + mustang.getModel() + " | Max Speed: " + mustang.getMaxSpeed() + " km/h");
        mustang.refuel();
    }
}