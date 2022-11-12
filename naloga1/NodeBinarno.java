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
		if (this.compare(node) < 0) {
			if (this.levi == null) {
				return false;
			} else {
				if (this.levi.compare(node) == 0 && this.levi.levi == null && this.levi.desni == null) { //delete if no children
					this.levi = null;
					return true;
				}else if(this.levi.compare(node) == 0) {
					if(this.levi.levi != null){
						int tmp = getMax(this.desni);
						this.delete(new NodeBinarno(tmp));
						this.levi.key = tmp;
					}else if(this.levi.desni != null){
						int tmp = getMin(this.desni);
						this.delete(new NodeBinarno(tmp));
						this.levi.key = tmp;
					}else{
						return true;
					}
				}else{
					return (this.levi).delete(node);
				}
			}
		} else if (this.compare(node) > 0) {
			if (this.desni == null) {
				return false;
			} else {
				if(this.desni.compare(node) == 0 && this.desni.levi == null && this.desni.desni == null){
					this.desni = null;
					return true;
				}else if(this.desni.compare(node) == 0) {
					if(this.desni.levi != null){
						int tmp = getMax(this.desni);
						this.delete(new NodeBinarno(tmp));
						this.desni.key = tmp;
					}else if(this.desni.desni != null){
						int tmp = getMin(this.desni);
						this.delete(new NodeBinarno(tmp));
						this.desni.key = tmp;
					}else{
						return true;
					}
				}else{
					return (this.desni).delete(node);
				}
			}
		} return false;
	}

	public int getMin (NodeBinarno node){
		if (node.desni == null) {
			return node.getKey();
		} else {
			return getMin(node.desni);
		}
	}
	public int getMax (NodeBinarno node){
		if (node.levi == null) {
			return node.getKey();
		} else {
			return getMax(node.levi);
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
