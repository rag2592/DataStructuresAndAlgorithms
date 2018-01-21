import java.util.Scanner;

/**
 * Created by rsr37 on 7/9/2017.
 */
// Creating partition around a integer value
public class Question2_4 {
    public static Node listPartition(Node head, int p)
    {    int pCount = 0,flag1 =0, flag2 = 0;
         Node temp = head;
         Node bigList = null;
         Node smallList = null;
         while(temp != null)
         {
             System.out.println(temp.data);
             if(temp.data > p){
                 if(flag1 == 0)
                 {
                    bigList = new Node(temp.data);
                    flag1 =1;
                 }
                 else
                     bigList.add(temp.data);
             }

             else if( temp.data < p)
             {
                 if(flag2 == 0)
                 {
                     smallList = new Node(temp.data);
                     flag2 =1;
                 }
                 else
                     smallList.add(temp.data);
             }
             else
                 pCount++;
             temp = temp.next;
         }
         while(pCount > 0)
         {
             bigList.add(p);
             pCount--;
         }
         head = bigList;
         while(bigList.next != null)
             bigList = bigList.next;
         bigList.next = smallList;
         return head;
    }
    public static void main(String[] args){
        Node head = new Node(10);
        head.add(11);
        head.add(10);
        head.add(12);
        head.add(13);
        head.add(11);
        head.printList();
        System.out.println("Enter the value for which the list should be partitioned for");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        head = listPartition(head,k);
        head.printList();
    }
}
