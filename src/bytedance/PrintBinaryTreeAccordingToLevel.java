package bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alan
 */
public class PrintBinaryTreeAccordingToLevel {
    public static void printTree(TreeNode root) {
        TreeNode last;
        TreeNode nlast;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        last = root;
        nlast = root;
        int thisLevel = 1;
        int nextLevel = 2;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (thisLevel != nextLevel) {
                System.out.print(thisLevel + "：");
                thisLevel = nextLevel;
            }
            System.out.print(t.data + " ");
            if (t.left != null) {
                queue.add(t.left);
                nlast = t.left;
            }
            if (t.right != null) {
                queue.add(t.right);
                nlast = t.right;
            }
            // 如果当前输出结点是最右结点，那么换行
            if (last == t) {
                System.out.println();
                last = nlast;
                nextLevel++;
            }
        }
    }

    public static void main(String[] args) {
        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        printTree(root);
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
