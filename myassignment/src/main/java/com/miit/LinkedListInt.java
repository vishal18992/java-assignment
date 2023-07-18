package com.miit;

public class LinkedListInt {
    private Node head;


    static class Node {
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }

        public int getValue(){
            return this.data;
        }

        public boolean hasNext(){
            return (this.next == null) ? false : true;
        }

        public Node next() {
            if(!this.hasNext()){
                return null;
            }else{
                return this.next;
            }
        }

    }

    public boolean add(int val){
        Node node  = new Node(val);
        node.next = null;

        if(LinkedListInt.this.head == null){
            LinkedListInt.this.head = node;
        }else{
            Node last = LinkedListInt.this.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = node;
        }
        return true;
    }

    public int element(){
        return this.head.data;
    }

    public Node getNode(){
        return this.head;
    }

    public void printList(){
        Node curr =  this.getNode();
        while (curr != null){
            System.out.println("Curr Data :- " + curr.getValue());
            curr = curr.next;
        }

    }

    public String printResult(){
        String str = "[";
        Node curr =  this.getNode();
        while (curr != null){
            System.out.println("Curr Data :- " + curr.getValue());
            str = str +  curr.getValue() + ", ";
            curr = curr.next;
        }
        str+= "]";
        return str;
    }

    @Override
    public String toString() {
        return this.printResult();
    }
}
