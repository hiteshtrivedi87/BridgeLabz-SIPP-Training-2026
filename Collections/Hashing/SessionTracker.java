package Collections.Hashing;

import java.util.Set;
import java.util.HashSet;

class SessionTracker {
    public boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) {
                return true;
            }
        }
        return false;
    }
}
