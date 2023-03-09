package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        MarLinkedList list = new MarLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.addByIndex(0,node4);
        for(int i=0;i< list.size();i++){
            System.out.println(list.getDataByIndex(i));
        }
        list.removeByIndex(0);
        System.out.println("------");
        System.out.println(list);
        System.out.println(list.getDataByIndex(2));

    }
}