public class RMITStudentCollection {
    public static void main(String[] args) {
        RMITStudentCollection col = new RMITStudentCollection();
        col.put(new RMITStudent("S123", "IT", "Tom", 3.6));
        col.put(new RMITStudent("S456", "EE", "Jerry", 4.0));
        col.put(new RMITStudent("S231", "BZ", "Alice", 2.8));
        System.out.println(col.get("S231").fullName);
    }

    static int N = 13;
    RMITStudentNode[] table = new RMITStudentNode[N];

    int hashCharacter(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0' + 26;
        }
        return c - 'A';
    }

    int hashString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += hashCharacter(s.charAt(i));
        }
        return res % N;
    }

    boolean put(RMITStudent s) {
        int hash = hashString(s.studentId);
        if (table[hash] == null) {
            table[hash] = new RMITStudentNode(s);
            return true;
        }
        RMITStudentNode parent = null;
        RMITStudentNode current = table[hash];
        while (current != null) {
            if (current.data.studentId.equals(s)) {
                return false;
            }
            parent = current;
            current = current.next;
        }
        parent.next = new RMITStudentNode(s);
        return true;
    }

    RMITStudent get(String sId) {
        int hash = hashString(sId);
        if (table[hash] == null) {
            return null;
        }
        RMITStudentNode current = table[hash];
        while (current != null) {
            if (current.data.studentId.equals(sId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    static class RMITStudentNode {
        RMITStudent data;
        RMITStudentNode next;

        public RMITStudentNode(RMITStudent s) {
            data = s;
            next = null;
        }
    }

    static class RMITStudent {
        String studentId;
        String major;
        String fullName;
        double GPA;

        public RMITStudent(String id, String m, String name, double mark) {
            studentId = id;
            major = m;
            fullName = name;
            GPA = mark;
        }
    }
}