import java.util.Arrays;

public class P3PrintUnique {
    public static void main(String[] args) {
        printUnique(new int[]{1, 2, 3, 1, 2, 3});  // expected 1 2 3
        printUnique(new int[]{1, 1, 1, 1, 1, 1});  // expected 1
        printUnique(new int[]{1, 2, 3, 3, 2, 1});  // expected 1 2 3
        printUnique(new int[]{1, 1, 3, 3, 2, 4, 2, 4});  // expected 1 2 3 4
    }

    static void printUnique(int[] a) {
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        sb.append(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i-1]) {
                sb.append(" " + a[i]);
            }
        }
        System.out.println(sb);
    }
}