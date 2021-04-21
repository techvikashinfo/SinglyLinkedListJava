package com.custom.ds.modal;

public class Node<E> {
    private E  data;
    private Node<E>  nextNode;

    public Node(E data, Node<E> nextNode) {
        super();
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(E data) {
        super();
        this.data = data;
        this.nextNode=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }


}
