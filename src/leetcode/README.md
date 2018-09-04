### BinaryTreePostOrderTraversal
二叉树的后序遍历，要求非递归。  

算法思想是用两个栈，栈一按照先序遍历存放，栈二将每一个从栈一出栈的元素入栈，最后将栈二依次出栈打印即可。
```java
public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);
    while (!stack1.isEmpty()) {
        TreeNode node = stack1.pop();
        stack2.push(node);
        if (node.left != null) {
            stack1.push(node.left);
        }
        if (node.right != null) {
            stack1.push(node.right);
        }
    }
    while (!stack2.isEmpty()) {
        result.add(stack2.pop().val);
    }
    return result;
}
```