package src;

import src.implementations.MyArrayList;
import src.implementations.MyLinkedList;
import src.structures.MyStack;
import src.structures.MyQueue;
import src.structures.MyMinHeap;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("MyArrayList");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.add(10);
        list.add(20);
        list.add(5);
        list.addFirst(100);
        System.out.println("ArrayList content: " + java.util.Arrays.toString(list.toArray()));
        System.out.println("ArrayList size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        list.sort();
        System.out.println("Sorted ArrayList: " + list.get(0) + ", " + list.get(1));

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        System.out.println("");
        System.out.println("MyLinkedList");
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.addFirst("Cherry");
        System.out.println("LinkedList content: " + java.util.Arrays.toString(linkedList.toArray()));
        System.out.println("LinkedList size: " + linkedList.size()); // Ожидаем 3
        System.out.println("First element: " + linkedList.getFirst()); // Ожидаем Cherry
        linkedList.removeLast();
        System.out.println("Exists 'Banana'? " + linkedList.exists("Banana")); // Ожидаем false после удаления


        System.out.println("");
        System.out.println("MyStack");
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());



        System.out.println("");
        System.out.println("MyQueue");
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());




        System.out.println("");
        System.out.println("MyMinHeap");
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(50);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        System.out.println("MinHeap size: " + heap.size());
        System.out.println("Min element: " + heap.extractMin());
        System.out.println("Next min: " + heap.extractMin());
    }
}