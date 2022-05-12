public class LinearProbing {
    public static void main(String[] args) {
        System.out.println(put("ABC"));
        System.out.println(put("BAC"));
        System.out.println(put("CAB"));

        System.out.println(get("ABC"));
        System.out.println(get("BAC"));
        System.out.println(get("ACB"));
    }

    static int N = 13;
    static String[] table = new String[N];

    static int hashCharacter(char c) {
        return c - 'A';
    }

    static int hashString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += hashCharacter(s.charAt(i));
        }
        return res % N;
    }

    static boolean put(String s) {
        int hash = hashString(s);
        while (table[hash] != null) {
            if (table[hash].equals(s)) {
                return false;
            }
            hash = (hash + 1) % N;
        }
        table[hash] = s;
        return true;
    }

    static boolean get(String s) {
        int hash = hashString(s);
        while (table[hash] != null) {
            if (table[hash].equals(s)) {
                return true;
            }
            hash = (hash + 1) % N;
        }
        return false;
    }
}