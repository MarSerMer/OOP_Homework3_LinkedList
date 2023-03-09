package org.example;

public class Node {
    public Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString(){
        return String.valueOf(data);
    }

}
