package model;

public interface IHeap<T> {
    public void maxHeapify(T[] a,int b);
    public void buildMaxHeap(T[] a);
    public void heapSort(T[] a);

}
