/**
 * Created by rsr37 on 1/9/2018.
 */

import java.io.*;
import java.util.*;
public class BST {
    class Node{
        int data;
        Node left, right;

        public Node(int d){
            data = d;
            left = right = null;
        }
    }

    Node root;
    BST(){
        root = null;
    }
    void insert(int value){
        root = insertNode(root, value);
    }
    Node insertNode(Node root, int value){
        if(root == null)
        {
            root = new Node(value);
            return root;
        }
        if(value < root.data)
            root.left = insertNode(root.left,value);
        else if (value > root.data)
            root.right = insertNode(root.right,value);
        return root;
    }

    boolean isBST(){
        return isBSTCheck(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    boolean isBSTCheck(Node node, int min, int max){
        if(node == null)
            return true;
        if(node.data < min || node.data > max)
            return false;
        // Allowing only distinct values
        return (isBSTCheck(node.left, min, node.data -1) && isBSTCheck(node.right, node.data+1, max));
    }
    void printInOrder(){
        inOrder(root);
    }
    void inOrder(Node root){
        if(root == null)
            return;
        else{
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    Node findNode(Node root, int target){
        if(root == null)
            return null;
        if(root.data > target)
            return findNode(root.left,target);
        else if(root.data < target)
            return findNode(root.right,target);
        else
            return root;
    }
    Node findNextG(Node root, Node target){
        if(root == null)
            return null;
        if(root.data <= target.data)
            return findNextG(root.right,target);
        else{
            Node left = findNextG(root.left,target);
            return (left != null)? left:root;
        }
    }
    Node findNextL(Node root, Node target){
        if(root == null)
            return null;
        if(root.data >= target.data)
            return findNextL(root.left,target);
        else{
            Node right = findNextL(root.right,target);
            return (right != null)? right:root;
        }
    }
    Node findNextGreatest(int target){
        Node tNode = findNode(root,target);
        return findNextG(root,tNode);
    }

    Node findNextLowest(int target){
        Node tNode = findNode(root,target);
        return findNextL(root,tNode);
    }
    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.printInOrder();

        if(tree.isBST())
            System.out.println("The tree is a BST");
        else
            System.out.println("The tree is not a BST");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the target for next greatest:");
        int target = in.nextInt();
        Node result = tree.findNextGreatest(target);
        if(result != null)
            System.out.println("The next Greatest Node found and its value is:"+ result.data);
        else
            System.out.println("Not Found.!");
        System.out.println("Enter the target for next lowest:");
        target = in.nextInt();
        result = tree.findNextLowest(target);
        if(result != null)
            System.out.println("The next lowest Node found and its value is:"+ result.data);
        else
            System.out.println("Not Found.!");
       }
}
