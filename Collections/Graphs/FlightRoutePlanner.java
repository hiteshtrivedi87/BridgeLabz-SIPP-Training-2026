package Collections.Graphs;

import java.util.*;

public class FlightRoutePlanner {

    public static List<Integer> fewestFlights(Map<Integer, List<Integer>> routes, int origin, int destination) {
        if (origin == destination) return Collections.singletonList(origin);

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(origin);
        visited.add(origin);
        parent.put(origin, null);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            if (city == destination) {
                break;
            }

            for (int next : routes.getOrDefault(city, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    parent.put(next, city);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(destination)) {
            return Collections.emptyList();
        }

        LinkedList<Integer> path = new LinkedList<>();
        Integer node = destination;
        while (node != null) {
            path.addFirst(node);
            node = parent.get(node);
        }

        return path;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> routes = new HashMap<>();
        routes.put(0, Arrays.asList(1, 2));
        routes.put(1, Arrays.asList(3));
        routes.put(2, Arrays.asList(3));
        routes.put(3, Arrays.asList(4));

        List<Integer> path = fewestFlights(routes, 0, 3);
        System.out.println("Fewest flights path: " + path);
    }
}