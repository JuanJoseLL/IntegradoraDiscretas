package ui;
import model.MyHashTable;
import model.PriorityQueue;

import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner lt = new Scanner(System.in);
        MyHashTable<Integer,String> hash=new MyHashTable<>(9);
        PriorityQueue<String> queue= new PriorityQueue<>();
        boolean contineu = true;
        int option=0;

        hash.insert(1000,"Juan");
        hash.insert(242,"Pablo");
        hash.insert(247,"Maria");
        hash.insert(10803,"Ana");
        hash.insert(83764,"Belen");
        hash.insert(13,"Salo");
        hash.insert(4353,"Tuti");
        hash.insert(9554,"Tomi");
        hash.insert(1234,"Cristo");
        hash.print();

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
        /*while (contineu){
            System.out.println("1. Ingresar paciente");
            System.out.println("2. Egreso del paciente");
            switch (option){
                case 1:
                    break;
                case 2:
                    break;
            }
        }*/
    }
}
