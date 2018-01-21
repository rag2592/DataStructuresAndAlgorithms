import java.util.Stack;

/**
 * Created by rsr37 on 7/9/2017.
 */
// to check if a list is a palindrome
public class Question2_6 {
    public static boolean isPalindrom(Node head)
    {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<Integer>();
        while(fast!=null && fast.next!= null)
        {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null)// has odd number of elements
        {
            slow = slow.next;
        }
        while(slow != null)
        {
            int top = stack.pop().intValue();
            if(top != slow.data)
                return false;
            slow = slow.next;
        }
        return true;
    }
    public static void main(String args[]){
        Node list = new Node(10);
        list.add(11);
        list.add(12);
        list.add(11);
        list.add(10);
        list.printList();
        boolean result = isPalindrom(list);
        if(result)
            System.out.println("Is a palindrome");
        else
            System.out.println("Is not a palindrome");

    }
}
