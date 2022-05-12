public class CountingSort {
    public static void main(String[] args) {
        int[] test = generate(1000000, 1000000);
        long t1 = System.currentTimeMillis();
        sort(test, 1000000);
        long t2 = System.currentTimeMillis();
        System.out.println("Distribution sort: " + (t2 - t1));

        long t3 = System.currentTimeMillis();
        java.util.Arrays.sort(test);
        long t4 = System.currentTimeMillis();
        System.out.println("Java sort: " + (t4 - t3));
    }

    static int[] generate(int size, int max) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = (int)(Math.random() * max + 1);
        }
        return res;
    }

    static int[] sort(int[] arr, int max) {
        int[] freq = new int[max + 1];
        int[] res = new int[arr.length];

        // freq counting
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        // update to cumulative freq
        for (int i = 1; i <= max; i++) {
            freq[i] = freq[i-1] + freq[i];
        }

        // distribution step
        for (int i = arr.length - 1; i >= 0; i--) {
            res[freq[arr[i]] - 1] = arr[i];
            freq[arr[i]]--;
        }

        return res;
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}