package pl.edu.pjwstk.s8267.GUI.Lab1;

import java.util.Vector;

public class Table {
	private int[][] data;

	public Table(int[][] data) {
		this.data = data;
	}

	private Table getWithoutMin() {
		int rows, columns = 0;
		int min = 0;
		Vector<Integer> minColumns = new Vector<Integer>();
		Vector<Integer> minRows = new Vector<Integer>();
		rows = data.length;
		for(int i = 0; i < rows; i++) {
			columns = data[i].length;
			for(int j = 0; j < columns; j++) {
				if(data[i][j]<min || minColumns.size() == 0) {
					min = data[i][j];
					minColumns.removeAllElements();
					minRows.removeAllElements();
					minRows.add(i);
					minColumns.add(j);
				} else if( data[i][j] == min ) {
					if(!minRows.contains(i))
						minRows.add(i);
					if(!minColumns.contains(j))
						minColumns.add(j);
				}
			}
		}
		
		int[][] newData = new int[rows-minRows.size()][columns-minColumns.size()];
		int k = 0;
		int l;
		for(int i = 0; i < data.length; i++) {
			if(!minRows.contains(i)) {
				l = 0;
				for(int j = 0; j < data[i].length; j++) {
					if(!minColumns.contains(j)) {
						newData[k][l] = data[i][j];
						l++;
					}
				}
				k++;
			}
		}
		return new Table(newData);
	}
	
	public String toString() {
		String ret = "";
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				ret += String.format("%4d", data[i][j]);
			}
			ret += "\n";
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int[][] data = { { 2, 0, 8, 9 }, { 3, 0, -1, 20 }, { 13, 12, 17, 18 },
				{ 1, 2, 3, 4 }, { 2, 0, 7, 9 } };
		Table t1 = new Table(data);
		Table t2 = t1.getWithoutMin();
		Table t3 = t2.getWithoutMin();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}
}
