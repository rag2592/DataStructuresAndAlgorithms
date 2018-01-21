/**
 * Created by rsr37 on 1/9/2018.
 */

class LNode{
    int data;
    LNode next;

    LNode(int d){
        data = d;
        next = null;
    }
}

class LQueue{
    LNode front, rear;
    public LQueue(){
        front = rear = null;
    }

    void enQueue(int value){
        LNode temp = new LNode(value);

        if(rear == null){
            front = rear = temp;
            return;
        }

        rear.next = temp;
        rear = temp;
    }

    LNode deQueue(){
       if(front == null)
           return null;

       LNode temp = front;
       front = front.next;

       if(front == null)
           rear = null;
       return temp;
    }
}
public class QueueWithList {
    public static void main(String[] args){
        LQueue q = new LQueue();
        q.enQueue(10);
        q.enQueue(20);
        q.deQueue();
        q.deQueue();
        q.enQueue(30);
        q.enQueue(40);
        q.enQueue(50);

        System.out.println("the dequeued element is:"+ q.deQueue().data);

    }
}
