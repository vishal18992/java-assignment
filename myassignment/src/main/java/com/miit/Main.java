package com.miit;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        sortLinkedList();
        mySingleLinkedList();
    }

    public static void mySingleLinkedList(){
        LinkedListInt listInt1 = new LinkedListInt();
        listInt1.add(1);
        listInt1.add(4);
        listInt1.add(5);

        LinkedListInt listInt2 = new LinkedListInt();
        listInt2.add(1);
        listInt2.add(3);
        listInt2.add(4);

        LinkedListInt listInt3 = new LinkedListInt();
        listInt3.add(2);
        listInt3.add(6);

        List<LinkedListInt> list = new ArrayList<>();
        list.add(listInt1);
        list.add(listInt2);
        list.add(listInt3);

        List<Integer> out  = new ArrayList<>();

        list.forEach((val) -> {
            LinkedListInt.Node curr =  val.getNode();
            while (curr != null){
                out.add((Integer) curr.getValue());
                curr = curr.next();
            }
        });

       Collections.sort(out);

        System.out.println(out);
    }

    public static void sortLinkedList(){
        LinkedList<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1,4,5));
        LinkedList<Integer> l2 = new LinkedList<Integer>(Arrays.asList(1,3,4));
        LinkedList<Integer> l3 = new LinkedList<Integer>(Arrays.asList(2,6));


        ArrayList<LinkedList> list  = new ArrayList<>(Arrays.asList(l1,l2,l3));

        LinkedList<Integer> out = new LinkedList<>();

        list.forEach(out::addAll);
        out.sort(Comparator.comparingInt(a -> a));
        System.out.println("After Sort:- " + out);
    }

}