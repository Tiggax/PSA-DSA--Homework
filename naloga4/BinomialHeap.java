package psa.naloga4;

import java.util.Vector;

public class BinomialHeap {
	BinomialNode[] data;

	BinomialHeap() {
		data = new BinomialNode[1];
	}

	public boolean insert(int key) {
		// True <- vstavljen
		// False <- ni bil/ je ze not
		// IF array mejhen ga resizaš.
		// ----------------------------

		BinomialNode tmp = new BinomialNode(key);
		
		for (int i = 0; i < data.length; i++) {
			
			if (!(data[i]==null)) {
				if (i+1>=data.length) {
					resizeArray();
					this.data[i+1] = merge(data[i], tmp);
					this.data[i] = null;
					return true;
				}
				if ((data[i+1]==null)) {
					this.data[i+1] = merge(data[i], tmp);
					this.data[i] = null;
					return true;
				} else {
					tmp = merge(tmp, data[i]);
					data[i] = null;
					continue;
				}
			}
			this.data[i] = tmp;
			return true;
		}

		return false;
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			if ( data[i] == null ) {
				continue;
			}
			if ( data[i].getKey()  < min ) {
				min = data[i].getKey();
			}
		}
		return min;
	}

	public boolean delMin() {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {continue;}
			if ( data[i].getKey() == getMin() ) {
				
				Vector<BinomialNode> subs = data[i].getChilds();
				if (subs.size() == 0) {
					data[i] = null;
					return true;
				}

				int min = Integer.MAX_VALUE;
				int mini = Integer.MAX_VALUE;
				for (int j = 0; j < subs.size(); j++) {
					if ( subs.get(j).getKey() < min ) {
						min = subs.get(j).getKey();
						mini = j;
					}					
				}

				BinomialNode tmp = subs.get(mini);
				subs.remove(tmp);
				for (BinomialNode node : subs) {
					tmp.addChild(node);
				}

				data[i] = tmp;
				return true;
			}
		}
		return false;
	}

	private void resizeArray() {
		BinomialNode[] tmp = new BinomialNode[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			tmp[i] = data[i];
		}
		this.data = tmp;
	}

	private BinomialNode merge(BinomialNode t1, BinomialNode t2) {
		// vzam manši root, pinaš večjega nanga,
	
		if ( t1.getKey() < t2.getKey() ) {
			t1.addChild(t2);
			return t1;
		} else {
			t2.addChild(t1);
			return t2;
		}

	}
}
