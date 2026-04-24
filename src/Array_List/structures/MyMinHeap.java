package src.Array_List.structures;
import src.Array_List.implementations.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void insert(T item) {
        list.addLast(item);
        traverseUp(list.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        T min = list.getFirst();
        T lastItem = list.getLast();

        if (list.size() > 1) {
            list.set(0, lastItem);
            list.removeLast();
            traverseDown(0);
        } else {
            list.removeLast();
        }
        return min;
    }

    private void traverseUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) >= 0) break;
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void traverseDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < list.size() && list.get(leftChild).compareTo(list.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < list.size() && list.get(rightChild).compareTo(list.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}