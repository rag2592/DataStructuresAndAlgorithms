/**
 * Created by rsr37 on 7/16/2017.
 */

class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size =0;

    public TreeNode (int d){
        data = d;
        size = 1;
    }
    private void setLeftChild(TreeNode left){
        this.left = left;
        if(left!=null)
            left.parent = this;
    }

    private void setRightChild(TreeNode right)
    {
        this.right = right;
        if(right!=null)
            right.parent = this;
    }

    public void insertInOrder(int d)
    {
        if(d <= data){
            if(left == null)
                setLeftChild(new TreeNode(d));
            else
                left.insertInOrder(d);
        }
        else
        {
            if(right == null)
                setRightChild(new TreeNode(d));
            else
                right.insertInOrder(d);
        }
        size++;
    }
    public int getSize(){
        return size;
    }

    public boolean isBST(){
        if(left!=null)
        {
            if(data < left.data || !left.isBST())
                return false;
        }
        if(right!=null)
        {
            if(data >= right.data || !right.isBST())
                return false;
        }
        return true;
    }
    public int height(){
        int leftHeight = left!=null? left.height():0;
        int rightHeight = right!=null? right.height():0;
        return 1+ Math.max(leftHeight,rightHeight);
    }

    private static TreeNode createMinimalBST(int arr[], int start, int end){
        if(end < start)
            return null;
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeftChild(createMinimalBST(arr,start,mid-1));
        n.setRightChild(createMinimalBST(arr,mid+1, end));
        return n;
    }
    public static TreeNode createMinimalBST(int arr[])
    {
        return createMinimalBST(arr,0,arr.length-1);
    }
}
public class Question4_2 {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        TreeNode root = TreeNode.createMinimalBST(arr);
        System.out.println("Root :" + root.data);
        System.out.println("Created BST?:"+ root.isBST());
        System.out.println("height:" + root.height());
    }
}
