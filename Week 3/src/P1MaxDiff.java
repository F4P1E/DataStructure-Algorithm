public class P1MaxDiff {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 6, 9, 10, 20};
        int[] res1 = searchLowHigh(test1);
        System.out.printf("lowDay = %d, highDay = %d, difference = %d\n", res1[0], res1[1], test1[res1[1]] - test1[res1[0]]);
        // expected: lowDay = 0, highDay = 5, difference = 19

        int[] test2 = new int[]{20, 15, 12, 10, 8, 7};
        int[] res2 = searchLowHigh(test2);
        System.out.printf("lowDay = %d, highDay = %d, difference = %d\n", res2[0], res2[1], test2[res2[1]] - test2[res2[0]]);
        // expected: lowDay = 0, highDay = 0, difference = 0

        int[] test3 = new int[]{14, 12, 70, 15, 95, 65, 22, 99, 8};
        int[] res3 = searchLowHigh(test3);
        System.out.printf("lowDay = %d, highDay = %d, difference = %d\n", res3[0], res3[1], test3[res3[1]] - test3[res3[0]]);
        // expected: lowDay = 1, highDay = 7, difference = 87
    }

    // Return the indices of lowDay and highDay in the index 0 and 1 respectively
    public static int[] searchLowHigh(int[] array) {
        int[] res = new int[2];
        int lowDay, highDay, min, minIdx, maxDiff;
        lowDay = highDay = maxDiff = minIdx = 0;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] - array[minIdx] > maxDiff) {
                lowDay = minIdx;
                highDay = i;
                maxDiff = array[i] - array[minIdx];
            }
            if (array[i] < min) {
                min = array[i];
                minIdx = i;
            }
        }
        res[0] = lowDay;
        res[1] = highDay;
        return res;
    }
}