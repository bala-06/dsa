import java.util.Scanner;
import java.io.*;
class Node{
    int val;
    Node next;
    public  Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}
class LinkedList{
    public Node deletebyValue(Node head,int data)
    {
        if (head.val==data) return head.next;
        Node pre=null;
        while(head.next!=null)
        {
            pre=head;
            head=head.next;
            if (head.val==data) {
                pre.next=head.next;
                return head;
            }
        }
        return head;

    }
    public Node insertAtEnd(Node head,int data)
    {
        Node newNode=new Node(data);
        if (head==null){
            head=newNode;
        }
        else {
            Node dummynode=head;
            while(dummynode.next!=null) dummynode=dummynode.next;
            dummynode.next=newNode;
        }
        return head;
    }
    public Node insertAtFront(Node head,int data)
    {
        Node front=new Node(data);
        front.next=head;
        return front;
    }
    public Node deleteAtFront(Node head)
    {
        head=head.next;
        return head;
    }
    public Node deleteAtEnd(Node head)
    {
        Node dumpy=head;
        Node pre=null;
        while(dumpy.next!=null)
        {
            pre=dumpy;
            dumpy=dumpy.next;
        }
        pre.next=null;
        return head;


    }

}

class InputOutput{

    public Node getInput()
    {
        LinkedList list=new LinkedList();
        Node head=null;
        try (BufferedReader br=new BufferedReader(new FileReader("D:\\dsa\\input")))
        {
            String line;
            while((line=br.readLine())!= null){
                for( String numStr: line.split("\\s+")) head=list.insertAtEnd(head,Integer.parseInt(numStr));
            }
        }
        catch (IOException e){
            System.out.println("Error while read input"+ e.getMessage());
        }
        return head;

    }
    public void output(Node node){
        try(BufferedWriter bw =new BufferedWriter(new FileWriter("D:\\dsa\\output", true)))
        {
            while(node!=null) {
                bw.write(node.val+" ");
                node=node.next;
            }
            bw.write("\n");
        }
        catch (IOException e){
            System.err.println("Error while write output"+ e.getMessage());
        }
    }
}


class Main{

    public static void main(String[] args) {
        try(BufferedWriter bw =new BufferedWriter(new FileWriter("D:\\dsa\\output")))
        {
            bw.write("");
        }
        catch (IOException e){
            System.err.println("Error while write output"+ e.getMessage());
        }

        InputOutput obj=new InputOutput();
        Node head=obj.getInput();
        LinkedList ll=new LinkedList();
        ll.insertAtEnd(head,6);
        obj.output(head);
        head=ll.insertAtFront(head,0);
        obj.output(head);
        ll.deleteAtEnd(head);
        obj.output(head);
        head=ll.deleteAtFront(head);
        obj.output(head);
        ll.deletebyValue(head,5);
        obj.output(head);



    }
}
