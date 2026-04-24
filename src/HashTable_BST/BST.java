import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

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

    public int size() {
        return size;
    }

    public void put(K key, V val) {
        Node<K, V> newNode = new Node<>(key, val);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node<K, V> current = root;
        Node<K, V> parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.val = val;
                return;
            }
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left = newNode;
        else parent.right = newNode;
        size++;
    }

    public V get(K key) {
        Node<K, V> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return current.val;
        }
        return null;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<Node<K, V>> {
        private Stack<Node<K, V>> stack = new Stack<>();

        public BSTIterator(Node<K, V> root) {
            pushLeftNodes(root);
        }

        private void pushLeftNodes(Node<K, V> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Node<K, V> next() {
            if (!hasNext()) throw new NoSuchElementException();

            Node<K, V> node = stack.pop();
            if (node.right != null) {
                pushLeftNodes(node.right);
            }
            return node;
        }
    }
}