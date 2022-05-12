public class QuickSelect {
    static final int SIZE = (int)1e1;
    static final int RANGE = (int)1e2;

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

    // quick select
    static int quickSelect(int arr[], int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int p = partition(arr, left, right);
        if (k <= p) {
            return quickSelect(arr, left, p, k);
        }
        return quickSelect(arr, p + 1, right, k);
    }

    // Hoare partition
    // Refer to QuickSort solution for more information
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
        int k = 3;
        System.out.println("Original array");
        print(test);
        int res = quickSelect(test, 0, test.length - 1, k - 1);
        System.out.printf("%d-th smallest element is: %d\n", k, res);
    }
}