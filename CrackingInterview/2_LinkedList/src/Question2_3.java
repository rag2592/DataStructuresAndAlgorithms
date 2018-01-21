import java.util.Scanner;

/**
 * Created by rsr37 on 7/9/2017.
 */
// Delete some node in the middle given that node
public class Question2_3 {
    public static boolean deleteMiddle(Node n)
    {
        if(n == null || n.next == null)
            return false;
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
    public static void main(String[] args){
        Node head = new Node(10);
        head.add(11);
        head.add(10);
        head.add(12);
        head.add(13);
        head.add(11);
        head.printList();
        System.out.println("Enter the value for k:");
        Node temp = head;
        int i =0;
        while( i < 3) {
            temp = temp.next;
            i++;
        }
        boolean result = deleteMiddle(temp);
        if(result)
            head.printList();
        else
            System.out.println("Cannot delete");

    }
}
