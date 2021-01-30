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
public class KursiJavaDS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //DoublyLinkedList list new DoublyLinkedList();
        DoublyLinkedList list = new DoublyLinkedList();
        list.enqueue(9);
        list.enqueue(19);
        list.enqueue(19);
        list.enqueue(19);
        list.enqueue(45);
        
        list.showElements();
       // list.deleteValue(45);
       list.deleteOdd();
    }
    
}
