interface TextModeration {
    boolean containsOffensiveContent(String post);
    default void displayModerationPolicy() {
        System.out.println("Policy: Inappropriate, offensive, or harassing content is forbidden.");
    }
}

interface SpamDetection {
    boolean isSpam(String post);
    default void displayModerationPolicy() {
        System.out.println("Policy: Repeated links, advertisements, and bot-like texts are forbidden.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    
    @Override
    public void displayModerationPolicy() {
        System.out.println("=== Global Content Moderation Policy ===");
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    @Override
    public boolean containsOffensiveContent(String post) {
        return containsRestrictedWords(post, new String[]{"hate", "ugly", "stupid"});
    }

    @Override
    public boolean isSpam(String post) {
        return containsRestrictedWords(post, new String[]{"buy now", "click here", "free money"});
    }

    public static boolean containsRestrictedWords(String post) {
        String[] globalFlagged = {"hate", "ugly", "stupid", "buy now", "click here", "free money"};
        for (String word : globalFlagged) {
            if (post.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsRestrictedWords(String post, String[] keywords) {
        for (String word : keywords) {
            if (post.toLowerCase().contains(word)) {
                return true;
            }
        }
        return false;
    }
}

public class SocialPlatformApp {
    public static void main(String[] args) {
        String[] posts = {
            "Hello everyone, hope you are having a wonderful day!",
            "Click here to claim your free money instantly!",
            "I absolutely hate this feature, it is completely stupid.",
            "Check out my new travel blog update.",
            "Buy now before the stock runs out!"
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();
        System.out.println("\n=== Processing Posts ===");

        for (String post : posts) {
            System.out.println("Post: \"" + post + "\"");
            
            boolean isSpam = moderator.isSpam(post);
            boolean isOffensive = moderator.containsOffensiveContent(post);

            if (isSpam) {
                System.out.println("Status: REJECTED (Reason: Spam)");
            } else if (isOffensive) {
                System.out.println("Status: REJECTED (Reason: Offensive)");
            } else {
                System.out.println("Status: APPROVED (Valid Post)");
            }
            System.out.println("------------------------------------------------");
        }
    }
}