package Collections.Graphs;

import java.util.*;

public class BuildDependencyChecker {

    public static boolean hasCircularDependency(Map<Integer, List<Integer>> tasks, int n) {
        int[] state = new int[n];

        for (int v = 0; v < n; v++) {
            if (state[v] == 0) {
                if (dfsCycleCheck(tasks, v, state)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycleCheck(Map<Integer, List<Integer>> tasks, int node, int[] state) {
        state[node] = 1;

        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {
            if (state[dep] == 1) {
                return true;
            }
            if (state[dep] == 0 && dfsCycleCheck(tasks, dep, state)) {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        int totalTasks = 3;
        Map<Integer, List<Integer>> tasks = new HashMap<>();

        tasks.put(0, Collections.singletonList(1));
        tasks.put(1, Collections.singletonList(2));
        tasks.put(2, Collections.singletonList(0));

        System.out.println("Has circular dependency: " + hasCircularDependency(tasks, totalTasks));
    }
}