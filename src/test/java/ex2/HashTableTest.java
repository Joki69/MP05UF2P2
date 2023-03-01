package ex2;

import ex2.HashTable;
import org.junit.jupiter.api.Assertions;

class HashTableTest {

    @org.junit.jupiter.api.Test
    void count() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void putPrueba1() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0]", hashTable.toString());
    }
    @org.junit.jupiter.api.Test
    void putPrueba2() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("1","1");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0]\n" +
                " bucket[1] = [1, 1]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putPrueba3() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putPrueba4() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00] -> [000, 000]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putPrueba5() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("0","0v2");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0v2]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putPrueba6() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("00","00v2");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00v2]", hashTable.toString());
    }
    @org.junit.jupiter.api.Test
    void putPrueba7() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("000","000v2");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00] -> [000, 000v2]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void putPrueba8() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        hashTable.put("0000","0000v2");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00] -> [000, 000] -> [0000, 0000v2]", hashTable.toString());
    }


    @org.junit.jupiter.api.Test
    void getPrueba1() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        Assertions.assertEquals(hashTable.get("0"),"0");
    }

    @org.junit.jupiter.api.Test
    void getPrueba2() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        Assertions.assertEquals(hashTable.get("00"),"00");
    }

    @org.junit.jupiter.api.Test
    void getPrueba3() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        Assertions.assertEquals(hashTable.get("000"),"000");
    }

    @org.junit.jupiter.api.Test
    void getPrueba4() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        Assertions.assertEquals(hashTable.get("0000"),"0000");

    }

    @org.junit.jupiter.api.Test
    void getPrueba5() {
        HashTable hashTable = new HashTable();
        Assertions.assertEquals(hashTable.get("0"),null);


    }

    @org.junit.jupiter.api.Test
    void getPrueba6() {
        //no funciona aun
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        Assertions.assertEquals(hashTable.get("00"),null);
    }

    @org.junit.jupiter.api.Test
    void getPrueba7() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        hashTable.drop("0");
        Assertions.assertEquals(hashTable.get("0"),null);
    }

    @org.junit.jupiter.api.Test
    void dropPrueba1() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        hashTable.drop("0");
        Assertions.assertEquals("\n" +
                " bucket[0] = [00, 00] -> [000, 000] -> [0000, 0000]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void dropPrueba2() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        hashTable.drop("00");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [000, 000] -> [0000, 0000]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void dropPrueba3() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        hashTable.drop("000");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00] -> [0000, 0000]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void dropPrueba4() {
        HashTable hashTable = new HashTable();
        hashTable.put("0","0");
        hashTable.put("00","00");
        hashTable.put("000","000");
        hashTable.put("0000","0000");
        hashTable.drop("0000");
        Assertions.assertEquals("\n" +
                " bucket[0] = [0, 0] -> [00, 00] -> [000, 000]", hashTable.toString());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void getCollisionsForKey() {
    }

    @org.junit.jupiter.api.Test
    void testGetCollisionsForKey() {
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}