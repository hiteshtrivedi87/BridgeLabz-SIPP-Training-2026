interface StreamingService {
    void streamMovie(String movie);
    default void showSubscriptionDetails() {
        System.out.println("Streaming Service: Premium UHD Subscription active.");
    }
}

interface GamingService {
    void playGame(String game);
    default void showSubscriptionDetails() {
        System.out.println("Gaming Service: Cloud Gaming Pass active.");
    }
}

class SmartTV implements StreamingService, GamingService {
    
    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    @Override
    public void streamMovie(String movie) {
        System.out.println("Now Streaming Movie: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Launching Game: " + game);
    }

    public void displayContent(String[] movies, String[] games) {
        System.out.println("--- Available Movies ---");
        for (String movie : movies) {
            streamMovie(movie);
        }
        System.out.println("\n--- Available Games ---");
        for (String game : games) {
            playGame(game);
        }
    }
}

public class SmartTVApp {
    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar", "The Matrix"};
        String[] games = {"Cyberpunk 2077", "Elden Ring", "Fifa 26"};

        SmartTV tv = new SmartTV();
        
        System.out.println("=== Subscription Info ===");
        tv.showSubscriptionDetails();
        System.out.println();

        tv.displayContent(movies, games);
    }
}