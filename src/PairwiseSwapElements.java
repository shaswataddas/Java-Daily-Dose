import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    Node(int x){
        data = x;
        next = null;
    }
}

public class PairwiseSwapElements {
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
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data);
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data);
            }

            Node failure = new Node(-1);

            PairwiseSwapElementsSolution g = new PairwiseSwapElementsSolution();
            head = g.pairwiseSwap(head);

            Node temp = head;
            int f = 0;
            while (temp != null)
            {
                if(mp.get(temp) != temp.data){
                    f = 1;
                }
                temp = temp.next;
            }

            if(f==1){
                printList(failure);
            }
            else{
                printList(head);
            }
            t--;
        }
    }
}

class PairwiseSwapElementsSolution{
    public Node pairwiseSwap(Node head)
    {
        Node start = head;
        Node end = head.next;
        Node tracker;
        Node temp = end;
        if(head.next==null){
            return head;
        }
//        System.out.println("Start - "+start.data+" End - "+end.data);
        while(start!=null && end != null){
            start.next = end.next;
            end.next = start;
            tracker = start;
            start = start.next;
            if(start == null){
                break;
            }
            end = start.next;
            if(end == null){
                tracker.next = start;
            }else {
                tracker.next = end;
            }
//            System.out.println("Start - "+start.data+" End - "+end.data);
        }

        return temp;
    }
}