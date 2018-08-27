### 如何按层级打印二叉树？要求输出层号
1. 利用队列来广度遍历二叉树。
1. 设置两个尾指针，一个是当前层的尾指针，另一个是下一层的尾指针，每插入一个新值都要更新下一层的尾指针。
1. 设置两个层号，一个是当前层的层号，另一个是下一层的层号，在打印当前层的层号时更新当前层的层号，要在遍历到当前层的末尾时更新下一层的层号。
```java
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
```

### 如何判断一棵树是否是完全二叉树？
完全二叉树需要判断两个条件：
1. 如果一个节点没有左子树，那么它不能有右子树。
1. 如果一个节点没有左子树或没有右子树，那么和它同级的后续节点均不能有孩子节点。

编程记忆：
1. 使用队列来层次遍历。
1. 使用两个标志位，其中一个用来判断上述的两个条件，另一个记录结果。
```java
int judgeCompleteBinaryTree(BTNode b) {
    //定义一个队列，用于层次遍历
    BTNode[] qu = new BTNode[50];
    BTNode p;
    //队头、队尾指针
    int front = 0, rear = 0;
    int cm = 1;
    int bj = 1;
    if (b != null) {
        rear++;
        //进队
        qu[rear] = b;
        while (front != rear) {
            front++;
            p = qu[front];
            //p节点没有左孩子
            if (p.lchild == null) {
                bj = 0;
                //没有左孩子但有右孩子
                if (p.rchild != null) {
                    //则不是完全二叉树
                    cm = 0;
                }
                // p节点有左子树
            } else {
                //迄今为止，所有节点均有左右孩子
                if (bj == 1) {
                    rear++; //左孩子进队
                    qu[rear] = b.lchild;
                    //*p有左孩子但没有右孩子
                    if (p.rchild == null) {
                        bj = 0;
                    } else {
                        rear++; //右孩子进队
                        qu[rear] = p.rchild;
                    }
                    //bj=0:迄今为止，已有节点缺孩子
                } else {
                    //而此时*p节点有左孩子，违反（2）
                    cm = 0;
                }
            }
        }
        return cm;
    }
    //把空树当成特殊的完全二叉树
    return 1;
}
```