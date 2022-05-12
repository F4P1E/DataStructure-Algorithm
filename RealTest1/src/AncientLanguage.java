public class AncientLanguage {
    WordNode head;

    public AncientLanguage() {
        head = null;
    }

    public void addFirst(String word) {
        head = new WordNode(word);
    }

    public boolean addAfter(String current, String after) {
        WordNode node = head;
        while (node != null) {
            if (node.word.equals(current)) {
                WordNode newNode = new WordNode(after);
                newNode.next = node.next;
                node.next = newNode;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public AncientLanguage reverse() {
        AncientLanguage result = new AncientLanguage();
        WordNode resultParent, resultCurrent;
        WordNode current;
        resultParent = null;
        current = head;
        while (current != null) {
            resultCurrent = new WordNode(current.word);
            // point back
            resultCurrent.next = resultParent;
            // update new result parent
            resultParent = resultCurrent;

            // advance the current object
            current = current.next;
        }
        result.head = resultParent;
        return result;
    }

    // helper method for testing
    private void printLanguage() {
        WordNode node = head;
        System.out.println("Starting");
        while (node != null) {
            System.out.println(node.word);
            node = node.next;
        }
        System.out.println("Finish");
    }

    static class WordNode {
        String word;
        WordNode next;

        public WordNode(String w) {
            word = w;
            next = null;
        }
    }

    public static void main(String[] args) {
        AncientLanguage l1 = new AncientLanguage();
        l1.addFirst("hello");
        l1.addAfter("hello", "world");
        l1.printLanguage();
        l1.addAfter("hello", "RMIT");
        l1.printLanguage();

        AncientLanguage l2 = l1.reverse();
        l2.printLanguage();
    }
}