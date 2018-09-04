### 二叉树的层次遍历，要求打印层数
- 使用队列迭代+每层尾节点  
  1. 使用队列来先进先出，然后有两个变量进行层数控制，一个是当前层的尾节点，一个是下一层的尾节点。  
  1. 当遍历当前层的节点时，将下一层的左右节点入队，更新下一层的尾节点。  
  1. 当遍历到当前层的末尾时（由当前层的尾节点指出），更新当前层的尾节点，更新层数，然后开始下一层的迭代。
```java
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
```
- 使用队列迭代+每层节点数  
  1. 使用队列来先进先出，然后有两个变量进行层数控制，一个是当前层的节点数，一个是下一层的节点数。  
  1. 当遍历当前层的节点时，将当前层的节点数减一，然后将下一层的左右节点入队，将下一层的节点数加一。  
  1. 当遍历到当前层的末尾时（由当前层的节点数为0来判断），更新当前层的节点数为下一层的节点数，将下一层的节点数置为0，更新层数，然后开始下一层的迭代。
```java
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
```
- 使用层数递归+二叉树高度
  1. 这里要先求树的高度，使用递归，最大高度为根节点的左右子树的较大值+1，+1是指当前层的高度。
  1. 对于每个层数，使用递归去深度遍历。当层数为1时，打印；否则以层数减一继续递归。
  1. 此方法的复杂度较大。
```java
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
```