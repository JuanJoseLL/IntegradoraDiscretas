package ui;
import model.Clinic;
import model.Patient;


import java.util.*;
public class Main {
    public static Scanner lt = new Scanner(System.in);
    public static Clinic clinic = new Clinic();

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
                    case 5 -> {
                        clinic.saveData();
                        contineu = false;
                    }

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
            System.out.println("Does the patient has a serious illness ?  1. Yes 2. No");
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
        System.out.println("Client registered succesfully.");
    }
    public static void entryQueue(){
        System.out.println("Type the ID of the patient");
        String id = lt.nextLine();
        if(!clinic.alreadyRegisterePatient(id)){
            System.out.println("The patient is not registered");
        }else if(clinic.getHem().getQueue().search(id)){
            System.out.println("Patient already entered to one queue");
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
            System.out.println("Client added successfully to the queue");

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
        System.out.println("Client had been exited succesfully");

    }

}

