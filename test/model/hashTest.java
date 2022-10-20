package model;

import model.DataEstructures.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class hashTest<K,V> {
    private HashTable<String,Patient> hash;


    public void setUpStage1(){
        hash = new HashTable<>(10);
        hash.insert("1001",new Patient("1001","juan",2,3,2,2));
        hash.insert("1002",new Patient("1002","pablo",2,3,2,1));
        hash.insert("1003",new Patient("1003","david",2,3,1,2));
        hash.insert("1004",new Patient("1004","sara",1,2,2,2));
        hash.insert("1005",new Patient("1005","maria",1,2,2,2));
        hash.insert("1006",new Patient("1006","ana",1,1,2,2));
    }
    public void setUpStage2(){
        hash=new HashTable<>(5);
    }

    @Test
    public void insertOneElementTest(){
        setUpStage2();
        hash.insert("1001",new Patient("1001","juan",2,3,2,2));
        String expected="juan";
        assertEquals(expected, hash.search("1001").getName());
    }
    @Test
    public void insertTwoElementsTest(){
        setUpStage2();
        hash.insert("1002",new Patient("1002","pablo",2,3,2,1));
        String expected="pablo";
        assertEquals(expected, hash.search("1002").getName());
        hash.insert("1003",new Patient("1003","david",2,3,1,2));
        String expected2="david";
        assertEquals(expected2, hash.search("1003").getName());
    }

    @Test
    public void insertThreeElementsTest(){
        setUpStage2();
        hash.insert("1004",new Patient("1004","sara",1,2,2,2));
        String expected="sara";
        assertEquals(expected, hash.search("1004").getName());
        hash.insert("1005",new Patient("1005","maria",1,2,2,2));
        String expected2="maria";
        assertEquals(expected2, hash.search("1005").getName());
        hash.insert("1006",new Patient("1006","ana",1,1,2,2));
        String expected3="ana";
        assertEquals(expected3, hash.search("1006").getName());
    }
    @Test
    public void eliminateOneElementTest(){
        setUpStage1();
        hash.deleteKey("1001");
        assertNull(hash.search("1001"));
    }
    @Test
    public void eliminateTwoElementTest(){
        setUpStage1();
        hash.deleteKey("1002");
        hash.deleteKey("1003");
        assertNull(hash.search("1002"));
        assertNull(hash.search("1003"));
    }
    @Test
    public void eliminateNull(){
        setUpStage2();
        boolean flag=false;
        hash.insert("1005",new Patient("1005","kole",2,3,2,2));
        hash.deleteKey("1005");
        assertNull(hash.search("1005"));

    }

    @Test
    public void searchHashTest(){
        setUpStage1();
        assertEquals("juan",hash.search("1001").getName());
    }

    @Test
    public void searchHashTest2(){
        setUpStage1();
        assertNull(hash.search("1009"));

    }

    @Test
    public void searchHashTest3(){
        setUpStage1();
        assertEquals("1002",hash.search("1002").getId());
    }

}
