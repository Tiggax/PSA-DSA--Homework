package psa.naloga1;

public class Binarno {
	private NodeBinarno root;

	/*
	 * Metoda sprejme celo stevilo in ga vstavi v drevo. Ce element ze obstaja v drevesu, vrne false
	 * Metoda vrne true, ce je bil element uspesno vstavljen in false sicer.
	 */
	public boolean insert(int element) {
		NodeBinarno node = new NodeBinarno(element);
		if (root == null) {
			root = node;
			return true;
		} else {
			return root.insert(node);
		}
	}

	/*
	 * Metoda sprejme celo stevilo in izbrise element iz drevesa.
	 * Metoda vrne true, ce je bil element uspesno izbrisan iz drevesa, in false sicer
	 */
	public boolean delete(int element) {
		NodeBinarno node = new NodeBinarno(element);
        if (root == null){
            return false;
        } else {
            return root.delete(node);
        }
	}

	/*
	 * Metoda sprejme celo stevilo in poisce element v drevesu.
	 * Metoda vrne true, ce je bil element uspesno najden v drevesu, in false sicer
	 */
	public boolean search(int element) {
		NodeBinarno node = new NodeBinarno(element);
		if (root == null) {
			return false;
		} else {
			return root.search(node);
		}
	}

	public int getCounter() {
		return root != null?root.getCounter():null;
	}

	public void resetCounter() {
		if(root!= null)
			root.resetCounter();
	}
}
