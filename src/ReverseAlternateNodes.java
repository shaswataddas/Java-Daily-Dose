import java.util.*;
import java.lang.*;

// class Node
//{
//    int data;
//    Node next;
//    Node(int key)
//    {
//        data = key;
//        next = null;
//    }
//}

public class ReverseAlternateNodes {
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }

            ReverseAlternateNodesSolution ob = new ReverseAlternateNodesSolution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }

    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
class ReverseAlternateNodesSolution
{
    public static void rearrange(Node odd)
    {
        Node start = odd;
        Node current = odd.next;

        //This variable will always point to the first even node.
        Node temp = current;

        //this logic will create two separate LL with alternative number
        while(start.next!=null && current.next!=null){
            start.next = current.next;
            start = current.next;
            current.next = current.next.next;
            current = start.next;
        }
        // This method will reverse the even Linked-list
        start.next = reverseEvenLL(temp);
    }

    static Node reverseEvenLL(Node head){
        Node current = head;
        Node previous = null;
        while(current!=null){
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

}