package libs;

import java.util.HashMap;

public class Qbit {
	private double[] MatrixAdamar = {1/Math.sqrt(2.0), 1/Math.sqrt(2.0), 1/Math.sqrt(2.0), -1/Math.sqrt(2.0)};
		
		public HashMap<String, Double> Send_Qbit(Double a0, Double a1) {
			double[] QbitStandartBasis = {0.0, 0.0};
			double[] QbitRotatedBasis = new double[2];
			double randnum = Math.random();
			//System.out.println("random = " + randnum);
			
			HashMap<String, Double> Qbit = new HashMap<String, Double>();
			if (randnum < 0.25) {
				QbitStandartBasis[0] = a0;
				QbitStandartBasis[1] = a1;
				Qbit.put("Standart1", a0);
				Qbit.put("Standart2", a1);
				System.out.println("Condition 0");
				return Qbit;
			} 
			else if (randnum < 0.50 && randnum >= 0.25){
				QbitStandartBasis[0] = a1;
				QbitStandartBasis[1] = a0;
				Qbit.put("Standart1", a1);
				Qbit.put("Standart2", a0);
				System.out.println("Condition 1");
				return Qbit;
			}
			else if (randnum < 0.75 && randnum >= 0.50){
				QbitStandartBasis[0] = a0;
				QbitStandartBasis[1] = a1;
				QbitRotatedBasis[0] = MatrixAdamar[0] * QbitStandartBasis[0] + MatrixAdamar[1] * QbitStandartBasis[1];
				QbitRotatedBasis[1] = MatrixAdamar[2] * QbitStandartBasis[0] + MatrixAdamar[3] * QbitStandartBasis[1];
				Qbit.put("Rotated1", QbitRotatedBasis[0]);
				Qbit.put("Rotated2", QbitRotatedBasis[1]);
				System.out.println("Condition 0'");
				return Qbit;
			}
			else if (randnum < 1.00 && randnum >= 0.75) {
				QbitStandartBasis[0] = a1;
				QbitStandartBasis[1] = a0;
				QbitRotatedBasis[0] = MatrixAdamar[2] * QbitStandartBasis[0] + MatrixAdamar[3] * QbitStandartBasis[1];
				QbitRotatedBasis[1] = MatrixAdamar[0] * QbitStandartBasis[0] + MatrixAdamar[1] * QbitStandartBasis[1];
				Qbit.put("Rotated1", QbitRotatedBasis[0]);
				Qbit.put("Rotated2", QbitRotatedBasis[1]);
				System.out.println("Condition 1'");
				return Qbit;
			}
			return null;
	}			
}
