package psa.naloga2;

import java.util.Vector;

public class UnionFind {
	public int[] id;

	public UnionFind(int N) {
		this.id = new int[N];
		for (int i = 0; i < id.length; i++) {
			this.id[i] = i;
		}
	}

	/*
	 * Metoda sprejme index in vrne predstavnika mnozice, katere clan je index.
	 */
	public int find(int i) {
		// neki je treba kle spremenit
		int tmp = i;
		Vector<Integer> viktor = new Vector<Integer>();

		while ( tmp != id[tmp] ) {
			viktor.add(tmp);
			tmp = id[tmp];
		}
		id[i] = tmp;
		for (Integer st : viktor) {
			id[st] = tmp;
		}
		return tmp;
	}

	/*
	 * Metoda sprejme da indexa in naredi unijo
	 */
	public void unite(int p, int q) {
		// q je v p-ju -> od p-ja koren vzames
		this.id[p] = find(q);
	}

	/*
	 * Metoda vrne true, ce sta p in q v isti mnozici
	 */
	public boolean isInSameSet(int p, int q) {
		int korp = find(p);
		int korq = find(q);
		if ( korp == korq ) {
			return true;
		} else {
			return false;
		} 
	}
}
