public class Array2BalancedBST {
    static TreeNode root;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5};
        root = buildTree(arr, 0, arr.length - 1);
        // traverse this tree to check the heights
        displayHeights(root);
    }

    public static TreeNode buildTree(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode parent = new TreeNode(arr[mid]);
        parent.left = buildTree(arr, left, mid - 1);
        parent.right = buildTree(arr, mid + 1, right);
        return parent;
    }

    public static void displayHeights(TreeNode node) {
        if (node == null) {
            return;
        }
        int hl, hr;
        if (node.left == null) {
            hl = 0;
        } else {
            hl = node.left.height();
        }
        if (node.right == null) {
            hr = 0;
        } else {
            hr = node.right.height();
        }
        System.out.printf("The node %d has left height = %d and right height = %d\n", node.data, hl, hr);
        displayHeights(node.left);
        displayHeights(node.right);
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            left = right = null;
        }

        public int height() {
            return heightRecursive(this);
        }

        private int heightRecursive(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
        }

        @Override
        public String toString() {
            return "Node data: " + data;
        }
    }
}