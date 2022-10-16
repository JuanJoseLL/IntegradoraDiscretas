package model.DataEstructures;

import generics.IPriorityQueue;
import model.Patient;

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

    public ArrayList<Node<T>> getArr() {
        return arr;
    }

    public Node<T> getParent(int i){
        return arr.get((int)i/2);
    }

    public void maxHeapify(int b) {
        int l=2*b;
        int r=2*b+1;
        int largest;
        if (l<=arr.size()-1 && arr.get(l).getKey() > arr.get(b).getKey()){
            largest=l;
        }else{
            largest=b;
        }
        if(r<=arr.size()-1 && arr.get(r).getKey() > arr.get(largest).getKey()){
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
        heapSize = arr.size();
        for (int i = arr.size()/2; i >= 0; i--) {
                maxHeapify(i);
        }

    }
    public void deleteFromQueue(Patient obj){
        for (int i = 0;i < arr.size();i++){
            if(arr.get(i).getElement().equals(obj)){
                arr.remove(i);
            }
        }
    }
    @Override
    public T deQueue() {
        int p = 0;
        if(arr.size()<1){
            return null;
        }else{
            for (int i=1;i < arr.size();i++){
                if(arr.get(i).getKey()>arr.get(p).getKey()){
                    p=i;
                }
            }
            T max = arr.get(p).getElement();
            arr.remove(p);
            return max;
        }


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
    public String print(){
        StringBuilder message= new StringBuilder();
        for (int i = 0;i<arr.size();i++){
            message.append(arr.get(i).toString());
        }
        return message.toString();
    }
}
