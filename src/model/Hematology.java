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
    public String list(){
        String list="Hematology Queue\n"+" Name   "+"Illness  "+"Priority  \n";
        for (int i = 0; i < queue.getArr().size();i++){
            list+=queue.getArr().get(i).toString();
        }
        return list;
    }
}

