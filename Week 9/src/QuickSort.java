public class QuickSort {
    static final int SIZE = (int)1e6;
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

    // sort with quick sort
    static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p);
            quickSort(arr, p + 1, right);
        }
    }

    // Hoare partition
    // Return a partition point p
    // Where all elements arr[left -> p] <= all elements arr[p + 1, right]
    // Ref: https://en.wikipedia.org/wiki/Quicksort#Hoare_partition_scheme
    static int partition(int arr[], int left, int right) {
        int p = arr[left];  // select the left-most element as pivot
        int front = left;
        int back = right;
        while (true) {
            while (arr[front] < p) {
                front++;
            }
            while (arr[back] > p) {
                back--;
            }
            if (front >= back) {
                return back;
            }
            // swapping
            int t = arr[front];
            arr[front] = arr[back];
            arr[back] = t;
            front++;
            back--;
        }
    }

    public static void main(String[] args) {
        int[] test = generate();
        System.out.println("Original array");
        // print(test);
        quickSort(test, 0, test.length - 1);
        System.out.println("After quick sort");
        // print(test);
    }
}