abstract class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle {
    private double dailyRate;

    public Car(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * getDailyRate();
    }
}

class Bike extends Vehicle {
    private double dailyRate;

    public Bike(String vehicleNumber, String vehicleType, double dailyRate) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    @Override
    public double calculateRentalCost(int days) {
        return days * getDailyRate();
    }
}

class Truck extends Vehicle {
    private double dailyRate;
    private double loadingCharge;

    public Truck(String vehicleNumber, String vehicleType, double dailyRate, double loadingCharge) {
        super(vehicleNumber, vehicleType);
        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }

    public double getLoadingCharge() { return loadingCharge; }
    public void setLoadingCharge(double loadingCharge) { this.loadingCharge = loadingCharge; }

    @Override
    public double calculateRentalCost(int days) {
        return (days * getDailyRate()) + getLoadingCharge();
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        Vehicle car = new Car("CAR-8821", "Sedan", 50.0);
        Vehicle bike = new Bike("BIK-4112", "Sports Bike", 20.0);
        Vehicle truck = new Truck("TRK-0091", "Heavy Hauler", 120.0, 150.0);

        int rentalDays = 5;

        System.out.println("=== Rental Quote (" + rentalDays + " Days) ===");
        displayQuote(car, rentalDays);
        displayQuote(bike, rentalDays);
        displayQuote(truck, rentalDays);
    }

    private static void displayQuote(Vehicle vehicle, int days) {
        System.out.println("Vehicle No: " + vehicle.getVehicleNumber() + " | Type: " + vehicle.getVehicleType());
        System.out.println("Total Cost: $" + vehicle.calculateRentalCost(days));
        System.out.println("----------------------------------------");
    }
}