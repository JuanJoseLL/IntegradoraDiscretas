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
    public String list(){
        String list="General Purpose Queue\n"+"  Name   "+"Illness  "+" Priority  \n";
        for (int i = 0; i < queue.getArr().size();i++){
            list+=queue.getArr().get(i).toString();
        }
        return list;
    }
}
