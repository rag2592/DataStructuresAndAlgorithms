/**
 * Created by rsr37 on 1/9/2018.
 */
// A Java program for in-place conversion of Binary Tree to DLL

// A binary tree node has data, left pointers and right pointers
class Node1
{
    int data;
    Node1 left, right;

    public Node1(int data)
    {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreetoDList
{
    Node1 root;
    Node1 head;
    static Node1 prev = null;
    void BinaryTree2DoubleLinkedList(Node1 root)
    {
        if (root == null)
            return;

        BinaryTree2DoubleLinkedList(root.left);
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BinaryTree2DoubleLinkedList(root.right);
    }
    void printList(Node1 node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args)
    {
        // Let us create the tree as shown in above diagram
        BinaryTreetoDList tree = new BinaryTreetoDList();
        tree.root = new Node1(10);
        tree.root.left = new Node1(12);
        tree.root.right = new Node1(15);
        tree.root.left.left = new Node1(25);
        tree.root.left.right = new Node1(30);
        tree.root.right.left = new Node1(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }
}