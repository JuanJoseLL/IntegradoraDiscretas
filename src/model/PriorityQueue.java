package model;

import generics.IPriorityQueue;

import java.util.ArrayList;

public class PriorityQueue<T> implements IPriorityQueue<T> {
    private int heapSize;
    private ArrayList<Node<T>> arr;

    public PriorityQueue() {
        arr=new ArrayList<>();
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public Node<T> getParent(int i){
        return arr.get((int)i/2);
    }

    public void maxHeapify(int b) {
        int l=2*b;
        int r=2*b+1;
        int largest;
        if (l<=heapSize-1 && arr.get(l).getKey()> arr.get(b).getKey()){
            largest=l;
        }else{
            largest=b;
        }
        if(r<=heapSize-1 && arr.get(r).getKey()>largest){
            largest=r;
        }
        if(largest!=b){
            Node<T> temp = arr.get(b);
            Node<T> temp2= arr.get(largest);
            arr.set(b,temp2);
            arr.set(largest,temp);
            maxHeapify(largest);
        }

    }

    public void buildMaxHeap() {
        heapSize= arr.size();
        for (int i = arr.size()/2; i >= 0; i--) {
                maxHeapify(i);
        }

    }


    @Override
    public T deQueue() {
        if(arr.size()<2){
            System.out.println("Error");
            return null;
        }
        T max=arr.get(0).getElement();
        arr.set(0,arr.get(arr.size()-1));
        arr.remove(arr.size()-1);
        maxHeapify(1);
        return max;
    }

    @Override
    public T getMax() {
        return arr.get(0).getElement();
    }

    @Override
    public void increaseKey(T a, int key) {
        int aux=-1;
       for(int i=0;i<arr.size();i++){
           if(arr.get(i).getElement().equals(a)){
                aux=i;
           }
           if(key<arr.get(aux).getKey()){
               System.out.println("The key is lower than the actual");
           }
       }
       while (aux>0 && arr.get(aux/2).getKey()<arr.get(aux).getKey()){
           Node<T> temp1 = arr.get(aux/2);
           Node<T> temp2 = arr.get(aux);
           arr.set(aux, temp1);
           arr.set(aux/2, temp2);
           aux = aux/2;
       }

    }

    @Override
    public void insert(T a, int key) {
        arr.add(new Node<>(key,a));
        buildMaxHeap();
    }
}
