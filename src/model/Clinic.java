package model;

import model.DataEstructures.HashTable;
import model.DataEstructures.PriorityQueue;

public class Clinic {
    private Hematology hem;
    private GeneralPurpose gp;
    private HashTable<String,Patient> hash;
    private PriorityQueue<Patient> queue;

    public Clinic() {
       hash = new HashTable<>(5);
       queue = new PriorityQueue<>();
       hem = new Hematology();
       gp = new GeneralPurpose();

    }
    public void registerPatient(String id, String name, int genre, int pregnant, int elderly, int illness){
        hash.insert(id,new Patient(id,name,genre,pregnant,elderly,illness));
    }
    public void enterPatient(Patient patient, int prio,int lab){
        if(lab == 1){
            hem.enterPatient(patient,prio);
        }else{
            gp.enterPatient(patient,prio);
        }
    }
    public Patient search(String id){
        return hash.search(id);
    }
    public boolean alreadyRegisterePatient(String id){
        return hash.search(id) != null;
    }
    public void deleteFromHash(String id){
        hash.deleteKey(id);
    }
    public void deleteFromQueue(Patient id){
        queue.deleteFromQueue(id);
    }
    public void print(){
      hem.print();
      gp.print();
    }
    public String patientsList(){
        String message="";
        message+=hem.list();
        message+= gp.list();
        return message;
    }
}
