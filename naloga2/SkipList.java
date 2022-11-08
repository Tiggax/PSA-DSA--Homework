package psa.naloga3;

import org.w3c.dom.Node;

public class SkipList {

	public NodeSkipList mylist;
	public int maxVisina;
	public int maxNodes;
	public int muchNodes;

	/*
	 * Tvoritelj sprejme kot parameter stevilo elementov, ki jih je sposoben
	 * obdelati
	 */
	public int getVisina(int maxVisina) {
		for (int i = 0; i < maxVisina; i++) {
			if (Math.random() >= 0.5) {
				return ++i;
			}
		}
		return (int) maxVisina;
	}

	public SkipList(long maxNodes) {
		this.maxVisina = (int)((Math.log(Math.round(maxNodes)) / Math.log(2)));
		this.maxNodes = (int) maxNodes;
		NodeSkipList start[] = new NodeSkipList[(int) maxVisina];
		for (int i = 0; i < maxVisina; i++) {
			start[i] = new NodeSkipList(Integer.MAX_VALUE, new NodeSkipList[(int) maxVisina]);
		}
		this.mylist = new NodeSkipList(Integer.MIN_VALUE, start);
	}

	/*
	 * Metoda sprejme stevilo in ga vstavi v preskocni seznam. Ce element ze
	 * obstaja v podatkovni strukturi, vrne false. Metoda vrne true, ce je bil
	 * element uspesno vstavljen in false sicer.
	 */
	public NodeSkipList GetMeMeBloodyRecursiveList(NodeSkipList node, int level, int key) {
		if (node.next[level].key < key) {
			return GetMeMeBloodyRecursiveList(node.next[level], level, key);
		} else {
			return node;
		}
	}

	public boolean insert(int searchKey) {
		if (search(searchKey)) {
			return false;
		}
		if (muchNodes > maxNodes) {
			return false;
		} else {
			muchNodes++;
		}
		NodeSkipList myKey = new NodeSkipList(searchKey, new NodeSkipList[getVisina(maxVisina)]);
		for (int i = maxVisina - 1; i >= 0; i--) {
			if (myKey.next.length >= i+1) {
				myKey.next[i] = GetMeMeBloodyRecursiveList(mylist, i, searchKey).next[i];
				GetMeMeBloodyRecursiveList(mylist, i, searchKey).next[i] = myKey;
			}
		}
		return true;
	}

	/*
	 * Metoda sprejme stevilo in poisce element v preskocnem seznamu. Metoda
	 * vrne true, ce je bil element uspesno najden v podatkovni strukturi, in
	 * false sicer
	 */
	public boolean search(int searchKey) {
		//TODO search zgleda neki ne dela, ker zadnji heca.
		NodeSkipList a = mylist;
		NodeSkipList b = mylist;
		for (int i = maxVisina - 1; i >= 0; i--) {
			while (a != null) {
				NodeSkipList prevA = a;
				b = a.next[i];
				a = b;
				if (a.key == searchKey) {
					return true;
				}
				if (a.key > searchKey) {
					// je manjši gremo v nivo nižje(pri prejšnem)
					a = prevA;
					break;
				} else {
					// je večji pogledam naslednjega
					continue;
				}
			}
		}
		return false;
	}

	/*
	 * Metoda sprejme stevilo in izbrise element iz preskocnega seznama. Metoda
	 * vrne true, ce je bil element uspesno izbrisan iz podatkovne strukture, in
	 * false sicer
	 */
	public boolean delete(int key) {
		if (search(key)) {
			int lngth = GetMeMeBloodyRecursiveList(mylist, 0, key-1).next.length;
			for (int i = maxVisina - 1; i >= 0; i--) {
				if (lngth >= i+1) {
				GetMeMeBloodyRecursiveList(mylist, i, key-1).next[i] = GetMeMeBloodyRecursiveList(mylist, i, key).next[i].next[i];
			}
		}
		return true;
		} else {
			return false;
		}
	}
}
