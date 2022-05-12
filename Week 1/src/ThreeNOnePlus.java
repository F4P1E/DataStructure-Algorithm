import java.util.Arrays;

public class ThreeNOnePlus {
    static int mostStep = 0;  // sub question 1
    static int numberWithMostStep = 1;  // sub question 1
    static int highestReached = 0;  // sub question 2

    static int[] cached = new int[101];  // 101 to store up to index 100

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            int step = steps(i);
            if (step > mostStep) {
                mostStep = step;
                numberWithMostStep = i;
            }
            if (i == step) {
                System.out.printf("%d  -  %d  ---OK--- \n", i, step);  // sub question 3
            } else {
                System.out.printf("%d  -  %d\n", i, step);
            }
        }
        System.out.printf("Highest number reached %d\n", highestReached);

        // initialization for cached array
        Arrays.fill(cached, -1);
        cached[1] = 0;
        for (int i = 1; i <= 100; i++) {
            int step = fasterSteps(i);
            System.out.printf("%d  -  %d\n", i, step);
        }
    }

    public static int steps(int N) {
        int step = 0;
        while (N != 1) {
            if (highestReached < N) {
                highestReached = N;
            }
            step++;
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                N = N * 3 + 1;
            }
        }
        return step;
    }

    // sub question 4
    public static int fasterSteps(int N) {
        // Use cached if exists
        if (N < cached.length && cached[N] != -1) {
            return cached[N];
        }
        int result;
        if (N % 2 == 0) {
            result = fasterSteps(N / 2) + 1;
        } else {
            result = fasterSteps(N * 3 + 1) + 1;
        }
        // cache, if possible
        if (N < cached.length) {
            cached[N] = result;
        }
        return result;
    }
}