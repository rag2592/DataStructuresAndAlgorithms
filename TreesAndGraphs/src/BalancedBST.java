/**
 * Created by rsr37 on 1/13/2018.
 */
public class BalancedBST {
    static boolean isBSTCheck(TNode root, int min, int max ){
        if(root == null)
            return true;
        if(root.data < min || root.data > max)
            return false;
        return(isBSTCheck(root.left,min, root.data - 1  ) && isBSTCheck(root.right, root.data+1, max)); // assuming distinct elements on the tree

        }
    static boolean isBST(TNode root){
        return isBSTCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    static void inOrder(TNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args){
        BTree tree = new BTree(10);
        tree.insert(8);
        tree.insert(12);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(14);
        if(isBST(tree.getRoot()))
            System.out.println("Is a BST.!");
        else
            System.out.println("Is Not a BST");
        inOrder(tree.getRoot());
    }
}
