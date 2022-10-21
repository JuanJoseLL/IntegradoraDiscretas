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

    public void maxHeapify(int index) {
        int l=2*index;
        int r=2*index+1;
        int largest;
        if (l<=arr.size()-1 && arr.get(l).getKey() > arr.get(index).getKey()){
            largest=l;
        }else{
            largest=index;
        }
        if(r<=arr.size()-1 && arr.get(r).getKey() > arr.get(largest).getKey()){
            largest=r;
        }
        if(largest!=index){
            Node<T> temp = arr.get(index);
            Node<T> temp2= arr.get(largest);
            arr.set(index,temp2);
            arr.set(largest,temp);
            maxHeapify(largest);
        }

    }
    public void buildMaxHeap() {
        heapSize = arr.size();
        for (int i = arr.size(); i >= 0; i--) {
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
            for (int i=0;i < arr.size();i++){
                if(arr.get(i).getKey()>arr.get(p).getKey()){
                    p=i;
                }
            }
            T max = arr.get(p).getElement();
            arr.remove(p);
            maxHeapify(1);
            return max;
        }


    }

    @Override
    public T getMax() {
        return arr.get(0).getElement();
    }

    @Override
    public void increaseKey(T element, int newKey) {
        int index = -1;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).getElement().equals(element)){
                index = i;
            }
        }
        if(newKey > arr.get(index).getKey()) {
            arr.get(index).setKey(arr.get(index).getKey()+newKey);
            buildMaxHeap();
        }
    }
    @Override
    public void insert(T a, int key) {
        arr.add(new Node<>(key,a));
        buildMaxHeap();
    }
    public boolean search(String id){
        for (Node<T> node:arr){
            Patient a=(Patient) node.getElement();
            if(a.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public String print(){
        String message="";
        int cont=0;
        for (Node<T> tNode : arr) {
            Patient a=(Patient)tNode.getElement();
            message +=++cont+". "+a.getName()+"\n";
        }
        return message;
    }


}
