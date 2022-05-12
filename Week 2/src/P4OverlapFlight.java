import java.util.Arrays;

public class P4OverlapFlight {
    public static void main(String[] args) {
    /*
    1   ->    2
    2   ->    4
    4   ->    7
    8   ->    10
    */
        System.out.printf("Gates required : %d\n", maxOverlap(new int[]{1, 2, 4, 8},
                new int[]{2, 4, 7, 10}));  // expected 1
    /*
    1   ->    12
    2   ->    11
    3   ->    10
    5   ->    6
    */
        System.out.printf("Gates required : %d\n", maxOverlap(new int[]{1, 2, 3, 5},
                new int[]{12, 11, 10, 6}));  // expected 4

    /*
    1   ->    11
    2   ->    8
    5   ->    12
    9   ->    10
    */
        System.out.printf("Gates required : %d\n", maxOverlap(new int[]{1, 2, 5, 9},
                new int[]{11, 8, 12, 10}));  // expected 3

    /*
    1   ->    4
    2   ->    7
    6   ->    9
    8   ->    12
    */
        System.out.printf("Gates required : %d\n", maxOverlap(new int[]{1, 2, 6, 8},
                new int[]{4, 7, 9, 12}));  // expected 2
    }

    static int maxOverlap(int[] a, int[] d) {
        Arrays.sort(d);  // a has been sorted already
        int currentGate = 0;
        int maxGate = 0;
        int nextA = 0;  // point to the next arrival event
        int nextD = 0;  // point to the next departure event
        while (nextA < a.length) {  // the last arrival event must occur before the last departure event
            if (a[nextA] < d[nextD]) {  // encounter an arrival event
                currentGate++;
                nextA++;
            } else if (a[nextA] > d[nextD]) {  // encounter a departure event
                currentGate--;
                nextD++;
            } else {  // 2 events happen at the same time
                nextA++;
                nextD++;
            }
            if (maxGate < currentGate) {
                maxGate = currentGate;
            }
        }
        return maxGate;
    }
}