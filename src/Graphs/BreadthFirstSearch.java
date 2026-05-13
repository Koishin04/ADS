package src.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        Vertex<V> sourceVertex = graph.getVertex(source);
        if (sourceVertex != null) {
            bfs(sourceVertex);
        }
    }

    private void bfs(Vertex<V> start) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        marked.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();

            for (Vertex<V> neighbor : v.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    edgeTo.put(neighbor, v);
                    marked.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}