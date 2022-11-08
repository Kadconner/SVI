import lib.*;

public class QuantumParallelism {
	static int[] Vector = {1,0,1,0,1,0,1,0};
	
	private int[] Set_f() {
		int[] f = new int[8];
		
		for (int i=0;i<8;i++) {
			f[i] = (int) (Math.random() * 2);
		}
		return f;
	}
	
	private int[][] ExpressionEvaluation(int[] f, int[][] Matrix_input_vars) {
		int[][] Matrix_f_xor_y = new int[8][3];
		
		for (int j=0;j<2;j++) {
			for (int i=0;i<8;i++) {
				Matrix_f_xor_y[i][j] = Matrix_input_vars[i][j];
			}
		}
		
		for (int i=0;i<8;i++) {
			Matrix_f_xor_y[i][2] = f[i] ^ Matrix_input_vars[i][2];
		}
		
		return Matrix_f_xor_y;
	}
	
	private int[] MultiplyMatrix(int[][] A, int[] B) {
		int[] Result = new int[8];
		
		for (int i=0;i<8;i++) {
			for (int t=0;t<8;t++) {
				Result[i] += A[i][t] * B[t];
			}	
		}
		return Result;
	}
	
	public static void main(String[] str) {
		QuantumParallelism quant = new QuantumParallelism();
		AuxiliaryClass set_input_vars = new AuxiliaryClass();
		
		int[][] Matrix_f_xor_y = new int[8][3];
		int[] f = new int[8];
		
		
		System.out.println("Set input vars:\n x1 x2 y");
		Matrix_f_xor_y = set_input_vars.InitTruthOfTable(3);
		set_input_vars.matrix_output(Matrix_f_xor_y, 8, 3);
		
		System.out.println("\nf:");
		f = quant.Set_f();
		set_input_vars.matrix_output(f, 8, 1);
		
		System.out.println("\nf(+)y:");
		Matrix_f_xor_y = quant.ExpressionEvaluation(f, Matrix_f_xor_y);
		set_input_vars.matrix_output(Matrix_f_xor_y, 8, 3);
		
		Matrix_f_xor_y = set_input_vars.MatrixTransition(Matrix_f_xor_y, 8, 3);
		
		System.out.println("Condition quantum reg:");
		set_input_vars.matrix_output(quant.MultiplyMatrix(Matrix_f_xor_y, Vector), 8, 1);
	}
}
