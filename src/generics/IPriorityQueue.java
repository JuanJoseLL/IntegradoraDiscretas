package generics;

public interface IPriorityQueue<T> {

    public T deQueue();
    public T getMax();
    public void increaseKey(T a,int key);
    public void insert(T a,int key);

}
