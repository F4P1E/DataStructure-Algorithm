public class BinaryTree {
    Node root;
    int size;
    // the two variable belows are used in determining
    // if a binary tree is a BST
    int prev;
    boolean isBST;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public void insert(int v) {
        int step = 1;
        if (root == null) {
            size++;
            root = new Node(v);
            System.out.printf("Steps: %d\n", step);
            return;
        }
        Node parent, current;
        parent = null;
        current = root;
        while (current != null) {
            step++;
            if (current.value == v) {
                return;
            }
            if (current.value > v) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        if (parent.value < v) {
            parent.right = new Node(v);
        } else {
            parent.left = new Node(v);
        }
        System.out.printf("Steps: %d\n", step);
        size++;
    }

    public void insertRandom(int v) {
        if (root == null) {
            size++;
            root = new Node(v);
            return;
        }
        Node parent, current;
        parent = null;
        current = root;
        while (current != null) {
            if (current.value == v) {
                return;
            }
            if (Math.random() > 0.5) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        if (parent.left == null) {
            parent.left = new Node(v);
        } else {
            parent.right = new Node(v);
        }
        size++;
    }

    public void preOrder() {
        System.out.println();
        preOrderRecursion(root);
        System.out.println();
    }

    private void preOrderRecursion(Node n) {
        if (n != null) {
            System.out.printf(" %d ", n.value);
            preOrderRecursion(n.left);
            preOrderRecursion(n.right);
        }
    }

    public void postOrder() {
        System.out.println();
        postOrderRecursion(root);
        System.out.println();
    }

    private void postOrderRecursion(Node n) {
        if (n != null) {
            postOrderRecursion(n.left);
            postOrderRecursion(n.right);
            System.out.printf(" %d ", n.value);
        }
    }

    public void inOrder() {
        System.out.println();
        inOrderRecursion(root);
        System.out.println();
    }

    private void inOrderRecursion(Node n) {
        if (n != null) {
            inOrderRecursion(n.left);
            System.out.printf(" %d ", n.value);
            if (prev < n.value) {
                prev = n.value;
            } else {
                isBST = false;
            }
            inOrderRecursion(n.right);
        }
    }

    public boolean isBSTTree() {
        prev = Integer.MIN_VALUE;
        isBST = true;
        inOrder();
        return isBST;
    }

    public void breadthFirstOrder() {
        LinkedListQueue<Node> q = new LinkedListQueue<Node>();
        q.enQueue(root);
        System.out.println();
        while (!q.isEmpty()) {
            Node n = q.peekFront();
            q.deQqueue();
            System.out.printf(" %d ", n.value);
            if (n.left != null) {
                q.enQueue(n.left);
            }
            if (n.right != null) {
                q.enQueue(n.right);
            }
        }
        System.out.println();
    }

    public int height() {
        return heightRecursion(root);
    }

    private int heightRecursion(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursion(n.left), heightRecursion(n.right));
    }

    static class Node {
        int value;
        Node left, right;

        public Node(int v) {
            value = v;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);
        tree.insert(5);
        // tree.insertRandom(3);
        // tree.insertRandom(2);
        // tree.insertRandom(4);
        // tree.insertRandom(1);
        // tree.insertRandom(5);
        System.out.printf("Is BST: %b\n", tree.isBSTTree());
        tree.postOrder();
        // tree.inOrder();
        // tree.breadthFirstOrder();
    }
}