public class P1FastExp {
    public static void main(String[] args) {
        System.out.printf("Raising %d to the %d gives us : %d\n", 2, 0, fastExp(2, 0));  // expected 1
        System.out.printf("Raising %d to the %d gives us : %d\n", 2, 8, fastExp(2, 8));  // expected 256
        System.out.printf("Raising %d to the %d gives us : %d\n", 2, 10, fastExp(2, 10));  // expected 1024
        System.out.printf("Raising %d to the %d gives us : %d\n", 2, 30, fastExp(2, 30));  // expected 1,073,741,824
    }

    static int fastExp(int a, int n) {
        // base case
        if (n == 0) {
            return 1;
        }
        int result = fastExp(a, n / 2);
        if (n % 2 == 0) {
            return result * result;
        }
        return result * result * a;
    }
}
