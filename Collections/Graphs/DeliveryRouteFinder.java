package Collections.Graphs;

import java.util.*;

public class DeliveryRouteFinder {

    public static List<List<Integer>> findAllRoutes(Map<Integer, List<Integer>> roads, int source, int target) {
        List<List<Integer>> allRoutes = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        dfsAllPaths(roads, source, target, currentPath, visited, allRoutes);
        return allRoutes;
    }

    private static void dfsAllPaths(Map<Integer, List<Integer>> roads, int current, int target,
                                    List<Integer> path, Set<Integer> visited, List<List<Integer>> allRoutes) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutes.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    dfsAllPaths(roads, next, target, path, visited, allRoutes);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = new HashMap<>();
        roads.put(1, Arrays.asList(2, 3));
        roads.put(2, Arrays.asList(4));
        roads.put(3, Arrays.asList(2, 4));

        List<List<Integer>> routes = findAllRoutes(roads, 1, 4);
        System.out.println("All routes from 1 to 4: " + routes);
    }
}
