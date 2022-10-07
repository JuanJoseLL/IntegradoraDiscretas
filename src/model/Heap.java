package model;

public class Heap<T> implements IHeap<T>,Comparable{
    private int heapSize;
    @Override
    public void maxHeapify(T[] a,int b) {
        int l=2*b;
        int r=2*b+1;
        int largest;
        if (l<=heapSize && a[l]>a[b]){
            largest=l;
        }else{
            largest=b;
        }
        if(r<=heapSize && a[r]>largest){
            largest=r;
        }
        if(largest!=b){
            T temp = a[b];
            T temp2=a[largest];
            a[b]= temp2;
            a[largest]=temp;
            maxHeapify(a,largest);
        }


    }

    @Override
    public void buildMaxHeap(T[] a) {
        heapSize=a.length;
        for (int i = a.length/2; i >= 0; i++) {
                maxHeapify(a,i);
        }
    }

    @Override
    public void heapSort(T[] a) {
        buildMaxHeap(a);
        for (int i =a.length; i>0 ; i++) {

        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
