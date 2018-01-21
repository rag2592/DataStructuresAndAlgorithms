/**
 * Created by rsr37 on 1/13/2018.
 */
public class BalancedBinaryTree {

    static int getHeight(TNode root){
        if(root == null) return 0;
        return (1+Math.max(getHeight(root.left),getHeight(root.right)));
    }
    public static boolean isBlanaced(TNode root){
        if(root == null)
            return true;
        int height_diff = getHeight(root.left) - getHeight(root.right);
        if(Math.abs(height_diff) > 1)
            return false;
        else
            return (isBlanaced(root.left)&& isBlanaced(root.right));
    }
    public static void main(String[] args){
        BTree tree = new BTree(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(16);
        tree.insert(20);
        if(isBlanaced(tree.getRoot()))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");

    }
}
