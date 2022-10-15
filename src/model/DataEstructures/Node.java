package model.DataEstructures;


public class Node<T>  {
    private int key;
    private T element;

    public Node(int key, T element) {
        this.key = key;
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    @Override
    public String toString() {
        return  element+"\n";
    }
}

