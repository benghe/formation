package fr.formation.science;

public class Maths {
	public int addition(int a, int b) {
		return a + b;
	}

	public int soustraction(int a, int b) {

//		if(a==9 && b==5) {
//			return 4;
//		}
//		
//		if(a==0 && b==-8) {
//			return -8;
//		}
//		
//		return 0;

		return a - b;
	}

	public double puissance(int a, int b) {

		if (b == 0) {
			return 1;

		} else if (a==0) {
			return 0;
		}
//		else if (a < 0 && b < 0) {
//			int divisor = 1;
//			for (int i = 1; i <= -b; i++) {
//				divisor = divisor * -a;
//			}
//			double result = -1.0 / divisor;
//			return result;
//
//		}
//
//		else if (b < 0) {
//			int divisor = 1;
//			for (int i = 1; i <= -b; i++) {
//				divisor = divisor * a;
//			}
//			double result = 1.0 / divisor;
//			return result;
//		}

		else if (b < 0) {
			int divisor = 1;
			for (int i = 1; i <= -b; i++) {
				divisor = divisor * Math.abs(a);
			}
			double result = (a/Math.abs(a)) * (1.0) / divisor;
			return result;

		} else {

			int result = 1;

			for (int i = 1; i <= b; i++) {
				result = result * a;

			}

			return result;
		}

		
	}

}
