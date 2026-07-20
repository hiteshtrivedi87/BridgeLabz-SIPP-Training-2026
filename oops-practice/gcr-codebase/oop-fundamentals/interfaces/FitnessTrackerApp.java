interface Trackable {
    void logActivity();
    default void resetData() {
        System.out.println("Trackable data reset successfully.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String deviceName;

    public FitnessDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void logActivity() {
        System.out.println(deviceName + " is logging active steps and heart rate.");
    }

    @Override
    public void generateReport() {
        System.out.println(deviceName + " generated a weekly fitness summary report.");
    }

    @Override
    public void sendAlert() {
        System.out.println(deviceName + " Alert: Sedentary reminder! Time to move!");
    }
}

public class FitnessTrackerApp {
    public static void main(String[] args) {
        FitnessDevice tracker = new FitnessDevice("FitBand Pro");
        
        tracker.logActivity();
        tracker.generateReport();
        tracker.sendAlert();
        tracker.resetData();
    }
}