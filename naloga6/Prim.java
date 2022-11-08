package psa.naloga5;

public class Prim {
	int[][] data;
	int n;

	public Prim(int n) {
		data = new int[n][n];
		this.n = n;
	}

	public Prim(int[][] d) {

		if (d.length == d[0].length) {
			this.data = d;
			this.n = d.length;
		}
		if (d.length>d[0].length) {
			int[][] dta = genEmptyData(d.length);
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d[0].length; j++) {
					dta[j][i] = d[j][i];
				}
			}
			this.data = dta;
		} else if (d[0].length>d.length) {
			int[][] dta = genEmptyData(d[0].length);
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d[0].length; j++) {
					dta[j][i] = d[j][i];
				}
			}
			this.data = dta;
		}
	}

	public int[][] genEmptyData(int n){
		data = new int[n][n];
		for (int i = 0; i < data[0].length; i++) {
			for (int j = 0; j < data.length; j++) {
				data[i][j] = 0;
			}
		}
		return data;
	}

	public void addEdge(int i, int j, int d) {
		// doda d v data[i][j]== data[j][i]
		if ( data.length > i &&
			data[0].length > j &&
			data.length > j &&
			data[0].length > i ) {

			data[i][j]= d;
			data[j][i]= d;
		}
	}

	public int MSTcost() {
		throw new UnsupportedOperationException("To funkcijo morate implementirati");
	}

	public int[] prim(int s) {
		throw new UnsupportedOperationException("To funkcijo morate implementirati");
	}

}
