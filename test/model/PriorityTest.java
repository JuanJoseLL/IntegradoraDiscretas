package model;

import model.DataEstructures.PriorityQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class PriorityTest {
    private PriorityQueue<String> queue;

    private void setUp1(){
        queue=new PriorityQueue<>();
    }
    private void setUp2(){
        queue=new PriorityQueue<>();
        queue.insert("Juan", 5);
        queue.insert("Pablo", 2);
        queue.insert("Ana", 7);
        queue.insert("Sara", 9);
        queue.insert("David", 3);
        queue.insert("Maria", 4);
    }

    @Test
    public void addElementTest1(){
        setUp1();
        queue.insert("Juan",5);
        assertTrue(queue.getArr().get(0).getKey()==5 && queue.getArr().get(0).getElement().equals("Juan"));
    }

    @Test
    public void addElementTest2(){
        setUp2();
        queue.insert("Juan",1);
        assertEquals("Sara",queue.deQueue());
    }
    @Test
    public void addElementTest3(){
        setUp2();
        queue.insert("Sofia",10);
       assertEquals("Sofia",queue.deQueue());
    }

    @Test
    public void maxHeapifyTest1(){
        setUp2();
        queue.maxHeapify(2);
        assertEquals("9 7 4 5 2 3 ",queue.print());
    }
    @Test
    public void maxHeapifyTest2(){
        setUp2();
        queue.maxHeapify(1);
        assertEquals("9 7 4 5 2 3 ",queue.print());
    }
    @Test
    public void maxHeapifyTest3(){
        setUp2();
        queue.maxHeapify(3);
        assertEquals("9 7 4 5 2 3 ",queue.print());
    }
    @Test
    public void buildMaxHeapifyTest1(){
        setUp2();
        queue.buildMaxHeap();
        assertEquals("9 7 4 5 2 3 ",queue.print());
    }
    @Test
    public void buildMaxHeapifyTest2(){
        setUp1();
        queue.buildMaxHeap();
        assertEquals("",queue.print());
    }
    @Test
    public void extractMaxElementTest1(){
        setUp2();
        assertEquals("Sara",queue.deQueue());
    }
    @Test
    public void extractMaxTest2(){
        setUp1();
        assertNull(queue.deQueue());
    }
    @Test
    public void extractMaxTest3(){
        setUp2();
        int cont=0;
        for (int i = 0;i<queue.getArr().size();i++){
            if(queue.getArr().get(i)!=null){
                queue.deQueue();
                cont++;
            }
        }
        assertEquals(queue.getArr().size(),cont);
    }
    @Test
    public void increaseKeyTest1(){
        setUp2();
        queue.increaseKey("Juan",20);
        assertEquals("Juan",queue.deQueue());
    }
    @Test
    public void  increaseKeyTest2(){
        setUp2();
        queue.increaseKey("Juan",6);
        assertEquals("11 9 4 7 2 3 ",queue.print());
    }
    @Test
    public void showMaxTest1(){
        setUp2();
        assertEquals("Sara",queue.getMax());
    }
    @Test
    public void showMaxTest2(){
        setUp1();
        boolean flag = false;
        try{
            queue.getMax();
        }catch (IndexOutOfBoundsException e){
            flag=true;
        }
        assertTrue(flag);


    }
    @Test
    public void showMaxTest3(){
        setUp2();
        queue.deQueue();
        assertEquals("Ana",queue.getMax());
    }

}
