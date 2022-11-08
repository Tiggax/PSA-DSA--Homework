package psa.naloga3;


/*
 * Razred mora imeplementirati podatkovno strukturo Razprsilne tabele.
 * Za funkcijo uporabite: h(x) = x * 53 mod 100
 * V primeru kolizij uporabite LINEARNO NASLAVLJANJE.
 */
public class HashTable2 {

	int[] data;
	boolean[] santasHelper;

	public HashTable2() {
		this.data = new int[100];
		this.santasHelper = new boolean[100];
	}
	public int locateMe(int x) {
		return ((( 53 *x % 100 ) + 100 ) % 100 );
	}

	/*
	 * Metoda sprejme število in ga vstavi v tabelo. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean insert(int key) {
		int loc = locateMe(key);
		if (search(key)) {
			return false;
		}
		int i = loc;
		boolean looper = false;
		while (santasHelper[i]) {
			if (i == data.length - 1) {
				if (looper) {break;}
				i = 0;
				looper = true;
			} else {
				i++;
			}
		}
		this.data[i] = key;
		this.santasHelper[i]= true;
		return true;
	}

	/*
	 * Metoda sprejme število in ga poišče v tabeli. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean search(int key) {
		int loc = locateMe(key);
		int i = loc;
		boolean looper = false;
		while (santasHelper[i]) {
			if ( data[i] == key ) {
				return true;
			}
			if (i == data.length - 1) {
				if (looper) {break;}
				i = 0;
				looper = true;
			} else {
				i++;
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme število in ga izbriše iz tabele. Metoda vrne true, ce je
	 * bilo ustavljanje uspešno in false sicer
	 */
	public boolean delete(int key) {
		if (!search(key)) {return false;}
		int i = locateMe(key);
		boolean looper = false;
		while (santasHelper[i]) {
			if ( data[i] == key ) {
				santasHelper[i]= false;
				return true;
			}
			if (i == data.length - 1) {
				if (looper) {break;}
				i = 0;
				looper = true;
			} else {
				i++;
			}
		}
		return false;
	}
}
