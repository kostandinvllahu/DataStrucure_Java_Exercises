/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kursi.javads;

/**
 *
 * @author User
 */
public class DoublyLinkedList {
    
    Node head, tail;
    
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(head != null){
        tail.next = newNode;
        newNode.next = tail;
        tail = newNode;
        newNode = null;
    }else{
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }
    }
    
    public void deleteOdd(){
        Node outer = head;
        Node inner = head;
        int counter = 0;
         while(outer != null){
             int currentValue = outer.value;
             outer = outer.next;
             
             while(inner != null){
                 if(currentValue == inner.value){
                     counter++;
                 }
                 inner = inner.next;
             }
             if(oddNumber(counter)){
                 deleteValue(currentValue);
             }
             outer = outer.next;
             counter = 0;
             
         }
    }
    public boolean oddNumber(int nr){
        if(nr % 2 != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void showElements(){
        Node current = head;
        if(head == null){
            System.out.println("Lista bosh");
            return;
        }
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void deleteValue(int value){
        Node node = head;
        while(head != null){
            if(node.value == value){
                dequeue(node);
            }
            node = node.next;
        }
    }
    
    public void dequeue(Node node){
        if(head == null){
            return;
        }
        if(node == head){
            head = node.next;
        }
    if(node.next != null){
    node.next.previous = node.previous;
    }
    
    if(node.previous != null){
        node.previous.next = node.next;
    }
}
    
    
    class Node{
        
        int value;
        Node next;
        Node previous;
        
        public Node(int value){
            this.value = value;
        }
    }
    
}
