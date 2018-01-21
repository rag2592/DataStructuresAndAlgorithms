/**
 * Created by rsr37 on 1/9/2018.
 */
class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
};

class List{
        Node head;
        List(int d){
            head = new Node(d);
        }
        void addNode(int d){
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
             }
            temp.next = new Node(d);
            //return head;
        }

        void printList(){
            Node head1 = head;
            while(head1.next != null) {
                System.out.print(head1.data + "->");
                head1 = head1.next;
            }
            System.out.println(head1.data);
        }

        int minNodeData(){
            if(head == null)
                return Integer.MIN_VALUE;;
            int min = head.data;
            Node temp = head.next;
            while(temp != null){
                if(temp.data < min)
                    min = temp.data;
                temp = temp.next;
            }
            return min;
        }
        Node findKthFromEnd(int k){
            if(head == null)
                return null;
            Node temp1 = head;
            Node temp2 = head;
            while(k!=0 && temp1 != null){
                temp1 = temp1.next;
                k--;
            }
            if(k == 0) {
                while (temp1 != null) {
                    temp2 = temp2.next;
                    temp1 = temp1.next;
                }
                return temp2;
            }
            else
                return null;
            //return temp2.data;
        }
        void delete(Node head){
            Node temp1 = findKthFromEnd(2);
            Node temp2 = head;
            Node prev = null;
            while(temp2 != temp1){
                prev = temp2;
                temp2 = temp2.next;
            }
            prev.next = temp2.next;
        }
        void deleten_1(){
            delete(head);
        }

};
public class MinimumNode {
    public static void main(String[] args){
        List l1 = new List(10);
        l1.addNode(9);
        l1.addNode(7);
        l1.addNode(25);
        l1.addNode(11);
        l1.addNode(1);
        l1.addNode(20);
        l1.addNode(30);

        l1.printList();
        System.out.println("The minimum Node data is: "+ l1.minNodeData());

        System.out.println("the 3rd node from back is: " + l1.findKthFromEnd(3).data);

        l1.deleten_1();
        l1.printList();

    }
}
