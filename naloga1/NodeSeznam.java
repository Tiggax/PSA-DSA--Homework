package psa.naloga1;

/*
narest metode:
				-insert
				-search
				-delete
				-//- za node
se jih uporab v class Seznam
+ treba dodat konstruktor
*/
public class NodeSeznam {
	private static int counter;
	private int key;
	private NodeSeznam tail;

	
	public NodeSeznam(int key){
		this.key=key;
	}

	public int getKey(){
		return key;
	}
	public NodeSeznam getTail(){
		return tail;
	}
//------------------[Werk]-------------------------
	public boolean insert(NodeSeznam node){ 
		if (tail == null) {
			tail = new NodeSeznam(node.key);
			return true;
		} else {
			return tail.insert(node);
		}
	}
	
	public boolean delete(NodeSeznam node){
		if (tail.compare(node)==0) {
				tail = tail.tail;
				return true;
		} else {
			return tail.delete(node);
		}
	}
	
	public boolean search(NodeSeznam node){
		if (tail == null) {
			return false;
		}
		else{
			if (tail.compare(node) == 0) {
				return true;
			} else {
				return tail.search(node);
			}
		}	
	}
//-----------------[no touchy]----------------------
	public int compare(NodeSeznam node) {
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
