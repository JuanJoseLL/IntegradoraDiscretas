package ui;
import model.Clinic;


import java.util.Scanner;
public class main {
    public static Scanner lt = new Scanner(System.in);
    public static Clinic clinic = new Clinic();
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        boolean contineu = true;
        int option;
        while (contineu) {
            while (contineu) {
                System.out.println("1. Ingresar paciente");
                System.out.println("2. Egreso del paciente");
                System.out.println("3. Patients list");
                System.out.println("4. Exit");
                option = lt.nextInt();
                lt.nextLine();
                switch (option) {
                    case 1:
                        registerPatient();
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println(clinic.patientsList());
                        break;
                    case 4:
                        contineu = false;
                        break;
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
            System.out.println("Send to 1. Hematology 2. General purpose");
            int lab=lt.nextInt();
            lt.nextLine();
            clinic.registerPatient(id,name,genre,pregnant,elderly,illness);
            clinic.enterPatient(clinic.search(id), clinic.search(id).getPriority(),lab);
            System.out.println("Undo ? 1. Si 2. No");
            int undo=lt.nextInt();
            lt.nextLine();
            if(undo==1){
                clinic.deleteFromQueue(clinic.search(id));
                clinic.deleteFromHash(id);
            }

        }


    }
}

