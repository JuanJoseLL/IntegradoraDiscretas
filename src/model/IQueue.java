package model;

public interface IQueue<T> {
    public T peek();
    public T poll();
    public void offer(T element);
    public boolean isEmpty();
}
