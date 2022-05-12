public class MergeSort {
    static final int SIZE = (int)1e7;
    static final int RANGE = (int)1e9;

    // generate a random array
    public static int[] generate() {
        int[] res = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            res[i] = (int)(Math.random() * RANGE);
        }
        return res;
    }

    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int n : arr) {
            if (!first) {
                sb.append(", " + n);
            } else {
                sb.append(n);
                first = false;
            }
        }
        System.out.println(sb);
    }

    // sort with mergesort
    static void mergeSort(int arr[]) {
        if (arr.length > 1) {
            int n = arr.length;
            int middle = n / 2;

            // create 2 sub-arrays from arr
            int[] sub1 = new int[middle];
            for (int i = 0; i < middle; i++) {
                sub1[i] = arr[i];
            }
            int[] sub2 = new int[n - middle];
            for (int i = middle; i < n; i++) {
                sub2[i - middle] = arr[i];
            }

            // sort first and second halves
            mergeSort(sub1);
            mergeSort(sub2);

            // merge sub1 and sub2 into the original array
            merge(sub1, sub2, arr);
        }
    }

    // merge two sub-arrays sub1 and sub2 into the array dest
    static void merge(int[] sub1, int[] sub2, int[] dest) {
        int p1 = 0, p2 = 0, pDest = 0;  // pointers to 3 arrays
        while (p1 < sub1.length && p2 < sub2.length) {
            if (sub1[p1] <= sub2[p2]) {
                dest[pDest] = sub1[p1];
                p1++;
            } else {
                dest[pDest] = sub2[p2];
                p2++;
            }
            pDest++;
        }

        // copy remaining elements, if any
        while (p1 < sub1.length) {
            dest[pDest++] = sub1[p1++];
        }
        while (p2 < sub2.length) {
            dest[pDest++] = sub2[p2++];
        }
    }

    public static void main(String[] args) {
        int[] test = generate();
        System.out.println("Original array");
        // print(test);
        mergeSort(test);
        System.out.println("After merge sort");
        // print(test);
    }
}