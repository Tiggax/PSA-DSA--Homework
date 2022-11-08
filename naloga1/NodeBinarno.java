package psa.naloga1;
// LEVO < X < DESNO
public class NodeBinarno {
	private static int counter;
	private int key;
	private NodeBinarno levi;
	private NodeBinarno desni;

	public NodeBinarno(int knode){
		this.key = knode;
	}

	public int getKey(){
		return key;
	}
	public NodeBinarno getLevi(){
		return levi;
	}
	public NodeBinarno getDesni(){
		return desni;
	}

	public boolean insert(NodeBinarno node){
		int compared = compare(node);
		if (compared > 0) {
			if (this.desni == null) {
				this.desni = node;
				return true;
			}else{
				return this.desni.insert(node);
			}
		} else if (compared < 0) {
			if (this.levi == null) {
				this.levi = node;
				return true;
			} else {
				return this.levi.insert(node);
			}
		}else{
			return false;
		}
	}

	public boolean search(NodeBinarno node){
		int compared = compare(node);
		if (compared > 0) {
			if (this.desni == null) {
				return false;
			}else{
				return this.desni.search(node);
			}
		} else if (compared < 0) {
			if (this.levi == null) {
				return false;
			} else {
				return this.levi.search(node);
			}
		}else{
			return true;
		}
	}

	public boolean delete(NodeBinarno node){
		int compared = compare(node);
		if (compared > 0) {
			if (this.desni == null) {
				return false;
			}else{
				return this.desni.delete(node);
			}
		} else if (compared < 0) {
			if (this.levi == null) {
				return false;
			} else {
				return this.levi.delete(node);
			}
		}else{
			if (this.levi == null && this.desni == null) {
				//TODO
			}
			if (this.levi == null) {
				this.key = getMin().getKey();
				delMin();
			} else if (this.desni == null) {
				this.key = getMax().getKey();
				delMax();
			}



			if (this.levi == null && this.desni == null) {
				this.key = ;
				return true;
			} else {
				
			}
		}
	}
	public NodeBinarno getMin(){
		if (this.levi.levi == null) {
			return this.levi;
		} else {
			return levi.getMin();
		}
	}
	public boolean delMin(){
		if (this.levi.levi == null) {
			this.levi = null;
			return true;
		} else {
			return levi.delMin();
		}
	}
	public NodeBinarno getMax(){
		if (this.desni.desni == null) {
			return this.desni;
		} else {
			return desni.getMax();
		}
	}
	public boolean delMax(){
		if (this.desni.desni == null) {
			this.desni = null;
			return true;
		} else {
			return desni.delMax();
		}
	}

	public int compare(NodeBinarno node) {
		counter++;
		return node.key - this.key;
	}

	public int getCounter() {
		return counter;
	}

	public void resetCounter() {
		counter=0;
	}
}
