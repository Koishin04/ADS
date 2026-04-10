package src.implementations;

import src.interfaces.MyList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }
    private void increaseBuffer(){
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public void add(T item) {
        if (size == elements.length) {
            increaseBuffer();
        }
        elements[size++] = item;

    }
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(index + size);
        }
        return (T) elements[index];

    }

    @Override
    public int size() {
        return  size;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == elements.length) increaseBuffer();

        // Сдвигаем элементы вправо, освобождая место
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }


    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public void clear() {
        elements = new Object[10];
        size = 0;
    }




    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return (T) elements[cursor++];
            }
        };
    }
    @Override
    public Object[] toArray(){
        Object[] copy = new Object[size];
        for (int i = 0; i < size; i++) {
            copy[i] = elements[i];
        }
        return copy;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public void addFirst(T item) {
        add(0, item);
    }
    @Override
    public void addLast(T item) {
        if (size == elements.length) increaseBuffer();
        elements[size++] = item;
    }
    @Override
    public T getFirst() {
        return (T) elements[0];
    }
    @Override
    public T getLast() {
        return (T) elements[size - 1];
    }
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Здесь мы работаем только в пределах size,
                // так что elements[j] точно не null
                if (((Comparable<T>) elements[j]).compareTo((T) elements[j + 1]) > 0) {
                    T temp = (T) elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
}




