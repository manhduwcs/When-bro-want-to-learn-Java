package org.example.dsa.sortings;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class MyTree {
    public static TreeNode arrayToNode(int[] arr, int val) {
        if (val >= arr.length) return null;
        TreeNode node = new TreeNode(arr[val]);
        node.left = arrayToNode(arr, (2 * val) + 1);
        node.right = arrayToNode(arr, (2 * val) + 2);
        return node;
    }

    public static void printNode(TreeNode node) {
        if (node != null) {
            printNode(node.left);
            System.out.println(node.val + " ");
            printNode(node.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 3, 4, 15, 6, 7};
        TreeNode node = arrayToNode(arr, 0);
        printNode(node);
    }
}
