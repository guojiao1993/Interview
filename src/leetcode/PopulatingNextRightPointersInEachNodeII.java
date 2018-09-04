package leetcode;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        connect(root);
        print(root);
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.push(root);
        int thisLevelNum = 1;
        int nextLevelNum = 0;
        while (!queue.isEmpty()) {
            TreeLinkNode node1 = queue.pop();
            thisLevelNum--;
            if (node1.left != null) {
                queue.add(node1.left);
                nextLevelNum++;
            }
            if (node1.right != null) {
                queue.add(node1.right);
                nextLevelNum++;
            }
            if (thisLevelNum == 0) {
                node1.next = null;
                thisLevelNum = nextLevelNum;
                nextLevelNum = 0;
            } else {
                TreeLinkNode node2 = queue.peek();
                node1.next = node2;
            }
        }
    }

    public static void print(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            System.out.print(node.val + " ");
            if(node.next == null) {
                System.out.print("# ");
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}