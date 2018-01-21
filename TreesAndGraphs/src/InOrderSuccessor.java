/**
 * Created by rsr37 on 1/13/2018.
 */
public class InOrderSuccessor {
    static TNode findNextInOrder(TNode root, TNode target){
        if(root == null)
            return null;
        if(root.data <= target.data)
            return findNextInOrder(root.right,target);
        else{
            TNode left = findNextInOrder(root.left,target);
            return (left != null)? left:root;
        }
    }

    static TNode findPrevInOrder(TNode root, TNode target){
        if(root == null)
            return null;
        if(root.data >= target.data)
            return findPrevInOrder(root.left, target);
        else{
            TNode right = findPrevInOrder(root.right,target);
            return (right!=null)? right:root;
        }
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

        inOrder(tree.getRoot());
        TNode node = tree.getRoot().left.left;
        TNode result = findNextInOrder(tree.getRoot(),node);
        if(result != null && node!= null)
            System.out.println("The inorder successor of "+ node.data + " node is:"+ result.data);
        else
            System.out.println("No Inorder successor.!");

        result = findPrevInOrder(tree.getRoot().right.left,node);
        if(result != null && node!= null)
            System.out.println("The inorder successor of "+ node.data + " node is:"+ result.data);
        else
            System.out.println("No Inorder predecessor.!");
    }
}
