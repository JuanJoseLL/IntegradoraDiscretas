package ui;
import model.Clinic;
import model.HashTable;
import model.PriorityQueue;


import java.util.Scanner;
public class main {
    public static Scanner lt = new Scanner(System.in);
    public static Clinic clinic = new Clinic();
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        boolean contineu = true;
        int option = 0;

        /*hash.insert(1000, "Juan");
        hash.insert(242, "Pablo");
        hash.insert(247, "Maria");
        hash.insert(10803, "Ana");
        hash.insert(83764, "Belen");
        hash.insert(13, "Salo");
        hash.insert(4353, "Tuti");
        hash.insert(9554, "Tomi");
        hash.insert(1234, "Cristo");
        hash.printAll();*/

       /* queue.insert("juan",1);
        queue.insert("Pablo",1);
        queue.insert("Pedro",3);
        queue.insert("Amiguito",1);
        queue.insert("OmaiGa",4 );
        queue.insert("PAtiño",2 );
        queue.insert("Yustes",3 );
        queue.insert("Veneco",3 );
        System.out.println(queue.print());
        queue.deQueue();
        System.out.println(queue.print());
        queue.deQueue();
        System.out.println(queue.print());*/
        while (contineu) {
            while (contineu) {
                System.out.println("1. Ingresar paciente");
                System.out.println("2. Egreso del paciente");
                System.out.println("3. Delete option");
                option = lt.nextInt();
                lt.nextLine();
                switch (option) {
                    case 1:
                        registerPatient();
                        break;
                    case 2:
                        break;
                    case 3:
                        contineu = false;
                        break;
                }
            }
        }
    }
    public static void registerPatient(){
        System.out.println("Type the id of the patient");
        String id=lt.nextLine();
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
        clinic.enterPatient(clinic.search(id), clinic.search(id).getPriority());
        clinic.test();
    }
}

