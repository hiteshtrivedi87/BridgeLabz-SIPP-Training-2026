package Collections.Queue_dequeue;
import java.util.Deque;
import java.util.ArrayDeque;

class PrintQueueSystem {
    private Deque<Integer> printQueue = new ArrayDeque<>();

    void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    int printNextJob() {
        return printQueue.removeFirst();
    }
}