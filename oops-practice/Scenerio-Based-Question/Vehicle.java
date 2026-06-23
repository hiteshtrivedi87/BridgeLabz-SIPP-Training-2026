class Vehicle {

    String vehicleNumber;
    String ownerName;
    String vehicleType;
    
    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void displayCars(Vehicle[] vehicles) {
        System.out.println("\nCars:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        System.out.println("\nBikes:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " - " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[10];

        vehicles[0] = new Vehicle("UP93A101", "Ayush", "Car");
        vehicles[1] = new Vehicle("UP93B102", "Rahul", "Bike");
        vehicles[2] = new Vehicle("UP93C103", "Riya", "Car");
        vehicles[3] = new Vehicle("UP93D104", "Amit", "Bike");
        vehicles[4] = new Vehicle("UP93E105", "Neha", "Car");
        vehicles[5] = new Vehicle("UP93F106", "Karan", "Bike");
        vehicles[6] = new Vehicle("UP93G107", "Priya", "Car");
        vehicles[7] = new Vehicle("UP93H108", "Ankit", "Bike");
        vehicles[8] = new Vehicle("UP93I109", "Rohan", "Car");
        vehicles[9] = new Vehicle("UP93J110", "Simran", "Bike");

        displayCars(vehicles);
        displayBikes(vehicles);
    }
}