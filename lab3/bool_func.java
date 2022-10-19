
public class bool_func {
	int n = 4, m = 3;
	int n1 = 3, m1 = 4;
	
	private int[][] TruthTable = new int[n][m];
	private int[][] TransposedMatrix = new int[n1][m1];
	
	private bool_func(){
		TruthTable[0][0] = 0;
		TruthTable[0][1] = 0;
		TruthTable[1][0] = 0;
		TruthTable[1][1] = 1;
		TruthTable[2][0] = 1;
		TruthTable[2][1] = 0;
		TruthTable[3][0] = 1;
		TruthTable[3][1] = 1;
		
		for (int i=0; i<n; i++) {
			TruthTable[i][2] = (int) (Math.random() * 2);
		}
		
		System.out.println("Truth Table");
		matrix_output(TruthTable, n, m);
				
	}
	
	private void unitarity_check() {
		transposition();
		int[][] Result = new int[n][m1];
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m1;j++) {
				for (int k=0;k<m;k++) {
					Result[i][j] += TruthTable[i][k] * TransposedMatrix[k][j];
				}	
			}
		}
		System.out.println("The result of multiplication by the Hermitian conjugate matrix");
		matrix_output(Result, n, m1);
		boolean flag = false;
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<m1;j++) {
				if (i==j) {
					if (Result[i][j] == 1)
						continue;
					else {
						flag = true;
						System.out.println("Matrix is not unitary1");
						break;
					}
				}
				else {
					if (Result[i][j] == 0)
						continue;
					else {
						flag = true;
						System.out.println("Matrix is not unitary2");
						break;
					}
				}	
			}
			if (flag)
				break;
		}
	}
	
	private void transposition() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++ ) {
				TransposedMatrix[j][i] = TruthTable[i][j];
			}
		}
		
		System.out.println("Transposed matrix:");
		matrix_output(TransposedMatrix, n1, m1);
		
	}
	
	private void matrix_output(int[][] Matrix, int n, int m) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.print(" " + Matrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	
	public static void main(String[] str) {
		bool_func func = new bool_func();
		func.unitarity_check();
	}
}
