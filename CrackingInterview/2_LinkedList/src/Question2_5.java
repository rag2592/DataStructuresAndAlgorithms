/**
 * Created by rsr37 on 7/9/2017.
 */
public class Question2_5 {
    public static Node addLists(Node l1, Node l2)
    {
     Node result = null;
     int carry = 0;
     if((l1.data+l2.data) > 9){
         result = new Node((l1.data+l2.data)%10);
         carry = 1;
     }
     else {
         result = new Node(l1.data + l2.data);
     }
     l1 = l1.next;
     l2 = l2.next;

     while(l1!=null && l1!=null){
         if(carry == 1)
         {
             if((l1.data +l2.data + carry) > 9)
             {
                 result.add((l1.data +l2.data + carry)%10);
             }
             else
             {
                 result.add(l1.data +l2.data + carry);
                 carry = 0;
             }
         }
         else
         {
             if((l1.data +l2.data) > 9)
             {
                 result.add((l1.data +l2.data)%10);
                 carry = 1;
             }
             else
             {
                 result.add(l1.data +l2.data);
             }
         }
         l1 = l1.next;
         l2 =  l2.next;
     }
     return result;
    }
    public static void main(String[] args)
    {
        Node list1 = new Node(7);
        list1.add(1);
        list1.add(6);
        list1.printList();
        Node list2 = new Node(5);
        list2.add(9);
        list2.add(2);
        list2.printList();
        Node result = addLists(list1,list2);
        result.printList();
    }
}
