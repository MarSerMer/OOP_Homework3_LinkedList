package org.example;

import java.util.Iterator;

public class MarLinkedList implements Iterable{
    private Node head;
    private int size = 0;

    public int size(){
        return size;
    }

    public void add(Object data){
        Node n = new Node(data);
        Node temp = head;
        if (size==0){
            head=n;
            size++;
        } else {
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = n;
            size++;
        }
    }
    public void addByIndex(int index, Object data){
        if (index==size){
            add(data);
        } else if (index<size&&index>0){
            Node temp = findNodeByIndex(index-1);
            Node nodeToAdd = new Node(data);
            nodeToAdd.setNext(temp.getNext());
            temp.setNext(nodeToAdd);
            size++;
        } else if (index==0){
            Node nodeToAdd = new Node(data);
            nodeToAdd.setNext(head);
            head = nodeToAdd;
            size++;
        } else { //если индекс больше размера массива, или если он отрицательный
            throw new IndexOutOfBoundsException();
        }
    }
    public void removeByIndex(int index){
        if (!isEmpty()){
            if(index==0){
                head = findNodeByIndex(1);
                size--;
            } else if(index>0&&index<size){
                Node temp = findNodeByIndex(index-1);
                Node nodeToRemove = temp.getNext();
                temp.setNext(nodeToRemove.getNext());
                size--;
            } else { //если индекс больше размера массива или отрицательный
                throw new IndexOutOfBoundsException();
            }
        } else { //если массив пустой
            throw  new IndexOutOfBoundsException();
        }
    }
    private boolean isEmpty(){
        return size==0;
    }
    private Node findNodeByIndex(int index){
        if (!isEmpty()){ //если в массиве хоть что-то есть
            if (index>=size){ // если такого индекса нет в массиве
                throw new IndexOutOfBoundsException();
            } else if (index==0){
                return head;
            } else {
               Node result = head;
               for(int i=0;i<index;i++){
                   result = result.getNext();
               }
               return result;
            }
        } else { // если массив пустой
            throw new IndexOutOfBoundsException();
        }
    }

    public Object getDataByIndex(int index){
        Node n = findNodeByIndex(index);
        return n.getData();
    }

    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            Node temp = new Node("--");
            {
                temp.setNext(head);
            }
            Node it = temp;
            @Override
            public boolean hasNext() {
                return it.getNext()!=null;
            }

            @Override
            public Object next() {
                it = it.getNext();
                return it.getData();
            }
        };
    }

    @Override
    public String toString(){
        for(int i=0;i<size;i++){
            System.out.println(getDataByIndex(i));
        }
        return "The list is in console";
    }
}
