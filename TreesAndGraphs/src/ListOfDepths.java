import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by rsr37 on 1/13/2018.
 */
public class ListOfDepths {
    static void createLists(TNode root, ArrayList<LinkedList<TNode>> lists, int level){
        if(root == null)
            return;
        LinkedList<TNode> list = null;
        if(lists.size() == level) // level not included in the list
        {
            list = new LinkedList<TNode>();
            lists.add(list);
        }
        else
            list = lists.get(level);
        list.add(root);
        createLists(root.left,lists,level+1);
        createLists(root.right,lists,level+1);
    }
    static ArrayList<LinkedList<TNode>> createListofDepths(TNode root){
        ArrayList<LinkedList<TNode>> lists = new ArrayList<LinkedList<TNode>>();
        createLists(root,lists,0);
        return lists;
    }
    public static void printLists(ArrayList<LinkedList<TNode>> lists){
        int depth = 0;
        for(LinkedList<TNode> list: lists){
            Iterator<TNode> i = list.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((TNode)i.next()).data);
            }
            System.out.println();
            depth++;
        }
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
        ArrayList<LinkedList<TNode>> lists = createListofDepths(tree.getRoot());
        printLists(lists);

    }
}
