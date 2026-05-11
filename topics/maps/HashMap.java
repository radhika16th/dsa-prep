/**
 * Implements a HashMap using separate chaining.
 *
 * Idea:
 * - Uses an array of buckets
 * - Each bucket stores a linked list of Entry nodes
 * - Handles collisions using chaining
 * - Resizes when load factor exceeds threshold
 *
 * Uses:
 * - buckets: array storing linked lists of entries
 * - capacity: number of buckets
 * - size: number of key-value pairs
 *
 * Load Factor:
 * - Defined as size / capacity
 * - Resize when load factor > 0.75
 *
 * Time Complexity:
 * - put: O(1) average, O(n) worst-case
 * - get: O(1) average, O(n) worst-case
 * - remove: O(1) average, O(n) worst-case
 *
 * Space Complexity:
 * - O(n)
 */

public class HashMap<K, V> {
    private Entry<K, V>[] buckets; // Array of buckets (linked lists)
    private int capacity = 16; // Initial capacity
    private int size = 0; // Number of elements

    /**
     * Constructor initializes bucket array
     */
    public HashMap() {
        buckets = new Entry[capacity];
    }

    /**
     * Computes index for a given key
     */
    private int hash(K key) {
        // handle null keys safely
        if (key == null)
            return 0;

        return Math.abs(key.hashCode() % capacity);
    }

    /**
     * Inserts or updates a key-value pair
     */
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = buckets[index];

        // Check if key already exists → update
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new entry at head (chaining)
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++;

        // Resize if load factor exceeded
        if ((float) size / capacity > 0.75)
            resize();
    }

    /**
     * Retrieves value for a given key
     */
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key)))
                return head.value;
            head = head.next;
        }
        return null;
    }

    /**
     * Removes key-value pair from map
     */
    public void remove(K key) {
        int index = hash(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> prev = null;

        while (head != null) {
            if ((head.key == null && key == null) || (head.key != null && head.key.equals(key))) {
                // Remove node
                if (prev == null)
                    buckets[index] = head.next;
                else
                    prev.next = head.next;

                size--;
                return;
            }

            prev = head;
            head = head.next;
        }
    }

    /**
     * Resizes the bucket array when load factor is high
     */
    private void resize() {
        capacity *= 2;
        Entry<K, V>[] oldBuckets = buckets;
        buckets = new Entry[capacity];
        size = 0; // will be recalculated

        // Rehash all entries
        for (Entry<K, V> head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    /**
     * Returns number of elements
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert values
        map.put("apple", 3);
        map.put("banana", 5);
        map.put("apple", 10);

        // Get values
        System.out.println(map.get("apple")); // 10
        System.out.println(map.get("banana")); // 5

        // Remove key
        map.remove("banana");
        System.out.println(map.get("banana")); // null

        // Size check
        System.out.println("Size: " + map.size()); // 1
    }
}