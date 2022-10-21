package model.DataEstructures;
import generics.*;


public class HashTable<K,V> implements MyHashT<K,V> {
    private int m;
    private Data<K,V>[] table;

    public HashTable(int m) {
        this.m = m;
        table = new Data[m];
    }

    public Data<K, V>[] getTable() {
        return table;
    }

    public int hash(K key) {
        return (Math.abs(key.hashCode())) % m;
    }

    @Override
    public void insert(K key, V value) {
        int insertKey = hash(key);  //1
        Data<K,V> nodeList = table[insertKey]; //1
        if(nodeList == null) {
            table[insertKey] = new Data<>(key, value); //1
        } else {
            while (nodeList != null) { //n+1
                if(nodeList.getKey().equals(key)) { //n
                    break;
                }
                nodeList = nodeList.getNext(); //n
            }
            Data<K,V> finalNode = new Data<>(key, value); //1
            table[insertKey].setPrevious(finalNode); //1
            finalNode.setNext(table[insertKey]); //1
            table[insertKey] = finalNode;  //1
        }
    }

    @Override
    public V search(K key) {
        V value = null;
        int searchKey = hash(key);
        Data<K,V> searchNode = table[searchKey];
        while (searchNode != null) {
            if(key.equals(searchNode.getKey())){
                value = searchNode.getValue();
            }
            searchNode = searchNode.getNext();
        }
        return value;
    }

    @Override
    public void deleteKey(K key) {
        int deleteKey = hash(key); //1
        Data<K,V> deleteNode = table[deleteKey]; //1
        while (deleteNode != null){ //n+1
            if(deleteNode.getKey().equals(key)){ //n
                Data<K,V> prev = deleteNode.getPrevious(); //1
                Data<K,V> next = deleteNode.getNext(); //1
                if(table[deleteKey].equals(deleteNode)){//1
                    table[deleteKey]=next; //1
                }else {
                    if(prev!= null) prev.setNext(next); //1
                    if(next != null) next.setPrevious(prev); //1
                }
            }
            deleteNode = deleteNode.getNext(); //n
        }


    }

    public void printAll(){
        for (Data<K,V> datito: table) {
            if(datito!=null){
                System.out.println(datito.getValue());
            }
        }
    }

}
