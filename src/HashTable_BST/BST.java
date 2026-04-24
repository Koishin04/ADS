package src.HashTable_BST;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Node<K, V>> {
    private Node<K, V> root;
    private int size = 0;

    public static class Node<K, V> {
        private K key;
        private V val;
        private Node<K, V> left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public K getKey() { return key; }
        public V getValue() { return val; }
    }

    public int size() { return size; }

    public void put(K key, V val) {
        if (root == null) {
            root = new Node<>(key, val);
            size++;
            return;
        }
        Node<K, V> curr = root, prev = null;
        while (curr != null) {
            prev = curr;
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else { curr.val = val; return; }
        }
        if (key.compareTo(prev.key) < 0) prev.left = new Node<>(key, val);
        else prev.right = new Node<>(key, val);
        size++;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private Stack<Node<K, V>> stack = new Stack<>();
            { pushLeft(root); }

            private void pushLeft(Node<K, V> node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            public boolean hasNext() { return !stack.isEmpty(); }

            public Node<K, V> next() {
                if (!hasNext()) throw new NoSuchElementException();
                Node<K, V> node = stack.pop();
                pushLeft(node.right);
                return node;
            }
        };
    }
}