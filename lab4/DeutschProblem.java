import lib.*;

public class DeutschProblem {
	
	String qubit1 = "(|0> - |1>)";
	
	public int[][] InitMatrix(int n) {
		AuxiliaryClass Matrix = new AuxiliaryClass();
		int[][] Matrix_X = Matrix.InitTruthOfTable(n);
		return Matrix_X;
	}
	
	public String Hadamar1(int[][] Matrix_X) {
		String qubit0 = "";
		int n = Matrix_X[0].length;
		String koef = (String.format("%.3f", 1.0/(Math.pow(2.0, 1.0/(n+1)))));
		String result = "" + koef + "(";
		
		for (int i=0;i<4;i++) {
			qubit0 = "|";
			for (int j=0;j<2;j++) {
				qubit0 += Matrix_X[i][j];
			}
			qubit0 += ">";
			result += qubit0 + " + ";
		}
		result = result.substring(0, result.length()-3);
		result +=")" + qubit1;
		System.out.println(result);
		return result;
	}
	
	public String Uf(String H1) {
		String result = "";
		result += H1.substring(0, H1.length()-11).replace("|", "(-1)^(f(x))|") + qubit1;
		System.out.println(result);
		return result;
	}
	
	public String H2(String Uf) {
		String result = "";
		System.out.println("1/2^(n) * sum(-1^f(x)");
		return result;
	}
	
	public static void main(String[] str) {
		String H1 = "", H2 = "", Uf = "";
		double value = 0;
		int[][] matrix_f = new int[16][4];
		DeutschProblem lab = new DeutschProblem();
		
		System.out.println("x1 x2 :");
		AuxiliaryClass Matrix = new AuxiliaryClass();
		Matrix.matrix_output(lab.InitMatrix(2), 4, 2);
		System.out.println();
		
		System.out.println("Hadamar transformation");
		H1 = lab.Hadamar1(lab.InitMatrix(2));
		System.out.println();
		System.out.println("bool function transformation");
		Uf = lab.Uf(H1);
		System.out.println();
		System.out.println("Hadamar transformation");
		lab.H2(Uf);
		
		System.out.println();
		matrix_f = lab.InitMatrix(4);
		System.out.println("Matrix all of functions f at 2 variables");
		for (int i=0;i<16;i++) {
			for (int j=0;j<4;j++) {
				System.out.print(" " + matrix_f[i][j] + " ");
				value += Math.pow(-1.0, matrix_f[i][j]);
			}
			value = Math.abs(value * 0.25);
			System.out.print("--> " + value);
			if (value == 1.0)
				System.out.println(" => function is constant");
			else if (value == 0.0)
				System.out.println(" => function is balanced");
			else
				System.out.println(" => the function is neither constant nor balanced");
			value = 0;
		}
	}
}
