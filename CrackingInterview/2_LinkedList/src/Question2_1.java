import java.util.HashSet;

/**
 * Created by rsr37 on 7/9/2017.
 */

// Removing the duplicate elements in a list.
class Node{
    Node next = null;
    int data;
    public Node(int d) {
        data = d;
    }
    public void add(int d)
    {
        Node end = new Node(d);
        Node n = this;
        while(n.next!=null)
            n = n.next;
        n.next = end;
    }
    public void printList()
    {
        Node temp = this;
        while(temp != null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Question2_1 {
    public static void removeDupes(Node head)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        Node prev = null;
        while(head != null)
        {
            if(set.contains(head.data))
                prev.next = head.next;
            else
            {
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }
    public static void main(String[] args){
        Node head = new Node(10);
        head.add(11);
        head.add(10);
        head.add(12);
        head.add(13);
        head.add(11);
        head.printList();
        removeDupes(head);
        head.printList();;

    }
}
