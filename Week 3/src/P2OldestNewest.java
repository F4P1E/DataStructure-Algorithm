public class P2OldestNewest {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        searchOldNew(test1);  // expected: oldest = 0 and newest = 6

        int[] test2 = {113, 115, 117, 118, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108};
        searchOldNew(test2);  // expected: oldest = 4 and newest = 3

        int[] test3 = {20, 3, 6, 8, 10, 14, 17};
        searchOldNew(test3);  // expected: oldest = 1 and newest = 0

        int[] test4 = {10, 12, 16, 18, 20, 8};
        searchOldNew(test4);  // expected: oldest = 5 and newest = 4
    }

    // Display the indices of oldest and newest elements
    public static void searchOldNew(int[] arr) {
        int left, right;
        left = 0;
        right = arr.length - 1;
        while (left < right && arr[left] > arr[right]) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                System.out.printf("Oldest index = %d and Newest index = %d\n", mid + 1, mid);
                return;
            }
            if (arr[left] < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.printf("Oldest index = %d and Newest index = %d\n", left, right);
    }
}