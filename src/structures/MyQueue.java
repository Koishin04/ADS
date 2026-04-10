package src.structures;

import src.implementations.MyLinkedList;

public class MyQueue<T> {
    private MyLinkedList<T> myLinkedList;

    public MyQueue() {
        myLinkedList = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        myLinkedList.addFirst(item);
    }

    public T dequeue() {
        T item = myLinkedList.getFirst();
        myLinkedList.removeFirst();
        return item;
    }

    public T peek() {
        myLinkedList.getFirst();
        return myLinkedList.getFirst();
    }

    public boolean isEmpty() {
        return myLinkedList.size() == 0;
    }
}
