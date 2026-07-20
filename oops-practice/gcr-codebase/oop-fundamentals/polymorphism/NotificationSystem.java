class Notification {
    String recipientName;
    String message;

    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    public void sendNotification() {
        System.out.println("Sending a generic notification to " + recipientName);
    }
}

class EmailNotification extends Notification {
    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[EMAIL] To: " + recipientName + " | Content: " + message);
    }
}

class SMSNotification extends Notification {
    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[SMS] To: " + recipientName + " | Text: " + message);
    }
}

class PushNotification extends Notification {
    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    public void sendNotification() {
        System.out.println("[PUSH NOTIFICATION] Alerting " + recipientName + ": " + message);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Alice Smith", "Your invoice is ready."),
            new SMSNotification("Bob Jones", "Your OTP is 4821."),
            new PushNotification("Charlie Brown", "Someone liked your photo!")
        };

        System.out.println("--- Processing Sent Notifications ---");
        for (Notification n : notifications) {
            n.sendNotification(); 
        }
    }
}