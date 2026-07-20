class Drone {

    int droneId;
    int batteryPercentage;

    static String companyName = "Sky Logistics";

    Drone(int droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    void startDelivery() {
        if (batteryPercentage >= 30)
            System.out.println("Drone " + droneId + " Started Delivery");
        else
            System.out.println("Battery Low");
    }

    void displayStatus() {
        System.out.println("Company: " + companyName);
        System.out.println("Drone ID: " + droneId);
        System.out.println("Battery: " + batteryPercentage + "%");
    }

    public static void main(String[] args) {

        Drone d1 = new Drone(1, 80);
        Drone d2 = new Drone(2, 25);
        Drone d3 = new Drone(3, 60);

        d1.startDelivery();
        d2.startDelivery();
        d3.startDelivery();

        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();
    }
}