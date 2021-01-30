/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kursi.javads;

import static java.util.Objects.hash;

/**
 *
 * @author User
 */
public class QuadraticProbingHashTable {
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;
    
    public QuadraticProbingHashTable(int maxSize){
        this.maxSize = maxSize;
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
        
    }
public void insert(String key, String value){
int temp = hash(key);
int i = temp, h=1;
do {
    if(keys[i] == null){
        keys[i] = key;
        vals[i] = value;
        currentSize++;
        return;
    }
    if(keys[i].equals(key)){
        vals[i] = value;
        return;
    }
    i = (i + h * h) % maxSize;
    h++;
}

while(i != temp);
}
public int hash(String key){
    return HashTable.hash(key, maxSize);
}
public void printHashTale(){
    System.out.println("Quadratic Probing Hash Table");
    for(int i = 0; i<maxSize; i++){
        if(keys[i] != null){
            System.out.println(keys[i] + " => " + vals[i]);
        }
    }
}

public String get(String key){
    int i = hash(key),h = 1;
    while(keys[i] != null){
        if(keys[i].equals(key)){
            return vals[i];
        }
        i=( i +  h * h)%maxSize;
        h++;
    }
    return null;
}
public boolean contains(String key){
    return get(key) != null;
}
public void remove(String key){
   if(!contains(key))
       return;
   int i = hash(key), h =1;
   while(key.equals(keys[i])){
       i = (i + h *h++) % maxSize;
   }
   keys[i] = vals[i] = null;
   for(i = (i + h * h++)%maxSize; keys[i] != null; i = (i + h *h) %maxSize){
       String temp1 = keys[i], temp2 = vals[i];
       currentSize--;
       insert(temp1, temp2);
   }
   currentSize--;
}
}

