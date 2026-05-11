/**
 * Represents a key-value pair node used in a HashMap.
 *
 * Time Complexity (per operation in bucket):
 * - Access: O(1) average, O(n) worst-case
 *
 * Space Complexity:
 * - O(n)
 */

public class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next; // Pointer to next node (for chaining)

    /**
     * Constructor to initialize key-value pair
     */
    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}