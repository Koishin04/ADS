package src.Graphs;

import java.util.*;

public abstract class Search<V> {
    protected final V source;
    protected final Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Set<Vertex<V>> marked;

    public Search(V source) {
        this.source = source;
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
    }

    public boolean hasPathTo(Vertex<V> target) {
        return marked.contains(target);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> target) {
        if (!hasPathTo(target)) return null;

        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = target; x != null; x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        return path;
    }
}