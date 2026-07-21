package Collections.Graphs;

import java.util.*;

public class CircuitCycleDetector {

    public static boolean hasWiringLoop(Map<Integer, List<Integer>> circuit, int n) {
        Set<Integer> visited = new HashSet<>();

        for (int v = 0; v < n; v++) {
            if (!visited.contains(v)) {
                if (dfsCycleCheck(circuit, v, -1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> circuit, int node, int parent, Set<Integer> visited) {
        visited.add(node);

        for (int neighbor : circuit.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                if (dfsCycleCheck(circuit, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int totalNodes = 4;
        Map<Integer, List<Integer>> circuit = new HashMap<>();

        circuit.put(0, Arrays.asList(1, 2));
        circuit.put(1, Arrays.asList(0, 2));
        circuit.put(2, Arrays.asList(1, 0, 3));
        circuit.put(3, Arrays.asList(2));

        System.out.println("Circuit contains wiring loop: " + hasWiringLoop(circuit, totalNodes));
    }
}
