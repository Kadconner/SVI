import java.util.HashMap;

public class bool_func {
	int n = 4, m = 3;
	int n1 = 3, m1 = 4;
	int k = 8;
	
	private int[][] TruthTable = new int[n][m];
	private int[][] TransposedMatrix = new int[k][k];
	private int[][] ConvertF = {{0,0,0,},{0,0,0},{0,1,0},{0,1,0},{1,0,0},{1,0,0},{1,1,0},{1,1,0}};
	
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
				
		int[][] SetsOfInputVariables = {{0,0,0,},{0,0,1},{0,1,0},{0,1,1},{1,0,0},{1,0,1},{1,1,0},{1,1,1}};
		System.out.println("Sets Of Input Variables");
		matrix_output(SetsOfInputVariables, k, m);
		
		int[] f = new int[8];
		
		for (int i=0;i<k;i+=2) {
			f[i] = TruthTable[i/2][2];
			f[i+1] = TruthTable[i/2][2];
//			System.out.println(f[i]);
//			System.out.println(f[i+1]);
		}
		
		for (int i=0;i<k;i++) {
			if ((SetsOfInputVariables[i][2] ^ f[i]) == 1)
				ConvertF[i][2] = 1;
			else
				ConvertF[i][2] = 0;
		}
		System.out.println("Convert F");
		matrix_output(ConvertF, k, m);
		
		
	}
	
	public int[][] transition_matrix() {
		HashMap<String, Integer> ByteRepresentation = new HashMap<String, Integer>();
		ByteRepresentation.put("000", 0);
		ByteRepresentation.put("001", 1);
		ByteRepresentation.put("010", 2);
		ByteRepresentation.put("011", 3);
		ByteRepresentation.put("100", 4);
		ByteRepresentation.put("101", 5);
		ByteRepresentation.put("110", 6);
		ByteRepresentation.put("111", 7);
		
		int[][] TransitionMatrix = new int[k][k];
		String bufer;
		for (int i=0;i<k;i++) {
			bufer = (Integer.toString(ConvertF[i][0])) + Integer.toString(ConvertF[i][1]) + Integer.toString(ConvertF[i][2]);
//			System.out.println(ByteRepresentation.get(bufer));
//			System.out.println(bufer);
			TransitionMatrix[i][ByteRepresentation.get(bufer)] = 1;
		}
		System.out.println("Transition Matrix");
		matrix_output(TransitionMatrix, k, k);
		return TransitionMatrix;
	}
	
	private void unitarity_check(int[][] TransitionMatrix) {
		transposition(TransitionMatrix);
		int[][] Result = new int[k][k];
		
		for (int i=0;i<k;i++) {
			for (int j=0;j<k;j++) {
				for (int t=0;t<k;t++) {
					Result[i][j] += TransitionMatrix[i][t] * TransposedMatrix[t][j];
				}	
			}
		}
		System.out.println("The result of multiplication by the Hermitian conjugate matrix");
		matrix_output(Result, k, k);
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
		if (!flag)
			System.out.println("Matrix is unitarity");
	}
	
	private void transposition(int[][] TransitionMatrix) {
		for (int i=0;i<k;i++) {
			for (int j=0;j<k;j++ ) {
				TransposedMatrix[j][i] = TransitionMatrix[i][j];
			}
		}
		
		System.out.println("Transposed matrix:");
		matrix_output(TransposedMatrix, k, k);
		
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
		func.unitarity_check(func.transition_matrix());
	}
}
