package ex3;

// Original source code: https://gist.github.com/amadamala/3cdd53cb5a6b1c1df540981ab0245479
// Modified by Fernando Porrino Serrano for academic purposes.

import java.util.ArrayList;

/**
 * Implementació d'una taula de hash sense col·lisions.
 * Original source code: https://gist.github.com/amadamala/3cdd53cb5a6b1c1df540981ab0245479
 */
public class HashTable {
    private static final int DEFAULT_CAPACITY = 16;

    private int size;
    private int itemCount;
    private HashEntry[] table;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int initialCapacity) {
        this.size = initialCapacity;
        this.itemCount = 0;
        this.table = new HashEntry[size];
    }

    public int size() {
        return this.size;
    }

    public int count() {
        return this.itemCount;
    }

    /**
     * Permet afegir un nou element a la taula.
     *
     * @param key   La clau de l'element a afegir.
     * @param value El propi element que es vol afegir.
     */
    public void put(String key, String value) {
        int hash = getHash(key);
        final HashEntry entry = new HashEntry(key, value);

        if (table[hash] == null) {
            table[hash] = entry;
            itemCount++;
        } else {
            HashEntry current = table[hash];
            while (current.next != null && !current.key.equals(key)) {
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = entry;
                entry.prev = current;
                itemCount++;
            }
        }
    }

    /**
     * Permet recuperar un element dins la taula.
     *
     * @param key La clau de l'element a trobar.
     * @return El propi element que es busca (null si no s'ha trobat).
     */
    public String get(String key) {
        int hash = getHash(key);

        HashEntry current = table[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * Permet esborrar un element dins de la taula.
     *
     * @param key La clau de l'element a trobar.
     */
    public void drop(String key) {
        int hash = getHash(key);

        HashEntry current = table[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                if (current.prev == null) {
                    table[hash] = current.next;
                } else {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                itemCount--;
                break;
            }
            current = current.next;
        }
    }

    /**
     * Permet calcular quants elements col·lisionen (produeixen la mateixa posició dins la taula de hash) per a la clau donada.
     * @param key La clau que es farà servir per calcular col·lisions.
     * @return Una clau que, de fer-se servir, provoca col·lisió amb la que s'ha donat.
     */
    public String getCollisionsForKey(String key) {
        int hash = getHash(key);

        HashEntry current = table[hash];
        while (current != null) {
            if (!current.key.equals(key)) {
                return current.key;
            }
            current = current.next;
        }

        return null;
    }

    private int getHash(String key) {
        return key.hashCode() % size;
    }

    private static class HashEntry {
        String key;
        String value;
        HashEntry prev;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.prev = null;
        }
    }
    public static void main(String[] args) {
        ex2.HashTable hashTable = new ex2.HashTable();

        // Put some key values.
        for(int i=0; i<30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, key);
        }

        // Print the HashTable structure
        log("****   HashTable  ***");
        log(hashTable.toString());
        log("\nValue for key(20) : " + hashTable.get("20") );
    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}
