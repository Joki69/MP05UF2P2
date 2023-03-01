package ex4;

// Original source code: https://gist.github.com/amadamala/3cdd53cb5a6b1c1df540981ab0245479
// Modified by Fernando Porrino Serrano for academic purposes.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementació d'una taula de hash sense col·lisions.
 * Original source code: https://gist.github.com/amadamala/3cdd53cb5a6b1c1df540981ab0245479
 */
public class HashTable<K, V> {
    private final int INITIAL_SIZE = 16;
    private List<Node<K, V>>[] buckets;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public HashTable() {
        this.buckets = new List[INITIAL_SIZE];
        this.size = 0;
    }

    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        return Math.abs(hash % buckets.length);
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        Node<K, V> head = null;
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        } else {
            head = findNodeWithKey(key, buckets[bucketIndex]);
        }

        if (head == null) {
            Node<K, V> newNode = new Node<>(key, value);
            buckets[bucketIndex].add(newNode);
            size++;
        } else {
            head.value = value;
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        if (buckets[bucketIndex] != null) {
            Node<K, V> node = findNodeWithKey(key, buckets[bucketIndex]);
            if (node != null) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        if (buckets[bucketIndex] != null) {
            Node<K, V> prev = null;
            Node<K, V> curr = buckets[bucketIndex].get(0);
            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        buckets[bucketIndex].remove(curr);
                    } else {
                        prev.next = curr.next;
                    }
                    size--;
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public int size() {
        return size;
    }

    private Node<K, V> findNodeWithKey(K key, List<Node<K, V>> bucket) {
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
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