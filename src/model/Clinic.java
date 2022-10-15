package model;

public class Clinic {
    private HashTable<String,Patient> hash;
    private PriorityQueue<Patient> queue;

    public Clinic() {
       hash = new HashTable<>(100);
       queue = new PriorityQueue<>();

    }
    public void registerPatient(String id, String name, int genre, int pregnant, int elderly, int illness){
        hash.insert(id,new Patient(id,name,genre,pregnant,elderly,illness));
    }
    public void enterPatient(Patient patient, int prio){
        queue.insert(patient,prio);
    }
    public Patient search(String id){
        return hash.search(id);
    }

    public HashTable<String, Patient> getHash() {
        return hash;
    }

    public void setHash(HashTable<String, Patient> hash) {
        this.hash = hash;
    }

    public PriorityQueue<Patient> getQueue() {
        return queue;
    }

    public void setQueue(PriorityQueue<Patient> queue) {
        this.queue = queue;
    }
}
