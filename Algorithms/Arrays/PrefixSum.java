public class PrefixSum {
    
    public int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    // Get sum of subarray [L, R]
    public int rangeSum(int[] arr, int L, int R) {
        if (L == 0) return arr[R];
        return arr[R] - arr[L - 1];
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        PrefixSum prefixSum = new PrefixSum();
        int[] prefixSumArr = prefixSum.prefixSum(arr);

        System.out.println("Prefix sum of array: ");
        for (int i = 0; i < prefixSumArr.length; i++) {
            System.out.print(prefixSumArr[i] + " ");
        }
        System.out.println("");

        System.out.println("Sum of range [1, 3]: " + prefixSum.rangeSum(prefixSumArr, 1, 3)); // 18
        System.out.println("Sum of range [2, 4]: " + prefixSum.rangeSum(prefixSumArr, 2, 4)); // 24
    }
}