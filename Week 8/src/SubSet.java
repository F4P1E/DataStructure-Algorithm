public class SubSet {
    public static void generate(int k, String[] arr, boolean[] selected) {
        if (k == arr.length) {
            display(arr, selected);
            return;
        }
        selected[k] = false;
        generate(k + 1, arr, selected);
        selected[k] = true;
        generate(k + 1, arr, selected);
    }

    public static void display(String[] arr, boolean[] selected) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (selected[i]) {
                sb.append(arr[i] + " ");
            }
        }
        System.out.println("A subset: " + sb);
    }

    public static void main(String[] args) {
        generate(0, new String[]{"A", "B", "C", "D"}, new boolean[]{false, false, false, false});
    }
}