/**
 * Created by rsr37 on 1/13/2018.
 */

class BinaryTree{
    static TNode root;
    BinaryTree(){
        root = null;
    }
    TNode constructBST(int[] arr, int s, int e){
        if(s > e)
            return null;
        int mid = (s + e)/2;
        TNode node = new TNode(arr[mid]);
        node.left = constructBST(arr,s,mid-1);
        node.right = constructBST(arr, mid+1,e);
        return node;
    }
    TNode sortedArraytoBST(int[] arr){
        return constructBST(arr,0,arr.length-1);
    }

    void inOrder(TNode root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

}
public class SortedArrayToBST {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        TNode root = tree.sortedArraytoBST(arr);
        System.out.println("Pre-order traversal of constructed BST");
        tree.inOrder(root);
    }
}
