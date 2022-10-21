package model;

import model.DataEstructures.PriorityQueue;

public class GeneralPurpose {
    private PriorityQueue<Patient> queue;

    public GeneralPurpose() {
        queue = new PriorityQueue<>();
    }
    public void enterPatient(Patient patient,int prio){
        queue.insert(patient,prio);
    }
    public void print(){
        System.out.println();
        System.out.println("General purpose");
        queue.print();
    }
    public void deleteFromQueue(Patient obj){
        queue.deleteFromQueue(obj);
    }
    public Patient dequeue(){
        return queue.deQueue();
    }
    public String list(){
        String list="   General Purpose\n";
        list+= queue.print();
        return list;
    }

    public PriorityQueue<Patient> getQueue() {
        return queue;
    }
}
