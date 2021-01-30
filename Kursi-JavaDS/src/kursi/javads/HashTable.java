package kursi.javads;
public class HashTable {
	
	//hash integers
	public static int hash(int key, int tableSize) {
		return key % tableSize;
	}
	
	//hash strings
	public static int hash(String key, int tableSize) {
		int hashValue = 0;
		
		for(int i= 0; i < key.length(); i++) {
			hashValue += key.charAt(i);
		}
		return hashValue % tableSize;
	}
	
	//1234 = 1 * 10^3 + 2* 10^2 + 3 * 10^1 + 4 * 10^0
	//1234 = (((1)10 + 2)10 + 3)10 + 4
	//ema = 'e' * 128^2 + 'm' * 128^1 + 'a' * 128^0
	//ema = (('e')128 + 'm')128 + 'a'
	
	//DY SHEMBUJ
	public static int hash128(String key, int tableSize) {
		int hashValue = 0;
		
		for(int i=0; i < key.length(); i++) {
			hashValue = (hashValue * 128 + key.charAt(i)) % tableSize;
		}
		
		return hashValue;
	}
}
