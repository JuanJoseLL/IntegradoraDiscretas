package ui;
import model.Clinic;
import model.DataEstructures.HashTable;
import model.GeneralPurpose;
import model.Hematology;
import model.Patient;


import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.Scanner;
public class main {
    public static Scanner lt = new Scanner(System.in);
    public static Clinic clinic = new Clinic();
    public static Hematology hem=new Hematology();
    public static GeneralPurpose gp=new GeneralPurpose();
    public static HashTable<String,Patient> hash=new HashTable<>(10);
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        boolean contineu = true;
        int option;
        while (contineu) {
            while (contineu) {
                System.out.println("1. Register Patient ");
                System.out.println("2. Entry Patient");
                System.out.println("3. Exit Patient");
                System.out.println("4. Patient List");
                System.out.println("5. Exit");
                option = lt.nextInt();
                lt.nextLine();
                switch (option) {
                    case 1 -> registerPatient();
                    case 2 -> entryQueue();
                    case 3 -> exitQueue();
                    case 4 -> System.out.println(clinic.patientsList());
                    case 5 -> contineu = false;
                    case 6 -> setup2();
                }
            }
        }
    }
    public static void registerPatient(){
        System.out.println("Type the id of the patient");
        String id=lt.nextLine();
        if(clinic.alreadyRegisterePatient(id)){
            System.out.println("Patient already registered");
        }else{
            System.out.println("Type the name of the patient");
            String name=lt.nextLine();
            System.out.println("Type the genre of the patient 1. Masculine 2. Feminine");
            int genre=lt.nextInt();
            lt.nextLine();
            System.out.println("Is the patient pregnant ?  1. Yes 2. No 3. Does not apply");
            int pregnant = lt.nextInt();
            lt.nextLine();
            System.out.println("Is the patient elderly ? 1. Yes 2. No");
            int elderly = lt.nextInt();
            lt.nextLine();
            System.out.println("Does patient has a serious illness ?  1. Yes 2. No");
            int illness=lt.nextInt();
            lt.nextLine();
            clinic.registerPatient(id,name,genre,pregnant,elderly,illness);
            System.out.println("Undo ? 1. Yes 2. No");
            int undo=lt.nextInt();
            lt.nextLine();
            if(undo==1){
                clinic.deleteFromHash(id);
            }

        }

    }
    public static void entryQueue(){
        System.out.println("Type the ID of the patient");
        String id = lt.nextLine();
        if(!clinic.alreadyRegisterePatient(id)){
            System.out.println("The patient is not registered");
        }else{
            System.out.println("Send to 1. Hematology 2. General purpose");
            int lab=lt.nextInt();
            lt.nextLine();
            clinic.enterPatient(clinic.search(id), clinic.search(id).getPriority(),lab);
            System.out.println("Undo ? 1. Yes 2. No");
            int undo=lt.nextInt();
            lt.nextLine();
            if(undo==1){
                clinic.deleteFromQueue(clinic.search(id),lab);
            }
        }

    }
    public static void exitQueue(){
        System.out.println("From which unit do you want to dequeue the patient ?  1. Hematology 2. General Purpose ");
        int lab=lt.nextInt();
        lt.nextLine();
        Patient pat=clinic.dequeue(lab);
        if(pat!=null){
            System.out.println("The patient "+pat.getName()+" has successfully exited the queue");
            System.out.println("Undo ? 1. Yes 2. No");
            int undo=lt.nextInt();
            lt.nextLine();
            if(undo==1){
                clinic.enterPatient(pat, pat.getPriority(),lab);
            }
        }else{
            System.out.println("No patients found in the queue");
        }

    }
    public static void setup1(){
        hem.enterPatient(new Patient("1","juan",1,2,2,2),0);
        hem.enterPatient(new Patient("1","pablo",1,1,2,2),1);
        gp.enterPatient(new Patient("1","maria",1,2,1,2),1);
        gp.enterPatient(new Patient("1","tapete",1,2,2,2),0);
        hem.enterPatient(new Patient("1","cristiano",1,2,2,2),0);
        System.out.println(hem.list());
        System.out.println(gp.list());
    }
    public static void setup2(){
        try {
            File file=new File("/Users/juanjose/IdeaProjects/IntegradoraDiscretas/docs/eps.txt");
            System.out.println("Existe: "+file.exists());
            FileInputStream fis=new FileInputStream(file);
            BufferedReader reader= new BufferedReader(new InputStreamReader(fis));
            StringBuilder json= new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                json.append(line);
            }
            fis.close();
            Gson gson=new Gson();
            Patient[] patients=gson.fromJson(json.toString(), Patient[].class);

            ArrayList<Patient> arrayPatients=new ArrayList<>();
            Collections.addAll(arrayPatients, patients);

            for (Patient p: patients){
                hash.insert(p.getId(),p);
            }

            hash.printAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

