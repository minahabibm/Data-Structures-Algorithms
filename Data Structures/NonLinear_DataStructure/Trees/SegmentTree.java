/**  
 * This code implements a Segment Tree in Java. It allows for building the tree from an array, updating values, and querying the minimum value in a given range.
 * The Segment Tree is a binary tree where each node represents a segment of the array. The tree is built in a way that allows for efficient range queries and updates.
 * The Segment Tree is particularly useful for problems involving range queries and updates, such as finding the minimum or maximum value in a range, or calculating the sum of elements in a range.
 * The time complexity for building the tree is O(n), for updating a value is O(log n), and for querying a range is O(log n).
 * The space complexity is O(n) for storing the tree.import java.util.Arrays;
 */
import java.util.Arrays;
// import java.util.Scanner;


class SegmentTree {
    private int[] tree;
    private int size;

    public SegmentTree(int[] arr) {
        size = arr.length;
        tree = new int[4 * size];
        build(arr, 0, 0, size - 1);
    }

    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftIdx = 2 * node + 1;
            int rightIdx = 2 * node + 2;

            build(arr, leftIdx, start, mid);
            build(arr, rightIdx, mid+1, end);
            tree[node] = tree[leftIdx] + tree[rightIdx];
            // tree[node] = Math.max(tree[leftIdx], tree[rightIdx]);   // For min/max segment tree
        }
    }

    public void update(int index, int value) {
        update(0, 0, size - 1, index, value);
    }
    private void update(int node, int start, int end, int index, int value) {
        if (start == end) {
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            int leftIdx = 2 * node + 1;
            int rightIdx = 2 * node + 2;
            if (start <= index && index <= mid)
                update(leftIdx, start, mid, index, value);
            else 
                update(rightIdx, mid+1, end, index, value);
            tree[node] = tree[leftIdx] + tree[rightIdx];
            // tree[node] = Math.max(tree[leftIdx], tree[rightIdx]);   // For min/max segment tree
        }
    }

    public int query(int left, int right) {
        return query(0, 0, size - 1, left, right);
    }
    private int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) 
            return 0; 
        
        if (left <= start && end <= right)
            return tree[node];
        
        int mid = (start + end) / 2;
        int leftIdx = 2 * node + 1;
        int rightIdx = 2 * node + 2;
        int leftQuery = query(leftIdx, start, mid, left, right);
        int rightQuery = query(rightIdx, mid+1, end, left, right);
        return leftQuery + rightQuery;
        // return Math.max(leftQuery, rightQuery);   // For min/max segment tree
    }

    public void printTree() {
        System.out.println("Segment Tree: " + Arrays.toString(tree));
    }   


    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(arr);
        
        segmentTree.printTree();
        
        // Query sum of elements in range [1, 3]
        System.out.println("Query (1, 3): " + segmentTree.query(1, 3));  // Output should be 15 (3+5+7)

        // Update element at index 1
        segmentTree.update(1, 10);

        // Query again after the update
        System.out.println("Query (1, 3): " + segmentTree.query(1, 3));  // Output should be 22 (10+5+7)

        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the number of elements: ");
        // int n = scanner.nextInt();
        // int[] arr = new int[n];
        // System.out.print("Enter the elements: ");
        // for (int i = 0; i < n; i++) {
        //     arr[i] = scanner.nextInt();
        // }
    }
}