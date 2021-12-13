package com.playground.playground.datastructuresandalgoritms.list;

class MyLinkedList {
    class Node {
        int val;
        Node next;

        public Node (int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void addAtHead (int data) {
        Node node = new Node(data);
        if (size == 0) {
            head = tail = node;
        }
        else {
            node.next = head;
            head = node;
        }
        size++;
    }

    void addAtTail (int data) {
        Node node = new Node(data);
        if (size == 0) {
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void getNode (int index) {

    }

    void addAtIndex (int index, int data) {

    }

    void traverse () {
        if (head == null) {
            return;
        }
        Node curNode = head;
        while (curNode != null) {
            System.out.println("Current node: " + curNode.val);
            curNode = curNode.next;
        }
    }

    int search(int val){
        if(head==null){
            return -1;
        }
        int index=0;
        MyLinkedList.Node currentNode = head;
        while(currentNode!=null){
            if(currentNode.val==val){
                return index;
            }
            index++;
            currentNode=currentNode.next;
        }
        return -1; //if the value not exist in the list
    }
}

public class LinkedListInsertion {

    public static void main (String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println("Adding nodes to head and printing the list. ");
        for (int i = 0; i < 10; i++) {
            myLinkedList.addAtHead(i);
        }
        myLinkedList.traverse();

        myLinkedList = new MyLinkedList();
        System.out.println("Adding nodes to tail and printing the list. ");
        for (int i = 0; i < 10; i++) {
            myLinkedList.addAtTail(i);
        }
        myLinkedList.traverse();

        System.out.println("Searching value 5 in the list. ");
        int valIdx = myLinkedList.search(5);
        System.out.println("Index: "+valIdx);
    }
}
