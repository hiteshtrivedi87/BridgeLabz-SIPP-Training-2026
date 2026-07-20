package Collections.Queue_dequeue;

import java.util.PriorityQueue;

class Patient {
    int priority;
    String name;

    Patient(int priority, String name) { 
        this.priority = priority; 
        this.name = name; 
    }
}

class ERTriageSystem {
    private PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);

    void admitPatient(Patient p) {
        triageQueue.offer(p);
    }

    Patient callNextPatient() {
        return triageQueue.poll();
    }
}