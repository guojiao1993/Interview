package maoyan;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBTInLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);
        printTreeByTailNode(root);
        printTreeByNodeNum(root);
        printTreeByRecursion(root);
    }

    public static void printTreeByTailNode(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode thisLevelTailNode = root;
        TreeNode nextLevelTailNode = root;
        int thisLevelNo = 1;
        int nextLevelNo = 2;
        while (!queue.isEmpty()) {
            TreeNode t = queue.peek();
            if (thisLevelNo != nextLevelNo) {
                System.out.print(thisLevelNo + "：");
                thisLevelNo = nextLevelNo;
            }
            System.out.print(queue.poll().data + " ");
            if (t.left != null) {
                queue.add(t.left);
                nextLevelTailNode = t.left;
            }
            if (t.right != null) {
                queue.add(t.right);
                nextLevelTailNode = t.right;
            }
            // 如果当前输出结点是当前层的最右节点，那么换行
            if (thisLevelTailNode == t) {
                System.out.println();
                thisLevelTailNode = nextLevelTailNode;
                nextLevelNo++;
            }
        }
    }

    public static void printTreeByNodeNum(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int thisLevelNodeNum = 1;
        int nextLevelNodeNum = 0;
        int thisLevelNo = 1;
        int nextLevelNo = 2;
        while (!queue.isEmpty()) {
            if (thisLevelNo != nextLevelNo) {
                System.out.print(thisLevelNo + "：");
                thisLevelNo = nextLevelNo;
            }
            TreeNode t = queue.poll();
            thisLevelNodeNum--;
            System.out.print(t.data + " ");
            if (t.left != null) {
                queue.add(t.left);
                nextLevelNodeNum++;
            }
            if (t.right != null) {
                queue.add(t.right);
                nextLevelNodeNum++;
            }
            // 如果当前输出结点是当前层的最右节点，那么换行
            if (thisLevelNodeNum == 0) {
                System.out.println();
                thisLevelNodeNum = nextLevelNodeNum;
                nextLevelNodeNum = 0;
                nextLevelNo++;
            }
        }
    }

    public static void printTreeByRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        int height = getTreeHeight(root);
        for (int i = 1; i <= height; i++) {
            System.out.print(i + "：");
            printTreeByRecursion2(root, i);
            System.out.println();
        }
    }

    public static void printTreeByRecursion2(TreeNode node, int levelNo) {
        if (node == null || levelNo < 1) {
            return;
        }
        if (levelNo == 1) {
            System.out.print(node.data + " ");
            return;
        }
        printTreeByRecursion2(node.left, levelNo - 1);
        printTreeByRecursion2(node.right, levelNo - 1);
    }

    public static int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        // +1是指本层高度
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }
}