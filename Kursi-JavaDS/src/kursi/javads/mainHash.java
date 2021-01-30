package kursi.javads;
public class mainHash {

	public static void main(String[] args) {
		/*System.out.println(HashTable.hash(37, 6));
		System.out.println(HashTable.hash("Tim", 6));

		LinearHashTable hashTable = new LinearHashTable(6);
		hashTable.insert("Rob", "0");
		hashTable.insert("Tim", "1");
		hashTable.insert("Ana", "2");
		hashTable.insert("Ema", "3");
		hashTable.insert("Arty", "4");
		hashTable.insert("Tea", "5");
		
		hashTable.printHashTable();
		System.out.println("SIZE 1: " + hashTable.getSize());
		hashTable.remove("Ema");
		hashTable.printHashTable();
		System.out.println("SIZE 2: " + hashTable.getSize());
//////////	  */     
              /*  QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(6);
                hashTable.insert("Rob", "0");
		hashTable.insert("Tim", "1");
		hashTable.insert("Ana", "2");
		hashTable.insert("Ema", "3");
		hashTable.insert("Arty", "4");
		hashTable.insert("Tea", "5");
                
                hashTable.printHashTale();
                System.out.println(hashTable.get("Ema"));
//                hashTable.remove("Tea");*/
              
              ChainingHashTable hashTable = new ChainingHashTable(6);
                
               hashTable.insert("Rob", 0);
		hashTable.insert("Tim", 1);
		hashTable.insert("Ana", 2);
		hashTable.insert("Ema", 3);
              hashTable.printHashTable();
              hashTable.remove("Arty");
              hashTable.printHashTable();
	}

}
