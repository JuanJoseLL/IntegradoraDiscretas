package model;

public interface INode<T>{
    public T getValue();
    public void setValue(T value);
    public Node<T> getNext();
    public void setNext(Node<T> next);
}
