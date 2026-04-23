/**
 * Basics of Arrays
 */

class Basics {
    private int[] data;

    public Basics() {
        this.data = new int[]{2, 4, 19, 20, 43, 25, 13, 82, 20, 21, 0, 1, 45, 43};
    }

    // Traversal
    public void traversal() {
        for (int d : data) {
            System.out.println(d);
        }
    }

    // Insert
    public void insert(int i, int item) {
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
    public void remove(int i) {
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
}