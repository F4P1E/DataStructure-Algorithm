public class Permutation {
    public static void generate(int k, String[] arr, int[] location) {
        if (k == arr.length) {
            display(arr, location);
            return;
        }
        for (int i = 0; i < location.length; i++) {
            boolean used = false;
            for (int j = 0; j < k; j++) {
                if (location[j] == i) {
                    used = true;
                    break;
                }
            }
            if (!used) {
                location[k] = i;
                generate(k + 1, arr, location);
            }
        }
        location[k] = -1;
    }

    public static void display(String[] arr, int[] location) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < location.length; i++) {
            sb.append(arr[location[i]] + " ");
        }
        System.out.println("A permutation: " + sb);
    }

    public static void main(String[] args) {
        generate(0, new String[]{"A", "B", "C", "D"}, new int[]{-1, -1, -1, -1});
    }
}