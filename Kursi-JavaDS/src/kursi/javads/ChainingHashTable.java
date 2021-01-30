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
public class ChainingHashTable {
   private LinkedHashEntry[] table;
   private int TABLE_SIZE;
   private int size;
   
   public ChainingHashTable(){
       this.TABLE_SIZE = TABLE_SIZE;
       size = 0;
       table = new LinkedHashEntry[TABLE_SIZE];
       for(int i = 0; i < TABLE_SIZE; i++){
           table[i] = null;
       }
   }
   
   public int hash(String key){
       return HashTable.hash(key, TABLE_SIZE);
   }
   
   public void insert(String key, int value){
       int i = hash(key) % TABLE_SIZE;
       if(table[i] == null)
           table[i] = new LinkedHashEntry(key, value);
           else{
           LinkedHashEntry entry = table[i];
           while(entry.next != null && !entry.key.equals(key)){
               entry = entry.next;
           }
           if(entry.key.equals(key))
               entry.value = value;
           else
               entry.next = new LinkedHashEntry(key, value);
       }
       size++;
   }
    
   public void printHashTable(){
       for(int i = 0; i<TABLE_SIZE; i++){
           System.out.println("\nBucket  " + (i) + " : ");
           LinkedHashEntry entry = table[i];
           
           while(entry != null){
               System.out.println(entry.key + " ");
               entry = entry.next;
           }
       }
   }    
    
    
    
    public void remove(String key){
        int i = hash(key) % TABLE_SIZE;
        if(table[i] != null){
            LinkedHashEntry prev = null;
            LinkedHashEntry  entry = table[i];
            
            while(entry.next != null && entry.key.equals(key)){
                prev = entry;
                entry  = entry.next;
            }
            if(entry.key.equals(key)){
                if(prev == null)
                table[i] = entry.next;
                else
                    prev.next = entry.next;
                size--;
            }
        }
    }
    
    public int get(String key){
        int i = hash(key)% TABLE_SIZE;
        if(table[i] == null){
            return - 1;
        }else{
            LinkedHashEntry entry = table[i];
            while(entry != null && entry.key.equals(key)){
                entry = entry.next;
            } 
            if(entry == null)
            return -1;
        else
            return entry.value;
        }    
    }
    
    class LinkedHashEntry {
        String key;
        int value;
        LinkedHashEntry next;
        
        public LinkedHashEntry(String key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
}
