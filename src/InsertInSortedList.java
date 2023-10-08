import java.util.*;
import java.io.*;


public class InsertInSortedList{
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            int k = sc.nextInt();

            head = sortedInsert(head,k);

            printList(head);
            t--;
        }
    }

    static Node sortedInsert(Node head1, int key) {
        // Add your code here.
        Node prev = head1;
        Node curr = head1;
        if(curr.data > key){
            Node temp = new Node(key);
            temp.next = head1;
            head1 = temp;
            return head1;
        }
        curr = prev.next;
        if(curr.data > key){
            Node temp = new Node(key);
            temp.next = curr;
            prev.next = temp;
            return head1;
        }
        // System.out.println("Initial current - "+curr.data+" Prev - "+prev.data);
        while(curr.next != null && curr.next.data < key){
            prev = prev.next;
            curr = prev.next;
            // System.out.println("current - "+curr.data+" Prev - "+prev.data);
        }
        // System.out.println("Final current - "+curr.data+" Prev - "+prev.data);
        Node temp = new Node(key);
        temp.next = curr.next;
        curr.next = temp;
        return head1;
    }
}
