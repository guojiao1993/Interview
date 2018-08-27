package bytedance;

/**
 * @author Alan
 */
public class CompleteBinaryTreeJudge {
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
}

class BTNode {
    BTNode lchild;
    BTNode rchild;
}
