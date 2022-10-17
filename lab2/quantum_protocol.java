import java.util.HashMap;

import libs.*;
public class quantum_protocol {
	public static void main(String[] str) {
		Qbit qbit = new Qbit();
		HashMap<String, Double> Qbit = new HashMap<String, Double>();
		String obsorveble;
		boolean ReliableBit = false;
		boolean T = false;
	
		do {
			System.out.println("1) Subscriber A generated and sent a qubit");
			System.out.println(Qbit = qbit.Send_Qbit(0.0, 1.0));
			
			if (Math.random() <0.5) {
				obsorveble = "Standart";
				System.out.println("2) Subscriber B measured a qubit in a standard basis");
			}
			else {
				obsorveble = "Rotated";
				System.out.println("2) Subscriber B measured a qubit in a rotated basis");
			}
			System.out.println("3) Subscriber B send your obsorveble");
			
			if (Qbit.containsKey("Standart1") && obsorveble.equals("Standart")) {
				if (Qbit.get("Standart1").equals(1.0)) {
					ReliableBit = false;
					//System.out.println("0");
					T = true;
				}
				else {
					ReliableBit = true;
					//System.out.println("1");
					T = true;
				}
				System.out.println("4) OK");
			}
			else if (Qbit.containsKey("Rotated1") && obsorveble.equals("Rotated")) {
				if (Qbit.get("Rotated2").compareTo(0.0) == -1) {
					ReliableBit = false;
					//System.out.println("0'");
					T = true;
				}
				else {
					ReliableBit = true;
					//System.out.println("1'");
					T = true;
				}
				System.out.println("4) OK");
			}
			else 
				System.out.println("4) Repeat\n");
		} while(T == false);
		System.out.println("Shared secret bit: " + ReliableBit);	
	}
}
