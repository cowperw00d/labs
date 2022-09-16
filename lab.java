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
		int max_num = 0; // for max_length
		int min_num = 0; // for max_length
		for (int i = 0; i < 11; i++){
			for (int j = 0; j < 13; j++){
				if (b[i] == 15){
					g[i][j] = pow( (tan(tan(x[j]))) / (0.75 + sin(x[j] * (4 + x[j]))), 2);
				} else if (b[i] == 8 || b[i] == 9 || b[i] == 11 || b[i] == 12 || b[i] == 16){
					g[i][j] = asin(cos(sin(pow(E, x[j]))));
				} else{
					g[i][j] = cos(pow(0.5 / (1 - pow(2 * pow(0.25 / x[j], x[j]), 3)), 2));
				}

				if ((int)round(g[i][j]) > max_num){
					max_num = (int)round(g[i][j]);
				}
				if ((int)round(g[i][j]) < min_num){
					min_num = (int)round(g[i][j]);
				}
			}
		}

		// count max number of symbols before the dot
		int max_length1 = 0;
		int max_length2 = 0;
		if (max_num > 0){
			max_length1 = 0;
			while (max_num > 0){
				max_num /= 10;
				max_length1++;
			}
		}
		if (min_num < 0){
			max_length2 = 1;
			min_num = abs(min_num);
			while (min_num > 0){
				min_num /= 10;
				max_length2++;
			}
		}
		int max_length = max(max_length1, max_length2);
		//System.out.println(max_length);	

		for (int i = 0; i < 11; i++){
			for (int j = 0; j < 13; j++){
				if (Double.isNaN(g[i][j]) == true) {
					System.out.print("NaN");
					for (int k = 0; k < 3 + max_length; k++){
						System.out.print(" ");
					}
				} else {
					int signs_before_dot = 0;
					int tmp = (int)ceil(g[i][j]);
					if (tmp < 0){
						signs_before_dot++;
						tmp = abs(tmp);
					}
					while(tmp > 0){
						tmp /= 10;
						signs_before_dot++;
					}

					System.out.printf("%.5f", g[i][j]);

					for (int k = 0; k < max_length - signs_before_dot; k++){
						System.out.print(" ");
					}
				}
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
