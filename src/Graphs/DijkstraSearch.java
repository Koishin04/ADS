package src.Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> extends Search<V> {
    private final Map<Vertex<V>, Double> distTo;
    private final PriorityQueue<VertexNode<V>> pq;

    private static class VertexNode<V> implements Comparable<VertexNode<V>> {
        Vertex<V> vertex;
        double distance;

        VertexNode(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexNode<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.distTo = new HashMap<>();
        this.pq = new PriorityQueue<>();

        for (Vertex<V> v : graph.getVertices().values()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }

        Vertex<V> start = graph.getVertex(source);
        if (start != null) {
            distTo.put(start, 0.0);
            pq.add(new VertexNode<>(start, 0.0));

            while (!pq.isEmpty()) {
                VertexNode<V> currentNode = pq.poll();
                Vertex<V> v = currentNode.vertex;

                if (marked.contains(v)) continue;
                marked.add(v);

                relax(v);
            }
        }
    }

    private void relax(Vertex<V> v) {
        for (Map.Entry<Vertex<V>, Double> entry : v.getAdjacentVertices().entrySet()) {
            Vertex<V> neighbor = entry.getKey();
            double weight = entry.getValue();

            if (distTo.get(neighbor) > distTo.get(v) + weight) {
                distTo.put(neighbor, distTo.get(v) + weight);
                edgeTo.put(neighbor, v);
                pq.add(new VertexNode<>(neighbor, distTo.get(neighbor)));
            }
        }
    }

    public double getDistanceTo(Vertex<V> target) {
        return distTo.getOrDefault(target, Double.POSITIVE_INFINITY);
    }
}