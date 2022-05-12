public class SelectionSort {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // find the smallest
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            // display
            display(arr);
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