package src.structures;

import src.implementations.MyArrayList;

public class MyStack<T> {
    private MyArrayList<T> myList;

    public MyStack() {
        myList = new MyArrayList<>();
    }

    public void push(T item){
        myList.add(item);
    }

    public T peek(){
        if(isEmpty()) throw new java.util.EmptyStackException();
        return myList.get(myList.size()-1);
    }
    public T pop(){
        return myList.get(myList.size()-1);

    }

    public boolean isEmpty(){
        return myList.size() == 0;
    }
}
