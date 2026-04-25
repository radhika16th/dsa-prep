/**
 * Basics of Arrays
 */

public class Basics {
    private static int[] data = new int[]{2, 4, 19, 20, 43, 25, 13, 82, 20, 21, 0, 1, 45, 43};

    // Traversal
    public static void traversal(int[] data) {
        for (int d : data) {
            System.out.print(d + " ");
        }
    }

    // Insert
    public static void insert(int i, int item) {
        // check input
        if (i > data.length) 
            throw new IllegalArgumentException("Insertion index out of bounds.");

        int[] newData = new int[data.length + 1]; // create longer list

        // copy before insert
        for (int j = 0; j < i; j++) 
            newData[j] = data[j];

        newData[i] = item; // insert

        // copy after
        for (int j = i; j < data.length; j++)
            newData[j + 1] = data[j];

        data = newData; // update the instance
    }

    // Remove
    public static void remove(int[] data, int i) {
        // check input
        if (i > data.length) 
            throw new IllegalArgumentException("Insertion index out of bounds.");
        
        int[] newData = new int[data.length - 1]; // create longer list

        // copy before removal
        for (int j = 0; j < i; j++) 
            newData[j] = data[j];
        
        // copy after
        for (int j = i; j < data.length; j++)
            newData[j - 1] = data[j];
        
        data = newData; // update the instance
    }
    
    // Find max
    public static void findMax() {
        int max = data[0];

        for (int d : data) {
            if (d > max)
                max = d;
        }

        System.out.println(max + " is the max.");
    }

    public static void main(String[] args) {
        Basics.traversal(data);
        System.out.println("\n" + data.length);

        // insert
        Basics.insert(10, 23);
        Basics.traversal(data);
        System.out.println("\n" + data.length);

        // remove
        Basics.remove(data, 10);
        Basics.traversal(data);
        System.out.println("\n" + data.length);

        // find max
        Basics.findMax();
    }
}