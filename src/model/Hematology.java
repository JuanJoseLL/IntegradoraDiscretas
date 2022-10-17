package model;

import model.DataEstructures.PriorityQueue;

public class Hematology {
    private PriorityQueue<Patient> queue;

    public Hematology() {
        queue = new PriorityQueue<>();
    }
    public void enterPatient(Patient patient,int prio){
        queue.insert(patient,prio);
    }

    public void print(){
        queue.print();
    }
    public void deleteFromQueue(Patient obj){
        queue.deleteFromQueue(obj);
    }
    public Patient dequeue(){
        return queue.deQueue();
    }
    public String list(){
        String list="    Hematology\nName      illness      priority \n";
        list+= queue.print();
        return list;
    }
}

