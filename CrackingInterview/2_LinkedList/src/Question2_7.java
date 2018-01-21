import java.util.HashSet;

/**
 * Created by rsr37 on 7/9/2017.
 */
// Check if two lists are intersecting
public class Question2_7 {
    public static Node intersectingNode(Node list1, Node list2)
    {
        HashSet<Node> set = new HashSet<>();
        while(list1!=null)
        {
            set.add(list1);
            list1 = list1.next;
        }
        while(list2!= null)
        {
            if(set.contains(list2))
                return list2;
            list2 = list2.next;
        }
        return null;
    }
    public static void main(String[] args)
    {
        Node list1 = new Node(7);
        list1.add(1);
        list1.add(6);
        list1.add(1);
        list1.add(6);
        list1.printList();
        Node list2 = new Node(5);
        list2.add(9);
        list2.add(2);
        list1.add(1);
        list1.add(6);
        list1.next.next = list2.next.next;
        Node result = intersectingNode(list1,list2);
        if(result == null)
            System.out.println("No Intersecting node found.!");
        else
            System.out.println(result.data);
    }
}
