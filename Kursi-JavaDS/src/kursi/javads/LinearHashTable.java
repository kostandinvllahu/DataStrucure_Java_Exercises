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

public class LinearHashTable {
	
	private int maxSize, currentSize;
	private String[] keys;
	private String[] values;
	
	//String[] keys = new String[size];
	public LinearHashTable(int maxSize) {
		this.maxSize = maxSize;
		currentSize = 0;
		keys = new String[maxSize];
		values = new String[maxSize];
	}
	
	//insertimi i nje vlere(K, V)
	public void insert(String key, String value) {
		int temp = hash(key);
		int i = temp;
		
		do {
			if (keys[i] == null) {
				keys[i] = key;
				values[i] = value;
				currentSize++;
				return;
			}
			
			if (keys[i].equals(key)) {
				values[i] = value;
				return;
			}
			
			i = (i + 1) % maxSize;
			
		} while(i != temp);
	}
	
	public void remove(String key) {
		if(!contains(key)) return;
		
		//find & delete
		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % maxSize;
		keys[i] = values[i] = null;
		
		//resize
		for(i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
			String temp1 = keys[i], temp2 = values[i];
			keys[i] = values[i] = null;
			currentSize--;
			insert(temp1, temp2);
		}
		currentSize--;
	}
	
	//AKSESIMI I NJE VLERE NEPERMJET LINEAR PROBING
	public String get(String key) {
		if (key == null) throw new IllegalArgumentException("Key is null");
		for (int i = hash(key); keys[i] != null; i = (i + 1) % maxSize) {
			if (keys[i].equals(key))
				return values[i];
		}
		return null;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	public void printHashTable() {
		System.out.println("\nHashTable: ");
		for(int i=0; i < maxSize; i++) {
			if (keys[i] != null)
				System.out.println(keys[i] + " " + values[i]);
		}
	}
	
	public int hash(String key) {
		return HashTable.hash(key, maxSize);
	}
	
	public int getSize() {
		return currentSize;
	}
	
}
