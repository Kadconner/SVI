import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Qbit extends JPanel {
	static double b0, b1;
	private double[] MatrixAdamar = {1/Math.sqrt(2.0), 1/Math.sqrt(2.0), 1/Math.sqrt(2.0), -1/Math.sqrt(2.0)};
	
	public void paintComponent(Graphics g) {
		this.setBackground(Color.white);
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.drawLine(500, 500, 500, 1000);
		g.drawLine(500, 500, 1000, 500);
		g.drawLine(500, 500, 500, 0);
		g.drawLine(500, 500, 0, 500);
		g.setColor(Color.red);
		
		double B0 = Qbit.Get_b0();
		double B1 = Qbit.Get_b1();
		System.out.println("B0 = " + B0);
		System.out.println("B1 = " + B1);
		//B0 = B0 * 1000 - (B0*1000-500) * 2;
		//B1 = B1 * 1000 - (B1*1000-500) * 2 +250;
		
//		System.out.println("B1 = " + B1);
//		System.out.println("B0 = " + B0);
		
		if (B1 <= 0) {
			B0=B0*1000-(B0*1000-500)*2;
			B1=B1*-1;
			B1=B1*1000-(B1*1000-500)*2;
			//System.out.println("bebrbbrbrbrbr");
			System.out.println("B0 sddfsdf = " + B0);
			System.out.println("B1 sdffsdfsd = " + B1);
		}
		else {
			B0*=1000;
			B1=B1*1000-(B1*1000-500)*2;
		}
		
		
		
		String result0 = String.format("%.0f", B0);
		B0 = Double.parseDouble(result0);
		
		String result1 = String.format("%.0f", B1);
		B1 = Double.parseDouble(result1);
		System.out.println((int)B0);
		System.out.println((int)B1);
		
		g.drawLine(500, 500, (int)B0, (int)B1);
	}
	private Qbit() {
		Scanner scanner = new Scanner(System.in);
		double a0, a1;
		do {
			System.out.println("Enter 2 numbers type of double\nsuch that the sum of their squares is equal to one");
			a0 = scanner.nextDouble();
			a1 = scanner.nextDouble();
		} while(Math.pow(a0, 2) + Math.pow(a1, 2) !=1);
		int[] QubitCondition = new int[2];
		double[] QbitStandartBasis = {0, 0};
		
		if (Math.random() < Math.pow(a0, 2)) {
			System.out.println("Qubit Condition:");
			System.out.println(QubitCondition[0] = 1);
			System.out.println(QubitCondition[1] = 0);
			QbitStandartBasis[0] = a0;
			QbitStandartBasis[1] = a1;
		} 
		else {
			System.out.println("Qubit Condition:");
			System.out.println(QubitCondition[0] = 0);
			System.out.println(QubitCondition[1] = 1);
			QbitStandartBasis[0] = a0;
			QbitStandartBasis[1] = a1;
		}
		
		double[] QbitRotatedBasis = new double[2];
		
		QbitRotatedBasis[0] = MatrixAdamar[0] * QbitStandartBasis[0] + MatrixAdamar[1] * QbitStandartBasis[1];
		QbitRotatedBasis[1] = MatrixAdamar[2] * QbitStandartBasis[0] + MatrixAdamar[3] * QbitStandartBasis[1];
		
		Qbit.Set_b0(QbitRotatedBasis[0]);
		Qbit.Set_b1(QbitRotatedBasis[1]);
		
		System.out.println("RotatedBasis: ");
		System.out.println(QbitRotatedBasis[0]);
		System.out.println(QbitRotatedBasis[1]);
		
	}
	
	public static void Set_b0(double value) {
		b0 = value;
	}
	
	public static void Set_b1(double value) {
		b1 = value;
	}
	
	public static double Get_b0() {
		return b0;
	}
	
	public static double Get_b1() {
		return b1;
	}

	public static void main(String[] str) {
		JFrame frame = new JFrame("Qbit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Qbit qbit = new Qbit();
		frame.add(qbit);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		
	}
}

