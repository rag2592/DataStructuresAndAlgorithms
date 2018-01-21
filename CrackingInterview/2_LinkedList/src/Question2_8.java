/**
 * Created by rsr37 on 7/9/2017.
 */
//to return the start of the loop in a linkedlist
public class Question2_8 {
    public static Node returnCircularNode(Node head)
    {
        Node slow = head;
        Node fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // Error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both now point to the start of the loop.
        return fast;
    }
    public static void main(String[] args)
    {
        Node list = new Node(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(11);
        list.add(12);
        list.add(13);
        int i =0;
        Node temp = list;
        while( i < 4 ){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        list.printList();
        Node result = returnCircularNode(list);
        if(result!=null)
            System.out.println(result.data);
        else
            System.out.println("No Loop Found.!");


    }
}
