
public class ArithmeticFunction {
	int a = 2;
	int m = 15;
	int size1 = 16;
	int size2 = 4;
	int[][] bits_x = {{0,0,0,0},{0,0,0,1},{0,0,1,0},{0,0,1,1},
					  {0,1,0,0},{0,1,0,1},{0,1,1,0},{0,1,1,1},
					  {1,0,0,0},{1,0,0,1},{1,0,1,0},{1,0,1,1},
					  {1,1,0,0},{1,1,0,1},{1,1,1,0},{1,1,1,1}};
	int[][] bits_f = new int[size1][size2];
	
	
	private ArithmeticFunction() {

	}
	
	private int[][] InitTruthOfTable(int n) {
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
		
//		System.out.println("Truth of table:");
//		
//		for (int i=0;i<rows;i++) {
//			for (int j=0;j<cols;j++) {
//				System.out.print(" " + table[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return table;
			
	}
	
	private void ExpressionEvaluation() {
		String buf="", fBin="";
		int x=0, f=0;
		for (int i=0;i<size1;i++) {
			for (int j=0;j<size2;j++) {
				buf = "" + buf + Integer.toString(bits_x[i][j]);
			}
			
			x = Integer.parseInt(buf, 2);
			System.out.println("x = " + x);
			buf="";
			f = (int) (Math.pow(a, x) % m);
			System.out.println("f = " + f);
			fBin = String.format("%4s", Integer.toBinaryString(f)).replace(' ', '0');
			System.out.println("fBin = " + fBin);
			for (int k=0;k<size2;k++) {
				bits_f[i][k] = Integer.valueOf(String.valueOf(fBin.charAt(k)));
				//System.out.println(bits_f[i][k]);
			}
		}
		System.out.println("bits_x");
		for (int i=0;i<size1;i++) {
			for (int j=0;j<size2;j++) {
				System.out.print(" " + bits_x[i][j] + " ");
			}
			System.out.print("|");
			for (int k=0;k<size2;k++) {
				System.out.print(" " + bits_f[i][k] + " ");
			}
			System.out.println();
		}
		
		int[][] sets_x_y = {};
		int[][] transition_matrix = {};
		int[] f_mas = new int[256];
		
		sets_x_y = InitTruthOfTable(8);
		transition_matrix = InitTruthOfTable(8);
		
		for (int j1=0;j1<4;j1++) {
			for (int l=0;l<256;l+=16) {
				for (int k=0;k<16;k++) {
					f_mas[l+k] = bits_f[l/16][j1];
					//System.out.println("(" + (l+k) + ") " + f_mas[l+k]);
				}
			}
			
			for (int i=0;i<256;i++) {
				transition_matrix[i][j1+4] = sets_x_y[i][j1+4] ^ f_mas[i];
			}
			
		}
		
		
		System.out.println("Truth of table:");
		
		for (int i=0;i<256;i++) {
			for (int j=0;j<8;j++) {
				System.out.print(" " + sets_x_y[i][j] + " ");
			}
			System.out.print("|");
			for (int j=0;j<8;j++) {
				System.out.print(" " + transition_matrix[i][j] + " ");
			}	
			System.out.println();
		}
	}
	
	
	public static void main(String[] str) {
		ArithmeticFunction func = new ArithmeticFunction();
		func.ExpressionEvaluation();
		
		
	    //func.InitTruthOfTable(8);
	}
}
