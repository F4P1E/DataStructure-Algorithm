public class P2MissingNumber {
    public static void main(String[] args) {
        System.out.printf("Missing value : %d\n", missingValue(new int[]{0}));  // expected 1
        System.out.printf("Missing value : %d\n", missingValue(new int[]{1}));  // expected 0
        System.out.printf("Missing value : %d\n", missingValue(new int[]{0, 1, 2, 3, 4, 6, 7}));  // expected 5
        System.out.printf("Missing value : %d\n", missingValue(new int[]{0, 1, 2, 3, 4, 5, 7, 8, 9, 10}));  // expected 6
    }

    static int missingValue(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {  // the range contains at least 2 elements
            int middle = (left + right) / 2;
            if (a[middle] == middle) {  // the missing value cannot be middle or less
                left = middle + 1;
            } else {
                right = middle;  // be careful: middle is a possible missing value
            }
        }
        // now, left = right
        if (a[left] != left) {
            return left;
        }
        return left + 1;
    }
}