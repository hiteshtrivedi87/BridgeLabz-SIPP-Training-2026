class Vehicle {
    protected String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public double fuelCost(double km) {
        return 0.0;
    }
}

class Car extends Vehicle {
    public Car(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 0.15; }
}

class Bus extends Vehicle {
    public Bus(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 0.40; }
}

class Bike extends Vehicle {
    public Bike(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 0.05; }
}

class ElectricCar extends Vehicle {
    public ElectricCar(String model) { super(model); }
    @Override
    public double fuelCost(double km) { return km * 0.02; }
}

public class FleetManagement {
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Car("Sedan X"),
            new Bus("City Transit"),
            new Bike("Sport 150"),
            new ElectricCar("Model Y")
        };

        double distance = 100.0;

        for (Vehicle v : fleet) {
            System.out.print("Vehicle: " + v.model + " -> ");
            
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.printf("Car Fuel Cost: $%.2f%n", c.fuelCost(distance));
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.printf("Bus Fuel Cost: $%.2f%n", b.fuelCost(distance));
            } else if (v instanceof Bike) {
                Bike bk = (Bike) v;
                System.out.printf("Bike Fuel Cost: $%.2f%n", bk.fuelCost(distance));
            } else if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
                System.out.printf("Electric Car Charging Cost: $%.2f%n", ec.fuelCost(distance));
            }
        }
    }
}