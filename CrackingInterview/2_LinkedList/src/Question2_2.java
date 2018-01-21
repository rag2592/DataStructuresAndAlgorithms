import java.util.Scanner;

/**
 * Created by rsr37 on 7/9/2017.
 */

// Printing nth to the last element in the linked list
public class Question2_2 {
    public static Node nthToLast(Node head, int k)
    {
        Node p1 = head, p2 = head;
        for(int i =0;i<k;i++)
        {
            if(p1 == null)
                return null;
            p1 = p1.next;
        }
        while(p1!=null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        Node found = nthToLast(head,k);
        if(found!=null)
            System.out.println(found.data);
        else
            System.out.println("Index out of bounds");
    }
}
