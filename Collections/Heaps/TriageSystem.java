package Collections.Heaps;
import java.util.PriorityQueue;

public class TriageSystem {
    
    static class Patient {
        int severity;

        Patient(int severity) {
            this.severity = severity;
        }
    }

    private PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }
}