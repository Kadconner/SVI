package lib;

public class AuxiliaryClass {
	public int[][] InitTruthOfTable(int n) {
		int rows = (int) Math.pow(2.0, n);
		int cols = n;
		
		int step = 1;
		boolean flag = false;
		
		int[][] table = new int[rows][cols];
		for (int k=cols-1;k>=0;k--) {
			for (int i=0;i<rows;i+=step) {
				for (int l=0;l<step;l++) {
						if (flag) {
							table[i+l][k] = 1;
						}
						else {
							table[i+l][k] = 0;
						}		
				}
				flag = !flag;
			}
			step *=2;
		}
		
		return table;
			
	}
	
	public void matrix_output(int[][] Matrix, int n, int m) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.print(" " + Matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	public void matrix_output(int[] Matrix, int n, int m) {
		for (int i=0; i<n; i++) {
			System.out.println(" " + Matrix[i] + " ");
		}
	}
	
	public int[][] MatrixTransition(int[][] source_matrix, int rows, int cols) {
		int[][] transition_matrix = new int[rows][rows];
		String buf = "";
		int position = 0;

		System.out.println("Matrix transitions:");
		for (int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				buf = buf + Integer.toString(source_matrix[i][j]);
			}
			position = Integer.parseInt(buf, 2);
			buf = "";
			transition_matrix[i][position] = 1;
			System.out.println("" + i + "-->" + position);
		}
		
		
		
		for (int i=0;i<rows;i++) {
			for (int j=0;j<rows;j++) {
				System.out.print(" " + transition_matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		return transition_matrix;
	}

}
