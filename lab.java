package lab;

import static java.lang.Math.*;

public class lab {

	public static void main(String[] args){

		short[] b = new short[11];
		for (int i = 0; i <= 10; i++){
			b[i] = (short)(i+6);
		}

		double[] x = new double[13];
		for (int i = 0; i < 13; i++){
			double min = -6.0;
			double max = 15.0;
			x[i] = min + (max - min) * random();
		}

		double[][] g = new double[11][13];
		for (int i = 0; i < 11; i++){
			for (int j = 0; j < 13; j++){
				if (b[i] == 15){
					g[i][j] = pow( (tan(tan(x[j]))) / (0.75 + sin(x[j] * (4 + x[j]))), 2);
				} else if (b[i] == 8 || b[i] == 9 || b[i] == 11 || b[i] == 12 || b[i] == 16){
					g[i][j] = asin(cos(sin(pow(E, x[j]))));
				} else{
					g[i][j] = cos(pow(0.5 / (1 - pow(2 * pow(0.25 / x[j], x[j]), 3)), 2));
				}
				
				if (Double.isNaN(g[i][j]) == true) {
					System.out.printf("NaN        ");
				} else {
					int signs_before_dot = 1;
					if (g[i][j] < 0){
						signs_before_dot++;
					}
					if ((int)g[i][j] / 1000 % 10 > 0){
						signs_before_dot += 3;
					} else if ((int)g[i][j] / 100 % 10 > 0){
						signs_before_dot += 2;
					} else if ((int)g[i][j] / 10 % 10 > 0){
						signs_before_dot++;
					}

					System.out.printf("%.5f ", g[i][j]);

					//if (signs_before_dot > 1){System.out.println("alarm!");}

					for (int k = 0; k < 4 - signs_before_dot; k++){
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}

	}

}
