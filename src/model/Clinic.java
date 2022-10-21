package model;

import com.google.gson.Gson;
import model.DataEstructures.Data;
import model.DataEstructures.HashTable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Clinic {
    private Hematology hem;
    private GeneralPurpose gp;
    private HashTable<String,Patient> hash;
    private Gson gson;


    public Clinic() {
        gson=new Gson();
       hash = new HashTable<>(100);
       hem = new Hematology();
       gp = new GeneralPurpose();
       loadData();
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
    public void deleteFromQueue(Patient id,int lab){
        if(lab == 1){
            hem.deleteFromQueue(id);
        }else{
            gp.deleteFromQueue(id);
        }

    }
    public Patient dequeue(int lab){
        if(lab == 1){
            return hem.dequeue();
        }else{
           return gp.dequeue();
        }

    }
    public void loadData(){
        try {
            File file=new File("eps.json");
            FileInputStream fis=new FileInputStream(file);
            BufferedReader reader= new BufferedReader(new InputStreamReader(fis));
            String json="";
            String line;
            while ((line=reader.readLine())!=null){
                json+=line;
            }
            fis.close();
            Gson gson=new Gson();
            Patient[] patients=gson.fromJson(json, Patient[].class);

            ArrayList<Patient> arrayPatients=new ArrayList<>();
            Collections.addAll(arrayPatients, patients);

            for (Patient p: patients){
                hash.insert(p.getId(),p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveData(){
        ArrayList<Patient> pat=new ArrayList<>();
        try {
            FileOutputStream fos = new FileOutputStream(new File("eps.json"));
            for(Data p:hash.getTable()){
                if(p!=null){
                    pat.add((Patient) p.getValue());
                }
            }
            String json=gson.toJson(pat);
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String patientsList(){
        String message="";
        message+=hem.list();
        message+=gp.list();
        return message;
    }

    public Hematology getHem() {
        return hem;
    }

    public GeneralPurpose getGp() {
        return gp;
    }
}
