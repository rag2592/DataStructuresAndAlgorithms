/**
 * Created by rsr37 on 1/9/2018.
 */
import java.util.*;
class TNode{
    int data;
    TNode left, right;
    TNode(int d)
    {
        data = d;
        right = left = null;
    }
}

class QueuePack{
    int lvl;
    TNode tnode;
    public QueuePack(int lvl, TNode tnode){
        this.lvl = lvl;
        this.tnode = tnode;
    }
}
class BTree{

    TNode root;
    BTree(int d){
        root = new TNode(d);
    }
    void insert(int d){
        TNode temp = root;
        Queue<TNode> q = new LinkedList<TNode>();
        q.add(temp);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();

            if(temp.left == null){
                temp.left = new TNode(d);
                break;
            }
            else
                q.add(temp.left);
            if(temp.right == null){
                temp.right = new TNode(d);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    boolean isBST(){
        return isBSTCheck(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }



    boolean isBSTCheck(TNode node, int min, int max){
        if(node == null)
            return true;
        if(node.data < min || node.data > max)
            return false;
        // Allowing only distinct values
        return (isBSTCheck(node.left, min, node.data -1) && isBSTCheck(node.right, node.data+1, max));
    }
    void inOrder(TNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }
    TNode getRoot(){
        return root;
    }
    int getDepth(TNode root){
        if(root == null)
            return 0;
        else{
            int lDepth = getDepth(root.left);
            int rDepth = getDepth(root.right);
            return lDepth > rDepth? lDepth+1 : rDepth+1;
        }
    }
    int depth(){
        return getDepth(root);
    }
    void printLevels(){
        Queue<TNode> q = new LinkedList<TNode>();
        q.add(root);
        while(!q.isEmpty()){
            // poll() removes the present head
            TNode temp = q.poll();
            System.out.print(temp.data+ " ");

            // add the left child on to the queue for the next level printing
            if(temp.left != null )
                q.add(temp.left);
            // add the right child for the next level printing
            if(temp.right != null)
                q.add(temp.right);
        }
    }
    public void topView(){
        topView(root);
    }
    private void topView(TNode root) {
        if (root == null)
            return;
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<QueuePack> q = new LinkedList<QueuePack>();
        q.add(new QueuePack(0,root));
        //BFS or level order traversal
        while(!q.isEmpty()){
            QueuePack qitem = q.remove();
            int lvl = qitem.lvl;
            TNode tnode = qitem.tnode;
            if(!set.contains(lvl)){
                set.add(lvl);
                System.out.print(tnode.data + " ");
            }
            if(tnode.left != null){
                q.add(new QueuePack(lvl-1, tnode.left));
                if(tnode.right != null)
                    q.add(new QueuePack(lvl+1, tnode.right));
            }
        }
    }
}
public class BinaryTree {
    public static void main(String[] args){
        BTree btree = new BTree(50);
        btree.insert(30);
        btree.insert(70);
        btree.insert(40);

        btree.inOrder(btree.getRoot());
        if(btree.isBST())
            System.out.println("is BST");
        else
            System.out.println("Not BST");

        System.out.println("The Depth of the tree is:"+ btree.depth());
        System.out.println("Printing in levels:");
        btree.printLevels();
        System.out.println("Top View:");
        btree.topView();

    }
}
