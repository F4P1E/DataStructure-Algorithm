public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false; // used to check if there is anny swap
            for (int j = 0; j < arr.length - 1 - i; j++) { //leave the sorted
                if (arr[j] > arr[j + 1]) {
                    // swap between 2 element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; //there is swap
                }
            }
            display(arr);
            // array in sorted order
            if (!swapped) {
                return;
            }
        }
    }

    private static void display(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j] + " ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        System.out.println("First test");
        sort(new int[]{6, 2, 7, 9, 1});
        System.out.println("Second test");
        sort(new int[]{1, 3, 5, 7, 9});
        System.out.println("Third test");
        sort(new int[]{10, 8, 6, 4, 2});
    }

}