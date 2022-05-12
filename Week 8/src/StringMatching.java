public class StringMatching {
    public static int match(String str, String pattern) {
        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            int pos = 0;
            while (pos < pattern.length() && str.charAt(i + pos) == pattern.charAt(pos)) {
                pos++;
            }
            if (pos == pattern.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(match("Hello", "lo"));  // expected: 3
        System.out.println(match("Hello", "Hella"));  // expected: -1
        System.out.println(match("AAAAAAAAAAAAAB", "AB"));  // expected: 12
        System.out.println(match("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "Z"));  // expected: 25
        System.out.println(match("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "YZ"));  // expected: 24
        System.out.println(match("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "XZ"));  // expected: -1
    }
}