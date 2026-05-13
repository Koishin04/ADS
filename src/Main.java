package src.Graphs;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("Almaty", "Astana", 2.0);
        graph.addEdge("Almaty", "Shymkent", 5.0);
        graph.addEdge("Astana", "Shymkent", 1.0);
        graph.addEdge("Astana", "Kostanay", 4.0);
        graph.addEdge("Shymkent", "Kyzyloorda", 3.0);
        graph.addEdge("Kostanay", "Kyzyloorda", 1.0);

        System.out.println("--- Breadth First Search Execution ---");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Almaty");
        Vertex<String> destination = graph.getVertex("Kyzyloorda");
        printPath(bfs, destination);

        System.out.println("\n--- Dijkstra's Algorithm Execution ---");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "Almaty");
        printPath(dijkstra, destination);
        System.out.println("Total Shortest Path Cost: " + dijkstra.getDistanceTo(destination));
    }

    private static <V> void printPath(Search<V> search, Vertex<V> destination) {
        if (search.hasPathTo(destination)) {
            System.out.print("Path found: ");
            Iterable<Vertex<V>> path = search.pathTo(destination);
            for (Vertex<V> vertex : path) {
                System.out.print(vertex + " -> ");
            }
            System.out.println("End");
        } else {
            System.out.println("No reachable path exists.");
        }
    }
}