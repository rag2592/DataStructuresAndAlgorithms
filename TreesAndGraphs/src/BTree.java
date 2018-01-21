import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rsr37 on 1/13/2018.
 */
public class BTree{

    private TNode root;
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
}
